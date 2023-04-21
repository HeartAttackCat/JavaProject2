/**
 * @author simplex
 * @file App.java
 * @assignment Project 2
 * @brief Class for admin level interactions.
 */
package DFUsers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import DoughnutFactory.Menu;

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
    public int UInterface(Menu M) {
        String str = "";
        char a = 'a';
        System.out.println("Welcome User!");
        Scanner s = new Scanner(System.in);
        while (a != 'z') {
            System.out.println("Choose one of the following options");
            System.out.println("a. Generate reports");
            System.out.println("z. exit");
            System.out.print("Enter an input: ");

            str = s.nextLine();
            a = str.charAt(0);

            switch (a) {
                // Call functions from the menu class to represent adding, deleting, etc.
                case 'a':
                case 'A':
                    GenerateReports();
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
     */
    void GenerateReports() {
        try {
            FileWriter myWriter = new FileWriter("Reports.txt", false);
            // TODO write reports using order info
            myWriter.close();
            System.out.println("Successfully wrote Report.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
