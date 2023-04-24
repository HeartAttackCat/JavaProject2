/**
 * @author simplex
 * @file App.java
 * @assignment Project 2
 * @brief Class for admin level interactions.
 */
package DFUsers;

import java.io.*;
import java.util.Scanner;
import DoughnutFactory.*;

public class Administrator extends User {
    /**
     * @brief constructor class for the user
     */
    public Administrator() {
        super();
    }

    /**
     * @brief user interface exclusive to admin class
     * @return exit case
     */
    @Override
    public int UInterface(Menu M, OrderHandler ords) {
        String str1 = "";
        String str2 = "";
        char a = 'a';
        System.out.println("Welcome User!");
        Scanner s = new Scanner(System.in);
        while (a != 'z') {
            System.out.println("Choose one of the following options");
            System.out.println("a. Generate reports");
            System.out.println("b. Add new a menu item");
            System.out.println("c. Delete a menu item");
            System.out.println("d. Edit a menu item.");
            System.out.println("e. view menu");
            System.out.println("z. exit");
            System.out.print("Enter an input: ");

            str1 = s.nextLine();
            a = str1.charAt(0);

            switch (a) {
                // Call functions from the menu class to represent adding, deleting, etc.
                case 'a':
                case 'A':
                    GenerateReports();
                    break;

                case 'b':
                case 'B':
                    M.AddItem(str1, str2, a);
                    break;

                case 'c':
                case 'C':
                    M.DeleteItem(str1, str2);
                    break;

                case 'd':
                case 'D':
                    M.EditItem(str1, str2);
                    break;

                case 'e':
                case 'E':
                    M.ViewMenu();
                    break;

                case 'z':
                case 'Z':
                    return 0;

                default:
                    System.out.println("Error | Unknown input!");
            }
            s.close();
        }

        return 0;
    }

    /**
     * @brief generates sales data reports.
     *        Todo: Last part of user functionally that needs to be added.
     */
    void GenerateReports() {
        Salesrep();
        ExpRep();
    }

    /**
     * @brief generates the sales reports.
     */
    void Salesrep(){

    }

    /**
     * @brief generates the expired reports.
     */
    void ExpRep(){

    }

}
