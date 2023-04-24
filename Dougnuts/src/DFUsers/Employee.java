/**
 * @author simplex
 * @file Employee.java
 * @assignment Project 2
 * @brief User class for actions the employee can do.
 */
package DFUsers;

import DoughnutFactory.*;
import java.util.Scanner;

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
    public int UInterface(Menu M, OrderHandler ords, Scanner s) {
        String str = "";
        String str2 = "";
        char a = 'a';
        int index = 0;
        System.out.println("Welcome User!");
        while (a != 'z') {
            System.out.println("Choose one of the following options");
            System.out.println("a. Display all orders");
            System.out.println("b. Update an order");
            System.out.println("c. Add new stack to inventory");
            System.out.println("z. exit");
            System.out.print("Enter an input: ");

            str = s.nextLine();
            a = str.charAt(0);

            switch (a) {
                case 'a':
                case 'A':
                    ViewOrders(ords);
                    break;

                case 'b':
                case 'B':
                    UpdateOrder(ords);
                    break;

                case 'c':
                case 'C':
                    System.out.print("Enter the doughnut catagory we are adding: ");
                    str = s.nextLine();
                    System.out.print("Enter the doughnut style we are adding: ");
                    str2 = s.nextLine();

                    index = M.IsItem(str, str2);
                    if (index >= 0){
                        ords.inv.newstack(str, str2, M);
                    } else {
                        System.out.println("Error | Doughnut does not exist on menu.");
                    }
                    break;

                case 'z':
                case 'Z':
                    return 0;

                default:
                    System.out.println("Error | Unknown input!");
            }
        }

        return 0;
    }

    /**
     * @brief shows the employee all pending orders.
     */
    public void ViewOrders(OrderHandler ords) {
        ords.displayOrders();
    }

    /**
     * @brief Updates an existing pending orders process to finished.
     * @return 0 if successful and -1 upon failure.
     */
    public int UpdateOrder(OrderHandler ords) {
        ords.DisplayPendingCondense();

        int x = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the first digit of an order: ");

        x = sc.nextInt();
        if (x < 0 || x > ords.Orders.size()) {
            System.out.println("Error Order does not exist");
            sc.close();
            return -1;
        }

        ords.CompleteOrder(x);
        System.out.println("Order has been marked as completed.");
        sc.close();
        return 0;
    }
}
