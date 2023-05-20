package org.yearup.application;

import org.yearup.ui.UserInterface;
import org.yearup.ui.mainUI;

public class Main {
    public static void main(String[] args) {

        // Create an instance of the UserInterface class
        UserInterface userInterface = new UserInterface();
        mainUI mainUi = new mainUI();

        // Call the display method to start the user interface
        mainUi.run();
    }
}