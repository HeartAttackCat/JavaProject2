/**
 * @author simplex
 * @file App.java
 * @assignment Project 2
 * @brief Class for user interactions by a customer.
 */
package DFUsers;

import java.util.Scanner;
import java.util.ArrayList;
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
    public int UInterface(Menu M, OrderHandler ords, Scanner s) {
        String str = "";
        char a = 'a';
        System.out.println("Welcome valued customer!");
        while (a != 'z') {
            System.out.println("----");
            System.out.println("Choose one of the following options");
            System.out.println("-----");
            System.out.println("a. View Menu");
            System.out.println("b. Place Order");
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
                    PlaceOrder(M, ords);
                    break;

                case 'z':
                case 'Z':
                    return -1;

                default:
                    System.out.println("Error | Unknown input!");
            }
        }
    

        return 0;
    }

    /**
     * @brief places an order.
     * @param M   Current Menu class
     * @param ord orderhandler
     *            TODO: Check if an item is currently avaible.
     */
    void PlaceOrder(Menu M, OrderHandler ord) {
        char a = '-';
        int quant = 0;
        int index = 0;
        float price = 0;

        Order neword;
        Doughnut temp;
        String str1 = "";
        String str2 = "";
        String str3 = "";
        Scanner sc = new Scanner(System.in);

        ArrayList<DoughnutStack> cord = new ArrayList<DoughnutStack>();

        while (a != 'z') {
            System.out.println("----");
            System.out.println("Choose one of the following options");
            System.out.println("-----");
            System.out.println("a. View Menu");
            System.out.println("b. Add item to order");
            System.out.println("c. View current order");
            System.out.println("d. remove item");
            System.out.println("e. Finalize order");
            System.out.println("z. exit");
            System.out.print("Enter an input: ");

            str1 = sc.nextLine();
            a = str1.charAt(0);

            switch (a) {
                // Views menu
                case 'a':
                case 'A':
                    M.ViewMenu();
                    break;

                // Adds an item to the cart
                case 'b':
                case 'B':
                    System.out.print("Please enter the item's catagory: ");
                    str1 = sc.nextLine();
                    System.out.print("Please enter the item's sub catagory: ");
                    str2 = sc.nextLine();
                    index = M.IsItem(str1, str2);
                    if (index >= 0) {
                        System.out.print("How many would you like: ");
                        str3 = sc.nextLine();
                        quant = Integer.parseInt(str3);
                        price = M.GetPrice(index);
                        temp = new Doughnut(str2, str1, price);
                        cord.add(new DoughnutStack(temp, quant));
                    } else {
                        System.out.println("Error | invalid item");
                    }

                    break;

                // prints out current cart
                case 'c':
                case 'C':
                    System.out.println("Your current order:");
                    System.out.println("-----");
                    for (int i = 0; i < cord.size(); i++) {
                        System.out.println("-----");
                        cord.get(i).PrintStackInfo();
                        System.out.println("-----");
                    }
                    System.out.println("-----");
                    System.out.println("Total Price: " + price);
                    break;

                // Deletes an item from the cart
                case 'd':
                case 'D':
                    // Prints out condensed version of current cart.
                    for (int i = 0; i < cord.size(); i++) {
                        System.out.print(i + ". " + cord.get(i).DoughnutType.catagory + " "
                                + cord.get(i).DoughnutType.Style);
                        System.out.print(" " + (cord.get(i).quantity * cord.get(i).DoughnutType.Cost) + "\n");
                    }

                    System.out.println("Please enter which option you'd like to remove: ");
                    index = Integer.parseInt(sc.nextLine());

                    if (index > cord.size() || index >= 0) {
                        cord.remove(index);
                    } else {
                        System.out.println("Error item does not exist");
                    }

                    break;

                // Creates new order and exits order menu.
                /**
                 * @note: If this was a real payment system for an actual doughnut factory this
                 *        is where the customer would pay
                 *        but because this isn't a real system. It is assumed the order will be
                 *        properly paid due to limitations.
                 */
                case 'e':
                case 'E':
                    // Sets a to z to exit out of order
                    a = 'z';
                    for(int i = 0; i < cord.size(); i++){
                        ord.inv.InvRequest(cord.get(i).DoughnutType.catagory, cord.get(i).DoughnutType.Style, cord.get(i).quantity, M);
                    }
                    neword = new Order(ord.getsize(), cord);
                    System.out.println("Thank you for shopping with us!");
                    System.out.println("Your order will be completed shortly. Order number: " + neword.number);
                    ord.CreateOrder(neword);
                    break;

                // Exits order menu.
                case 'z':
                case 'Z':
                    a = 'z';
                    break;

                default:
                    System.out.println("Error | Unknown input!");
            }
        }

    }
}
