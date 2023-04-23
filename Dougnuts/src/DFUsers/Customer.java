/**
 * @author simplex
 * @file App.java
 * @assignment Project 2
 * @brief Class for user interactions by a customer.
 */
package DFUsers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import DoughnutFactory.*;

public class Customer extends User {

    /**
     * @brief constructor class for customer.
     */
    public Customer() {
        super();
    }

    /**
     * @brief user interface for the current class for inputting password. This
     *        iteration is for when the user first enters the system.
     * @note: All classes will need their own override.
     * @return exit status
     */
    @Override
    public int UInterface(Menu M, OrderHandler ords) {
        String str = "";
        char a = 'a';
        System.out.println("Welcome valued customer!");
        Scanner s = new Scanner(System.in);
        while (a != 'z') {
            System.out.println("----");
            System.out.println("Choose one of the following options");
            System.out.println("-----");
            System.out.println("a. ");
            System.out.println("z. exit");
            System.out.print("Enter an input: ");

            str = s.nextLine();
            a = str.charAt(0);

            switch (a) {
                case 'a':
                case 'A':
                    M.ViewMenu();
                    break;

                case 'b':
                case 'B':
                    PlaceOrder();
                    break;

                case 'z':
                case 'Z':
                    return 0;

                default:
                    System.out.println("Error | Unknown input!");
            }
        }
        s.close();

        return 0;
    }

    /**
     * @brief places an order.
     */
    void PlaceOrder() {
        try {
            FileWriter myWriter = new FileWriter("Orders", true);
            // TODO write person's order to Orders.csv
            myWriter.close();
            System.out.println("Successfully wrote Report.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
