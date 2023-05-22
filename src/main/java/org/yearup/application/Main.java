package org.yearup.application;

import org.yearup.ui.UserInterface;
import org.yearup.ui.MainMenuUI;

public class Main {
    public static void main(String[] args) {

        // Create an instance of the UserInterface class
        UserInterface userInterface = new UserInterface();
        MainMenuUI mainMenuUi = new MainMenuUI();

        // Call the display method to start the user interface
        mainMenuUi.run();
    }
}