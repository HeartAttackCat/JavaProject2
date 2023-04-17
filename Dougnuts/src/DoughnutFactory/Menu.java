/**
 * @author simplex
 * @file Menu.java
 * @assignment Project 2
 * @brief Used for navigating and keeping track of what items are currently
 * on the menu
 * 
 * @Note: when writting save all the admin makes immediately after the change
 * is made.
 */
package DoughnutFactory;
import java.util.ArrayList;

public class Menu {
    ArrayList<Doughnut> MenuItems;

    /**
     * @brief super function for menu class. Imports Menu.csv to load values for each item
     * in the array list.
     */
    Menu(){
        int x = 1; // this code is useless.
    }

    /**
     * @brief Prints out the entire menu.
     */
    void ViewMenu(){

    }

    /**
     * @brief Adds a new item to the menu
     * @note ADMIN ONLY FUNCTION
     * @return if successful return 0
     */
    int AddItem(){

        return 0;
    }

    /**
     * @brief Deletes a new item to the menu
     * @note ADMIN ONLY FUNCTION
     * @return if successful return 0
     */
    int DeleteItem(){
        return 0;
    }
    
    /**
     * @brief edits an existing item on the menu
     * @note ADMIN ONLY FUNCTION
     * @return if successful return 0
     */
    int EditItem(){

        return 0;
    }
}
