package org.yearup.application;

import org.yearup.ui.DealershipUI;
import org.yearup.ui.MainMenuUI;

public class Main {
    public static void main(String[] args) {

        // Create an instance of the UserInterface class
        DealershipUI dealershipUI = new DealershipUI();
        MainMenuUI mainMenuUi = new MainMenuUI();

        // Call the display method to start the user interface
        mainMenuUi.run();
    }
}