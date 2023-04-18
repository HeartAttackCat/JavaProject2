/**
 * @author simplex
 * @file App.java
 * @assignment Project 2
 * @brief Class for admin level interactions.
 */
package DFUsers;

public class Administrator extends User{
    /**
     * @brief constructor class for the user
     */
    Administrator(){
        super();
    }

    /**
     * @brief generates sales data reports.
     */
    void GenerateReports(){

    }

    /**
     * @brief Adds an item to the menu class. This is the
     * interface for adding the item.
     * @return Exit status
     */
    int AddItem(){
        return 0;
    }

    /**
     * @brief deletes an exiting item from the menu.
     * @return Exit status
     */
    int DeleteItem(){

        return 0;
    }

    /**
     * @brief edits an existing item from the menu
     * @return exit status
     */
    int EditItem(){
        return 0;
    }

    /**
     * @brief Prints out menu to allow admin to view.
     */
    void ViewMenu(){

    }
}
