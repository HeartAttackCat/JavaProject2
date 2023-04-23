/**
 * @author simplex
 * @file Employee.java
 * @assignment Project 2
 * @brief User class for actions the employee can do.
 */
package DFUsers;

import DoughnutFactory.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class Employee extends User {

    /**
     * @brief constructor for employee.
     */
    public Employee() {
        super();
    }

/**
     * @brief user interface exclusive to admin class
     * @return exit case
     */
    @Override
    public int UInterface(Menu M, OrderHandler ords,  Menu Mu) {
        String str = "";
        char a = 'a';
        System.out.println("Welcome User!");
        Scanner s = new Scanner(System.in);
        while (a != 'z') {
            System.out.println("Choose one of the following options");
            System.out.println("a. ");
            System.out.println("z. exit");
            System.out.print("Enter an input: ");

            str = s.nextLine();
            a = str.charAt(0);

            switch (a) {
                case 'a':
                case 'A':
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
     * @brief shows the employee all pending orders.
     */
    public void ViewOrders() {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("./Orders.csv"));
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] order = line.split(splitBy);
                if (order[4].equals("pending")) {
                    System.out.println("Order Number: " + order[0]);
                    System.out.println("Order Name: " + order[1]);
                    System.out.println("Order Total Price: " + order[2]);
                    System.out.println("Order Total Quantity: " + order[3]);
                    System.out.println("Order Status: " + order[4]);
                }

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief Updates an existing pending orders process to finished.
     * @return 0 if successful
     */
    public int UpdateOrder() {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("./Orders.csv"));
            FileWriter myWriter = new FileWriter("./Orders.csv", false);
            myWriter.write(br.readLine());
            line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] order = line.split(splitBy);
                myWriter.write("\n");
                myWriter.write(order[0] + order[1] + order[2] + order[3] + order[4] + order[5] + order[6] + order[7]);
                myWriter.write("\n");
            }

            myWriter.close();
            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return 0;
    }
}
