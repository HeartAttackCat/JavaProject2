/**
 * @author simplex
 * @file User.java
 * @assignment Project 2
 * @brief User class that determines what other user class will
 * inherit it.
 */
package DFUsers;

public class User {
    String name;
    String Id;
    String AdminPass = "Admin101";
    String Employeepass = "Employee101";

    /**
     * @brief class builder
     */
    User(){
        
    }

    /**
     * @brief user interface for the current class for inputting password. This
     * iteration is for when the user first enters the system.
     * @note: All classes will need their own override.
     * @return exit status
     */
    int UInterface(){
        return 0;
    }

    /**
     * @brief used to determine what to evolve this class into. If it is a recongized Admin
     * or Employee password return 1 or 2. If unrecongized return 0.
     * @return Access level
     */
    int LogIn(String pass){
        if (pass.compareTo(AdminPass) == 0){
            return 1;
        } else if (pass.compareTo(Employeepass) == 0){
            return 2;
        }
        return 0;
    }
}
