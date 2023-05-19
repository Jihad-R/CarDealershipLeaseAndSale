package org.yearup.ui;

import java.util.Scanner;

public class mainUI {

    public void run()
    {
        UserInterface dealershipUI = new UserInterface();
        ContractUI contractUI = new ContractUI();
        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("Welcome");
        System.out.println("What you would you like to do? ");
        System.out.println("1 - View Dealership Options ");
        System.out.println("2 - Lease/Buy a vehicle ");
        System.out.print("Please select a command (1,2): ");
        userInput = scanner.nextLine();

        switch (userInput)
        {
            case "1":{dealershipUI.display();break;}
            case "2":{contractUI.run();break;}
            default:
        }

    }
}
