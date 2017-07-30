# MegaDrumManagerFX

### Summary
MegaDrumManagerFX is a utility for managing the settings
of the MegaDrum drum module.  For more information about MegaDrum, 
including how to build or buy one for yourself, see 
http://megadrum.info

### Download the latest build of this fork here:
* https://repo.mgr.cloud/info/megadrum/managerfx/MegaDrumManagerFX.jar

### Workspace Pre-Requisites
* JDK 1.8
* IntelliJ Community (it's free) or Eclipse IDE
    * https://www.jetbrains.com/idea/download

### Setting Up IntelliJ
1. Clone the repo
2. Open IntelliJ and select `File > New > Project from existing sources`
3. Select 'eclipse' as the template to import from
4. Open module settings and select the JDK (if it's not already set correctly)
5. Setup a debug configuration
    * Click the configuration drop-down in the toolbar.
    * Go to 'edit configurations'
    * Add a new 'Application' type configuration
    * Enter a descriptive name in your configuration.
    * Enter 'info.megadrum.managerfx.Main' as the main class
    
### Building the Jar with IntelliJ
1. Open `View > Tool Windows > Ant Build`
2. Click the add button (+)
3. Select build.xml in the root directory
4. Run the 'main' Ant command
5. The freshly built jar can be found in the 'dist' folder.

