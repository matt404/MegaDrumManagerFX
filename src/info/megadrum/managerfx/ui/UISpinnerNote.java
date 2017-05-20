package info.megadrum.managerfx.ui;

import info.megadrum.managerfx.ui.UISpinner.IncrementHandler;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public class UISpinnerNote extends UIControl {
	private Spinner<Integer> uispinner;
	private SpinnerValueFactory<Integer> valueFactory;
	private Integer 	minValue;
	private Integer 	maxValue;
	private Integer 	initValue;
	private Integer 	currentValue;
	private Integer 	step;
	private Label 		labelNote;
	private CheckBox	checkBoxNoteLinked;
	private boolean		linkedNote = false;
	private boolean		disabledNoteAllowed = false;
	private GridPane	layoutC;
	private Integer		octaveShift = 0;
	private Integer 	octave;
	private Integer 	note_pointer;
	private static final String [] note_names = {"C ", "C#", "D ", "D#", "E ", "F ", "F#", "G ", "G#", "A ", "A#", "B "};


	public UISpinnerNote(Boolean showCopyButton) {
		super(showCopyButton);
		init();
	}
		
	public UISpinnerNote(String labelText, Boolean showCopyButton) {
		super(labelText, showCopyButton);
		init();
	}

	public UISpinnerNote(String labelText, Boolean showCopyButton, Boolean showLinked) {
		super(labelText, showCopyButton);
		linkedNote =  showLinked;
		init();
	}

	private void init() {
		init(0,127,0,1);
	}
	
	private void init(Integer min, Integer max, Integer initial, Integer s) {
		minValue = min;
		maxValue = max;
		initValue = initial;
		currentValue = initValue;
		step = s;
		valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(minValue, maxValue, initValue, step);

		uispinner = new Spinner<Integer>();
		uispinner.setValueFactory(valueFactory);
		uispinner.setEditable(true);
		//uispinner.getEditor().setStyle("-fx-text-fill: black; -fx-alignment: CENTER_RIGHT;"
		//		);    
		//uispinner.set
		uispinner.getEditor().textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// Spinner number validation
	            if (!newValue.matches("\\d*")) {
	            	uispinner.getEditor().setText(currentValue.toString());
	            } else {
					if (newValue.matches("")) {
						uispinner.getEditor().setText(currentValue.toString());
					} else {
						if (currentValue != Integer.valueOf(newValue)) {
							System.out.printf("%s: new value = %d, old value = %d\n",label.getText(),Integer.valueOf(newValue),currentValue );
							currentValue = Integer.valueOf(newValue);
							intValue = currentValue;
							changeNoteName();
							resizeFont();
						}
					}
	            }
				
			}
	    });
		
		uispinner.getEditor().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    uispinner.increment(1);
                    break;
                case DOWN:
                    uispinner.decrement(1);
                    break;
			default:
				break;
            }
        });
		
	    IncrementHandler handler = new IncrementHandler();
	    uispinner.addEventFilter(MouseEvent.MOUSE_PRESSED, handler);
	    uispinner.addEventFilter(MouseEvent.MOUSE_RELEASED, evt -> {
	        if (evt.getButton() == MouseButton.PRIMARY) {
	            handler.stop();
	        }
	    });
	    
	    layoutC = new GridPane();
	    labelNote = new Label("");
	    checkBoxNoteLinked = new CheckBox();
	    checkBoxNoteLinked.setTooltip(new Tooltip("Linked to Note"));
	    //HBox.setHgrow(labelNote, Priority.ALWAYS);
	    layoutC.setAlignment(Pos.CENTER_LEFT);
	    
		GridPane.setConstraints(uispinner, 0, 0);
		GridPane.setHalignment(uispinner, HPos.LEFT);
		GridPane.setValignment(uispinner, VPos.CENTER);

		GridPane.setConstraints(labelNote, 1, 0);
		GridPane.setHalignment(labelNote, HPos.CENTER);
		GridPane.setValignment(labelNote, VPos.CENTER);

		GridPane.setConstraints(checkBoxNoteLinked, 2, 0);
		GridPane.setHalignment(checkBoxNoteLinked, HPos.RIGHT);
		GridPane.setValignment(checkBoxNoteLinked, VPos.CENTER);

		if (linkedNote) {
			layoutC.getChildren().addAll(uispinner,labelNote,checkBoxNoteLinked);			
		} else {
			layoutC.getChildren().addAll(uispinner,labelNote);
		}

		//initControl(uispinner);
		changeNoteName();
		initControl(layoutC);
	}

    class IncrementHandler implements EventHandler<MouseEvent> {

        private Spinner<?> spinner;
        private boolean increment;
        private long startTimestamp;

        private static final long DELAY = 1000l * 1000L * 750L; // 0.75 sec
        private Node button;

        private final AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {
                if (now - startTimestamp >= DELAY) {
                    // trigger updates every frame once the initial delay is over
                    if (increment) {
                        spinner.increment();
                    } else {
                        spinner.decrement();
                    }
                }
            }
        };

        @Override
        public void handle(MouseEvent event) {
            if (event.getButton() == MouseButton.PRIMARY) {
                Spinner<?> source = (Spinner<?>) event.getSource();
                Node node = event.getPickResult().getIntersectedNode();

                Boolean increment = null;
                // find which kind of button was pressed and if one was pressed
                while (increment == null && node != source) {
                    if (node.getStyleClass().contains("increment-arrow-button")) {
                        increment = Boolean.TRUE;
                    } else if (node.getStyleClass().contains("decrement-arrow-button")) {
                        increment = Boolean.FALSE;
                    } else {
                        node = node.getParent();
                    }
                }
                if (increment != null) {
                    event.consume();
                    source.requestFocus();
                    spinner = source;
                    this.increment = increment;

                    // timestamp to calculate the delay
                    startTimestamp = System.nanoTime();

                    button = node;

                    // update for css styling
                    node.pseudoClassStateChanged(PseudoClass.getPseudoClass("pressed"), true);

                    // first value update
                    timer.handle(startTimestamp + DELAY);

                    // trigger timer for more updates later
                    timer.start();
                }
            }
        }
        public void stop() {
            timer.stop();
            if (button != null) {
            	button.pseudoClassStateChanged(PseudoClass.getPseudoClass("pressed"), false);
            	button = null;
            	spinner = null;
            }
        }

    }
    private void resizeFont() {
		Double we = uispinner.getEditor().getWidth();
		Integer l = valueFactory.getValue().toString().length();
		Double ll = (4/(4 + l.doubleValue()))*1.8;
		we = we*ll;
		//uispinner.getEditor().setFont(new Font(h*0.4));
		uispinner.getEditor().setFont(new Font(we*0.25));    	
    }

    @Override
    public void respondToResize(Double h, Double w) {
    	super.respondToResize(h, w);
		uispinner.setMinHeight(h);
		uispinner.setMaxHeight(h);
		uispinner.setMaxWidth(w*0.17);
		uispinner.setMinWidth(w*0.17);
		
		layoutC.getColumnConstraints().clear();
		//layoutC.getColumnConstraints().add(new ColumnConstraints((w - padding*2)*0.2 + 30));
		layoutC.getColumnConstraints().add(new ColumnConstraints(w*0.17));
		if (linkedNote) {
			layoutC.getColumnConstraints().add(new ColumnConstraints(w*0.10));
			layoutC.getColumnConstraints().add(new ColumnConstraints(w*0.08));			
		} else {
			layoutC.getColumnConstraints().add(new ColumnConstraints(w*0.17));
			layoutC.getColumnConstraints().add(new ColumnConstraints(w*0.01));
		}
		layoutC.getRowConstraints().clear();
		layoutC.getRowConstraints().add(new RowConstraints(h-padding*2 - 1));

		// Spinner buttons width seems to be fixed and not adjustable
		//uispinner.setStyle("-fx-body-color: ladder(#444, yellow 0%, red 100%)");
		
		resizeFont();
		if (linkedNote) {
			labelNote.setFont(new Font(h*0.28));			
		} else {
			labelNote.setFont(new Font(h*0.35));
		}
    }
    
    public void changeNoteName() {
		int note_number;
		int base;
		String note_text;
		note_number = currentValue;
		if ((note_number > 0) || (!disabledNoteAllowed)) {
			octave = note_number/12 ;
			base = octave*12;
			note_pointer = note_number - base;
			note_text = note_names[note_pointer] + " " + Integer.toString(octave - 3 + octaveShift);
			labelNote.setText(note_text);
			labelNote.setTooltip(new Tooltip("Note = " + note_text));
		} else {
			labelNote.setText("Disbld");
			labelNote.setTooltip(new Tooltip("Note Disabled"));
		}		
    }
    
    public void setDisabledNoteAllowed(Boolean b) {
    	disabledNoteAllowed = b;
    	changeNoteName();
    }

/*
    @Override
	public void setControlMinWidth(Double w) {
    	// don't change spinner control width so override setControlMinWidth here
	}
*/
}
