/**
 * @author simplex
 * @file Inventory.java
 * @assignment Project 2
 * @brief Manages all inventory information with the doughnuts.
 */

package DoughnutFactory;

import java.util.ArrayList;

public class Inventory {
    ArrayList<DoughnutStack> inv = new ArrayList<DoughnutStack>();

    /** 
     * @brief constructor class
     * TODO:
     * Read from inventory file and initalize
     * check if expired | Yes? skip this line | No? add into arraylist
     */
    public Inventory(){
    }

    public int newitem(){
        return 0;
    }

}
