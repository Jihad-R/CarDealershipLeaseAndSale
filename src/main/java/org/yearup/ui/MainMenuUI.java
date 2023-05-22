package org.yearup.ui;

import org.yearup.JavaHelpers.ColorCodes;

import java.util.Scanner;

public class MainMenuUI {

    public void run()
    {
        UserInterface dealershipUI = new UserInterface();
        ContractUI contractUI = new ContractUI();
        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("Welcome");
        System.out.println("What you would you like to do? ");
        System.out.println("1 - Manage Dealership ");
        System.out.println("2 - Manage Lease/Sale Contracts ");
        System.out.println("3 - Exit ");
        System.out.print("Please select a command (1 ,2, or 3): ");
        userInput = scanner.nextLine();

        switch (userInput)
        {
            case "1":{dealershipUI.display();break;}
            case "2":{contractUI.run();break;}
            case "3":
            {
                System.out.println("Thank you for using our services");
                System.exit(1);
                break;}
            default:{
                System.out.println(ColorCodes.YELLOW+"Invalid Input! Please Try again."+ColorCodes.RESET);
            }
        }

    }
}
