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
        Menu Mu = new Menu();
        OrderHandler OH = new OrderHandler();
        User per = new User();
        int perm = per.UInterface(null, null, null);

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

        // User interface
        while(perm != -1){
            perm = per.UInterface(Mu, OH, Mu);
        }
        
    }
}
