/**
 * @author simplex
 * @file App.java
 * @assignment Project 2
 * @brief Main class.
 */

package DoughnutFactory;

import DFUsers.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(java.time.LocalDate.now());
        User per = new User();
        int perm = per.UInterface(null);

        switch(perm){
            case 0:
                per = new Customer();
                break;

            case 1:
                per = new Employee();
                break;

            case 2:
                per = new  Administrator();
                break;
        }
        
    }
}
