/**
 * @author simplex
 * @file User.java
 * @assignment Project 2
 * @brief User class that determines what other user class will
 * inherit it.
 */
package DFUsers;

import DoughnutFactory.*;
import java.util.Scanner;

public class User {
    String name;
    String Id;
    String AdminPass = "Admin101";
    String Employeepass = "Employee101";

    /**
     * @brief class builder
     */
    public User() {

    }

    /**
     * @brief user interface for the current class for inputting password. This
     *        iteration is for when the user first enters the system.
     * @note: All classes will need their own override.
     * @return exit status
     */
    public int UInterface(Menu M, OrderHandler ords) {
        String str = "";
        char a = 'a';
        System.out.println("Welcome User!");
        Scanner s = new Scanner(System.in);
        while (a != 'z') {
            System.out.println("Choose one of the following options");
            System.out.println("a. countinue as customer.");
            System.out.println("b. Log in as staff.");
            System.out.println("z. exit");
            System.out.print("Enter an input: ");

            str = s.nextLine();
            a = str.charAt(0);

            switch (a) {
                case 'a':
                case 'A':
                    return 0;

                case 'b':
                case 'B':
                    System.out.print("Enter password: ");
                    str = s.nextLine();
                    return LogIn(str);

                case 'z':
                case 'Z':
                    s.close();
                    return -1;

                default:
                    System.out.println("Error | Unknown input!");
            }
        }

        return 0;
    }

    /**
     * @brief used to determine what to evolve this class into. If it is a
     *        recongized Admin
     *        or Employee password return 1 or 2. If unrecongized return 0.
     * @return Access level
     */
    int LogIn(String pass) {
        if (pass.compareTo(AdminPass) == 0) {
            return 1;
        } else if (pass.compareTo(Employeepass) == 0) {
            return 2;
        }
        return 0;
    }
}
