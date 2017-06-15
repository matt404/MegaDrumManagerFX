package info.megadrum.managerfx.data;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.PropertiesConfigurationLayout;

import info.megadrum.managerfx.utils.Constants;
import info.megadrum.managerfx.utils.Utils;

public class ConfigPedal {
	public boolean type;
	public boolean new_algorithm;
	public boolean autoLevels;
	public boolean altIn;
	public boolean reverseLevels;
	public int curve;
	public int chickDelay;
	public int cc;
	public int ccRdcLvl;
	public int lowLevel;
	public int highLevel;
	public int openLevel;
	public int chickThres;
	public int closedLevel;
	public int shortThres;
	public int longThres;
	public int hhInput = 2;
	public boolean softChicks;
	public int semiOpenLevel;
	public int semiOpenLevel2;
	public int halfOpenLevel;
	public int halfOpenLevel2;
	public int chickCurve;
	public int chickParam1;
	public int chickParam2;
	public int chickParam3;
	public int bowSemiOpenNote;
	public int edgeSemiOpenNote;
	public int bellSemiOpenNote;
	public int bowSemiOpen2Note;
	public int edgeSemiOpen2Note;
	public int bellSemiOpen2Note;
	public int bowHalfOpenNote;
	public int edgeHalfOpenNote;
	public int bellHalfOpenNote;
	public int bowHalfOpen2Note;
	public int edgeHalfOpen2Note;
	public int bellHalfOpen2Note;
	public int bowSemiClosedNote;
	public int edgeSemiClosedNote;
	public int bellSemiClosedNote;
	public int bowClosedNote;
	public int edgeClosedNote;
	public int bellClosedNote;
	public int chickNote;
	public int splashNote;
	public int syncState = Constants.SYNC_STATE_UNKNOWN;
	public boolean sysexReceived = false;
	
	
	public ConfigPedal (){
	}
	public void copyToPropertiesConfiguration(PropertiesConfiguration prop, PropertiesConfigurationLayout layout, String prefix) {
		layout.setComment(prefix+"type", "\n#Pedal settings");
		prop.setProperty(prefix+"type", type);
		prop.setProperty(prefix+"new_algorithm", new_algorithm);
		prop.setProperty(prefix+"autoLevels", autoLevels);
		prop.setProperty(prefix+"altIn", altIn);
		prop.setProperty(prefix+"reverseLevels", reverseLevels);
		prop.setProperty(prefix+"curve", curve);
		prop.setProperty(prefix+"chickDelay", chickDelay);
		prop.setProperty(prefix+"cc", cc);
		prop.setProperty(prefix+"ccRdcLvl", ccRdcLvl);
		prop.setProperty(prefix+"lowLevel", lowLevel);		
		prop.setProperty(prefix+"highLevel", highLevel);
		prop.setProperty(prefix+"openLevel", openLevel);
		prop.setProperty(prefix+"closedLevel", closedLevel);
		prop.setProperty(prefix+"shortThres", shortThres);
		prop.setProperty(prefix+"longThres", longThres);
		prop.setProperty(prefix+"chickThres", chickThres);
		prop.setProperty(prefix+"hhInput", hhInput);
		prop.setProperty(prefix+"softChicks", softChicks);
		prop.setProperty(prefix+"semiOpenLevel", semiOpenLevel);
		prop.setProperty(prefix+"halfOpenLevel", halfOpenLevel);
		prop.setProperty(prefix+"semiOpenLevel2", semiOpenLevel2);
		prop.setProperty(prefix+"halfOpenLevel2", halfOpenLevel2);
		prop.setProperty(prefix+"chickCurve", chickCurve);
		prop.setProperty(prefix+"chickPeriodShort", chickParam1);
		prop.setProperty(prefix+"chickPeriodLong", chickParam2);	
		prop.setProperty(prefix+"chickPeriodDead", chickParam3);	
		prop.setProperty(prefix+"bowSemiOpenNote", bowSemiOpenNote);
		prop.setProperty(prefix+"edgeSemiOpenNote", edgeSemiOpenNote);
		prop.setProperty(prefix+"bellSemiOpenNote", bellSemiOpenNote);
		prop.setProperty(prefix+"bowSemiOpen2Note", bowSemiOpen2Note);
		prop.setProperty(prefix+"edgeSemiOpen2Note", edgeSemiOpen2Note);
		prop.setProperty(prefix+"bellSemiOpen2Note", bellSemiOpen2Note);
		prop.setProperty(prefix+"bowHalfOpenNote", bowHalfOpenNote);
		prop.setProperty(prefix+"edgeHalfOpenNote", edgeHalfOpenNote);
		prop.setProperty(prefix+"bellHalfOpenNote", bellHalfOpenNote);
		prop.setProperty(prefix+"bowHalfOpen2Note", bowHalfOpen2Note);
		prop.setProperty(prefix+"edgeHalfOpen2Note", edgeHalfOpen2Note);
		prop.setProperty(prefix+"bellHalfOpen2Note", bellHalfOpen2Note);
		prop.setProperty(prefix+"bowSemiClosedNote", bowSemiClosedNote);		
		prop.setProperty(prefix+"edgeSemiClosedNote", edgeSemiClosedNote);
		prop.setProperty(prefix+"bellSemiClosedNote", bellSemiClosedNote);
		prop.setProperty(prefix+"bowClosedNote", bowClosedNote);
		prop.setProperty(prefix+"edgeClosedNote", edgeClosedNote);
		prop.setProperty(prefix+"bellClosedNote", bellClosedNote);
		prop.setProperty(prefix+"chickNote", chickNote);
		prop.setProperty(prefix+"splashNote", splashNote);
		
	}

	public void copyFromPropertiesConfiguration(PropertiesConfiguration prop, String prefix) {
		type = prop.getBoolean(prefix+"type", type);
		new_algorithm = prop.getBoolean(prefix+"new_algorithm", new_algorithm);
		autoLevels = prop.getBoolean(prefix+"autoLevels", autoLevels);
		altIn = prop.getBoolean(prefix+"altIn", altIn);
		reverseLevels = prop.getBoolean(prefix+"reverseLevels", reverseLevels);
		curve = Utils.validateInt(prop.getInt(prefix+"curve", curve),0,15,curve);
		chickDelay = Utils.validateInt(prop.getInt(prefix+"chickDelay", chickDelay),0,127,chickDelay);
		cc = Utils.validateInt(prop.getInt(prefix+"cc", cc),0,127,cc);
		ccRdcLvl = Utils.validateInt(prop.getInt(prefix+"ccRdcLvl", ccRdcLvl),0,127,ccRdcLvl);
		lowLevel = Utils.validateInt(prop.getInt(prefix+"lowLevel", lowLevel),0,1023,lowLevel);		
		highLevel = Utils.validateInt(prop.getInt(prefix+"highLevel", highLevel),0,1023,highLevel);
		openLevel = Utils.validateInt(prop.getInt(prefix+"openLevel", openLevel),0,127,openLevel);
		closedLevel = Utils.validateInt(prop.getInt(prefix+"closedLevel", closedLevel),0,127,closedLevel);
		shortThres = Utils.validateInt(prop.getInt(prefix+"shortThres", shortThres),0,127,shortThres);
		longThres = Utils.validateInt(prop.getInt(prefix+"longThres", longThres),0,127,longThres);
		hhInput = Utils.validateInt(prop.getInt(prefix+"hhInput", hhInput),2,127,hhInput);
		softChicks = prop.getBoolean(prefix+"softChicks", softChicks);
		semiOpenLevel = Utils.validateInt(prop.getInt(prefix+"semiOpenLevel", semiOpenLevel),0,127,semiOpenLevel);
		halfOpenLevel = Utils.validateInt(prop.getInt(prefix+"halfOpenLevel", halfOpenLevel),0,127,halfOpenLevel);
		semiOpenLevel2 = Utils.validateInt(prop.getInt(prefix+"semiOpenLevel2", semiOpenLevel2),0,127,semiOpenLevel2);
		halfOpenLevel2 = Utils.validateInt(prop.getInt(prefix+"halfOpenLevel2", halfOpenLevel2),0,127,halfOpenLevel2);
		chickCurve = Utils.validateInt(prop.getInt(prefix+"chickCurve", chickCurve),0,15,chickCurve);
		chickParam1 = Utils.validateInt(prop.getInt(prefix+"chickPeriodShort", chickParam1),0,1023,chickParam1);
		chickParam2 = Utils.validateInt(prop.getInt(prefix+"chickPeriodLong", chickParam2),0,1023,chickParam2);
		chickParam3 = Utils.validateInt(prop.getInt(prefix+"chickPeriodDead", chickParam3),0,1023,chickParam3);
		bowSemiOpenNote = Utils.validateInt(prop.getInt(prefix+"bowSemiOpenNote", bowSemiOpenNote),0,127,bowSemiOpenNote);
		edgeSemiOpenNote = Utils.validateInt(prop.getInt(prefix+"edgeSemiOpenNote", edgeSemiOpenNote),0,127,edgeSemiOpenNote);
		bellSemiOpenNote = Utils.validateInt(prop.getInt(prefix+"bellSemiOpenNote", bellSemiOpenNote),0,127,bellSemiOpenNote);
		bowSemiOpen2Note = Utils.validateInt(prop.getInt(prefix+"bowSemiOpen2Note", bowSemiOpen2Note),0,127,bowSemiOpen2Note);
		edgeSemiOpen2Note = Utils.validateInt(prop.getInt(prefix+"edgeSemiOpen2Note", edgeSemiOpen2Note),0,127,edgeSemiOpen2Note);
		bellSemiOpen2Note = Utils.validateInt(prop.getInt(prefix+"bellSemiOpen2Note", bellSemiOpen2Note),0,127,bellSemiOpen2Note);
		bowHalfOpenNote = Utils.validateInt(prop.getInt(prefix+"bowHalfOpenNote", bowHalfOpenNote),0,127,bowHalfOpenNote);
		edgeHalfOpenNote = Utils.validateInt(prop.getInt(prefix+"edgeHalfOpenNote", edgeHalfOpenNote),0,127,edgeHalfOpenNote);
		bellHalfOpenNote = Utils.validateInt(prop.getInt(prefix+"bellHalfOpenNote", bellHalfOpenNote),0,127,bellHalfOpenNote);
		bowHalfOpen2Note = Utils.validateInt(prop.getInt(prefix+"bowHalfOpen2Note", bowHalfOpen2Note),0,127,bowHalfOpen2Note);
		edgeHalfOpen2Note = Utils.validateInt(prop.getInt(prefix+"edgeHalfOpen2Note", edgeHalfOpen2Note),0,127,edgeHalfOpen2Note);
		bellHalfOpen2Note = Utils.validateInt(prop.getInt(prefix+"bellHalfOpen2Note", bellHalfOpen2Note),0,127,bellHalfOpen2Note);
		bowSemiClosedNote = Utils.validateInt(prop.getInt(prefix+"bowSemiClosedNote", bowSemiClosedNote),0,127,bowSemiClosedNote);		
		edgeSemiClosedNote = Utils.validateInt(prop.getInt(prefix+"edgeSemiClosedNote", edgeSemiClosedNote),0,127,edgeSemiClosedNote);
		bellSemiClosedNote = Utils.validateInt(prop.getInt(prefix+"bellSemiClosedNote", bellSemiClosedNote),0,127,bellSemiClosedNote);
		bowClosedNote = Utils.validateInt(prop.getInt(prefix+"bowClosedNote", bowClosedNote),0,127,bowClosedNote);
		edgeClosedNote = Utils.validateInt(prop.getInt(prefix+"edgeClosedNote", edgeClosedNote),0,127,edgeClosedNote);
		bellClosedNote = Utils.validateInt(prop.getInt(prefix+"bellClosedNote", bellClosedNote),0,127,bellClosedNote);
		chickNote = Utils.validateInt(prop.getInt(prefix+"chickNote", chickNote),0,127,chickNote);
		splashNote = Utils.validateInt(prop.getInt(prefix+"splashNote", splashNote),0,127,splashNote);
		chickThres = Utils.validateInt(prop.getInt(prefix+"chickThres", chickThres),0,127,chickThres);
	}
	
	public void setConfigFromSysex(byte [] sysex, int mcu_type) {
		int sysex_length = Constants.MD_SYSEX_PEDAL_SIZE;
		if (mcu_type == Constants.MCU_TYPE_STM32F205TEST1) {
			sysex_length = Constants.MD_SYSEX_PEDAL_SIZE_OLD;
		}
		byte [] sysex_byte = new byte[2];
		byte [] sysex_short = new byte[4];
		byte flags;
		int i = 4;
		if (sysex.length >= sysex_length) {
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			flags = Utils.sysex2byte(sysex_byte);
			type = ((flags&1) != 0);
			autoLevels = ((flags&(1<<1)) != 0);
			altIn = ((flags&(1<<2)) != 0);
			reverseLevels = ((flags&(1<<3)) != 0);
			curve = ((flags&0xf0)>>4);
			
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			chickDelay = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			cc = Utils.sysex2byte(sysex_byte);
			sysex_short[0] = sysex[i++];
			sysex_short[1] = sysex[i++];
			sysex_short[2] = sysex[i++];
			sysex_short[3] = sysex[i++];
			lowLevel = Utils.sysex2short(sysex_short);
			sysex_short[0] = sysex[i++];
			sysex_short[1] = sysex[i++];
			sysex_short[2] = sysex[i++];
			sysex_short[3] = sysex[i++];
			highLevel = Utils.sysex2short(sysex_short);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			openLevel = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			closedLevel = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			shortThres = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			longThres = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			hhInput = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			flags = Utils.sysex2byte(sysex_byte);
			softChicks = ((flags&1) != 0);
			ccRdcLvl = ((flags&0x06)>>1);
			new_algorithm = (((flags&0x08)>>3) != 0);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			semiOpenLevel = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			halfOpenLevel = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			chickThres = Utils.sysex2byte(sysex_byte);
			sysex_short[0] = sysex[i++];
			sysex_short[1] = sysex[i++];
			sysex_short[2] = sysex[i++];
			sysex_short[3] = sysex[i++];
			chickParam1 = Utils.sysex2short(sysex_short);
			sysex_short[0] = sysex[i++];
			sysex_short[1] = sysex[i++];
			sysex_short[2] = sysex[i++];
			sysex_short[3] = sysex[i++];
			chickParam2 = Utils.sysex2short(sysex_short);
			sysex_short[0] = sysex[i++];
			sysex_short[1] = sysex[i++];
			sysex_short[2] = sysex[i++];
			sysex_short[3] = sysex[i++];
			chickParam3 = Utils.sysex2short(sysex_short);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			flags = Utils.sysex2byte(sysex_byte);
			chickCurve = (flags&0x0f);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			if (mcu_type != Constants.MCU_TYPE_STM32F205TEST1) {
				semiOpenLevel2 = Utils.sysex2byte(sysex_byte);
				sysex_byte[0] = sysex[i++];
				sysex_byte[1] = sysex[i++];
				halfOpenLevel2 = Utils.sysex2byte(sysex_byte);
				sysex_byte[0] = sysex[i++];
				sysex_byte[1] = sysex[i++];
			}
			bowSemiOpenNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			edgeSemiOpenNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			bellSemiOpenNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			if (mcu_type != Constants.MCU_TYPE_STM32F205TEST1) {
				bowSemiOpen2Note = Utils.sysex2byte(sysex_byte);
				sysex_byte[0] = sysex[i++];
				sysex_byte[1] = sysex[i++];
				edgeSemiOpen2Note = Utils.sysex2byte(sysex_byte);
				sysex_byte[0] = sysex[i++];
				sysex_byte[1] = sysex[i++];
				bellSemiOpen2Note = Utils.sysex2byte(sysex_byte);
				sysex_byte[0] = sysex[i++];
				sysex_byte[1] = sysex[i++];
			}
			bowHalfOpenNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			edgeHalfOpenNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			bellHalfOpenNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			if (mcu_type != Constants.MCU_TYPE_STM32F205TEST1) {
				bowHalfOpen2Note = Utils.sysex2byte(sysex_byte);
				sysex_byte[0] = sysex[i++];
				sysex_byte[1] = sysex[i++];
				edgeHalfOpen2Note = Utils.sysex2byte(sysex_byte);
				sysex_byte[0] = sysex[i++];
				sysex_byte[1] = sysex[i++];
				bellHalfOpen2Note = Utils.sysex2byte(sysex_byte);
				sysex_byte[0] = sysex[i++];
				sysex_byte[1] = sysex[i++];
			}
			bowSemiClosedNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			edgeSemiClosedNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			bellSemiClosedNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			bowClosedNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			edgeClosedNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			bellClosedNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			chickNote = Utils.sysex2byte(sysex_byte);
			sysex_byte[0] = sysex[i++];
			sysex_byte[1] = sysex[i++];
			splashNote = Utils.sysex2byte(sysex_byte);
		}
	}
	
	public byte[] getSysexFromConfig(int mcu_type) {
		byte [] sysex_byte = new byte[2];
		byte [] sysex_short = new byte[4];
		int sysex_length = Constants.MD_SYSEX_PEDAL_SIZE;
		if (mcu_type == Constants.MCU_TYPE_STM32F205TEST1) {
			sysex_length = Constants.MD_SYSEX_PEDAL_SIZE_OLD;
		}
		byte [] sysex = new byte[sysex_length];
		byte flags;
		int i = 0;

		sysex[i++] = Constants.SYSEX_START;
		sysex[i++] = Constants.MD_SYSEX;
		sysex[i++] = 0; //(byte) chainId;
		sysex[i++] = Constants.MD_SYSEX_PEDAL;

		flags = (byte) (((type)?1:0)|(((autoLevels)?1:0)<<1)|(((altIn)?1:0)<<2)|(((reverseLevels)?1:0)<<3)
				|(curve<<4));
		sysex_byte = Utils.byte2sysex(flags);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)chickDelay);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)cc);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_short = Utils.short2sysex((short)lowLevel);
		sysex[i++] = sysex_short[0];
		sysex[i++] = sysex_short[1];
		sysex[i++] = sysex_short[2];
		sysex[i++] = sysex_short[3];
		sysex_short = Utils.short2sysex((short)highLevel);
		sysex[i++] = sysex_short[0];
		sysex[i++] = sysex_short[1];
		sysex[i++] = sysex_short[2];
		sysex[i++] = sysex_short[3];
		sysex_byte = Utils.byte2sysex((byte)openLevel);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)closedLevel);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)shortThres);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)longThres);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)hhInput);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		flags = (byte) ((softChicks)?1:0);
		flags = (byte) (flags|(ccRdcLvl<<1));
		flags = (byte) (flags|((new_algorithm?1:0)<<3));
		sysex_byte = Utils.byte2sysex((byte)flags);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)semiOpenLevel);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)halfOpenLevel);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)chickThres);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_short = Utils.short2sysex((short)chickParam1);
		sysex[i++] = sysex_short[0];
		sysex[i++] = sysex_short[1];
		sysex[i++] = sysex_short[2];
		sysex[i++] = sysex_short[3];
		sysex_short = Utils.short2sysex((short)chickParam2);
		sysex[i++] = sysex_short[0];
		sysex[i++] = sysex_short[1];
		sysex[i++] = sysex_short[2];
		sysex[i++] = sysex_short[3];
		sysex_short = Utils.short2sysex((short)chickParam3);
		sysex[i++] = sysex_short[0];
		sysex[i++] = sysex_short[1];
		sysex[i++] = sysex_short[2];
		sysex[i++] = sysex_short[3];
		flags = (byte) (chickCurve);
		sysex_byte = Utils.byte2sysex(flags);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		if (mcu_type != Constants.MCU_TYPE_STM32F205TEST1) {
			sysex_byte = Utils.byte2sysex((byte)semiOpenLevel2);
			sysex[i++] = sysex_byte[0];
			sysex[i++] = sysex_byte[1];
			sysex_byte = Utils.byte2sysex((byte)halfOpenLevel2);
			sysex[i++] = sysex_byte[0];
			sysex[i++] = sysex_byte[1];
		}
		sysex_byte = Utils.byte2sysex((byte)bowSemiOpenNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)edgeSemiOpenNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)bellSemiOpenNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		if (mcu_type != Constants.MCU_TYPE_STM32F205TEST1) {
			sysex_byte = Utils.byte2sysex((byte)bowSemiOpen2Note);
			sysex[i++] = sysex_byte[0];
			sysex[i++] = sysex_byte[1];
			sysex_byte = Utils.byte2sysex((byte)edgeSemiOpen2Note);
			sysex[i++] = sysex_byte[0];
			sysex[i++] = sysex_byte[1];
			sysex_byte = Utils.byte2sysex((byte)bellSemiOpen2Note);
			sysex[i++] = sysex_byte[0];
			sysex[i++] = sysex_byte[1];
		}
		sysex_byte = Utils.byte2sysex((byte)bowHalfOpenNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)edgeHalfOpenNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)bellHalfOpenNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		if (mcu_type != Constants.MCU_TYPE_STM32F205TEST1) {
			sysex_byte = Utils.byte2sysex((byte)bowHalfOpen2Note);
			sysex[i++] = sysex_byte[0];
			sysex[i++] = sysex_byte[1];
			sysex_byte = Utils.byte2sysex((byte)edgeHalfOpen2Note);
			sysex[i++] = sysex_byte[0];
			sysex[i++] = sysex_byte[1];
			sysex_byte = Utils.byte2sysex((byte)bellHalfOpen2Note);
			sysex[i++] = sysex_byte[0];
			sysex[i++] = sysex_byte[1];
		}
		sysex_byte = Utils.byte2sysex((byte)bowSemiClosedNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)edgeSemiClosedNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)bellSemiClosedNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)bowClosedNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)edgeClosedNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)bellClosedNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)chickNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex_byte = Utils.byte2sysex((byte)splashNote);
		sysex[i++] = sysex_byte[0];
		sysex[i++] = sysex_byte[1];
		sysex[i++] = Constants.SYSEX_END;
		return sysex;
	}


}
