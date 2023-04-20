/**
 * @author simplex
 * @file App.java
 * @assignment Project 2
 * @brief Class for user interactions by a customer.
 */
package DFUsers;
import java.util.Scanner;
import DoughnutFactory.*;


public class Customer extends User{

    /**
     * @brief constructor class for customer.
     */
    Customer(){
        super();
    }

    /**
     * @brief user interface for the current class for inputting password. This
     * iteration is for when the user first enters the system.
     * @note: All classes will need their own override.
     * @return exit status
     */
    @Override
    int UInterface(Menu M){
        String str = "";
        char a = 'a';
        System.out.println("Welcome valued customer!");
        Scanner s = new Scanner(System.in);
        while (a != 'z'){
            System.out.println("----");
            System.out.println("Choose one of the following options");
            System.out.println("-----");
            System.out.println("a. ");
            System.out.println("z. exit");
            System.out.print("Enter an input: ");

            str = s.nextLine(); 
            a = str.charAt(0);
            
            switch(a){
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
     * @brief prints out the entire menu for the user.
     */
    // void ViewMenu(){

    // }

    /**
     * @brief places an order.
     */
    void PlaceOrder(){

    }
}
