package edu.uco.cs.v2c.desktop.linux.model;

import edu.uco.cs.v2c.desktop.linux.command.KeyboardRobot;

public class Macro {
    String name;
    String description;
    String[] keypresses;
    String directive;
    Boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getKeypresses() {
        return keypresses;
    }

    public void setKeypresses(String[] keypresses) {
        this.keypresses = keypresses;
    }

    public String getDirective() {
        return directive;
    }

    public void setDirective(String directive) {
        this.directive = directive;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void execute() {
        System.out.println("TRYING TO EXECUTE MACRO " + name);    
        try {
            KeyboardRobot keyboardCommandRobot;
            keyboardCommandRobot = new KeyboardRobot();
            for (int i = 0; i < keypresses.length; i++) {
                keyboardCommandRobot.pressString(keypresses[i]);
            }
            keyboardCommandRobot.standardDelay();
            for (int k = 0; k < keypresses.length; k++) {
                keyboardCommandRobot.releaseString(keypresses[k]);
            }

        } catch (Exception e) {
            //TODO: handle exception
        } 
        
    }
}