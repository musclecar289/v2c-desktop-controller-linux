/*
 * Copyright (c) 2020 Caleb L. Power, Everistus Akpabio, Rashed Alrashed,
 * Nicholas Clemmons, Jonathan Craig, James Cole Riggall, and Glen Mathew.
 * All rights reserved. Licensed under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.uco.cs.v2c.desktop.linux.model;

import edu.uco.cs.v2c.desktop.linux.command.KeyboardRobot;

public class Macro {
    String name;
    String description;
    String[] keypresses;
    String directive;
    Boolean enabled;

    public Macro(String name, String description, String[] keypresses, String directive, Boolean enabled) {
        this.name = name;
        this.description = description;
        this.keypresses = keypresses;
        this.directive = directive;
        this.enabled = enabled;
    }

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
            // keyboardCommandRobot.standardDelay();
            for (int k = 0; k < keypresses.length; k++) {
                keyboardCommandRobot.releaseString(keypresses[k]);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
