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

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<Doughnut> MenuItems;

    /**
     * @brief super function for menu class. Imports Menu.csv to load values for each item
     * in the array list.
     */
    Menu(){
        String str;
		String catagory;
		String type;
		String price;
		ArrayList<String> data = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			data.add("NULL");
		}
		Scanner fp;
		try {
			fp = new Scanner(new File("./menu.csv"));
            fp.nextLine();
			while(fp.hasNextLine()) {
				str = fp.nextLine();
				catagory = str.split(",", 4)[0];
				type = str.split(",", 4)[1];
				price = str.split(",", 4)[3];
				MenuItems.add(new Doughnut(catagory, type, Float.valueOf(price)));
			}
			fp.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
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
