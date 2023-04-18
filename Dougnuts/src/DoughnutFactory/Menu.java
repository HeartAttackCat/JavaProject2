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
        String cont;
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
                cont = str.split(",", 4)[4];
				MenuItems.add(new Doughnut(catagory, type, Float.valueOf(price), Integer.valueOf(cont)));
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
        System.out.println("Type\tItem\tPrice\tQuantity");
        for(int i = 0; i>MenuItems.size();i++){
            System.out.print(MenuItems.get(i).catagory + "\t");
            System.out.print(MenuItems.get(i).Style + "\t");
            System.out.println(MenuItems.get(i).Cost + "\t" + MenuItems.get(i).count);
        }

    }

    /**
     * @brief Adds a new item to the menu
     * @note ADMIN ONLY FUNCTION
     * @param CatName The catagory we are adding to.
     * @param Iname the item name
     * @param c the cost of the item
     * @return if successful return 0
     */
    int AddItem(String CatName, String Iname, float c){
        MenuItems.add(new Doughnut(CatName, Iname, c, 0));
        return 0;
    }

    /**
     * @brief Deletes a new item to the menu
     * @note ADMIN ONLY FUNCTION
     * @param CatName the catagory of the doughnut.
     * @param Iname the items name.
     * @return if successful return 0; upon failure return 1;
     */
    int DeleteItem(String CatName, String Iname){
    
        for(int i = 0; i < MenuItems.size(); i++){
            if(CatName.compareTo(MenuItems.get(i).catagory) == 0 && Iname.compareTo(MenuItems.get(i).Style) == 0){
                MenuItems.remove(i);
                return 0;
            }
        }
        return 1;
    }
    
    /**
     * @brief edits an existing item on the menu
     * @note ADMIN ONLY FUNCTION
     * @return if successful return 0
     */
    int EditItem(String CatName, String Iname){
        for(int i = 0; i < MenuItems.size(); i++){
            if(CatName.compareTo(MenuItems.get(i).catagory) == 0 && Iname.compareTo(MenuItems.get(i).Style) == 0){
                UpdateItem(i);
                return 0;
            }
        }
        return 1;
    }

    /**
     * @brief focuses on updating a single item where the index was provided
     * @NOTE: This is a very ugly implementation will fix if we have time after the project
     * works.
     * @param index The index we are editing
     */
    void UpdateItem(int index){
        String str; 
        Scanner s = new Scanner(System.in);

        // Updates catagory
        System.out.print("What is the new item catagory: ");
        str = s.nextLine();
        MenuItems.get(index).catagory = str;

        // Updates name
        System.out.print("What is the new item name: ");
        str = s.nextLine();
        MenuItems.get(index).Style = str;

        // Updates cost
        System.out.print("What is the new item cost: ");
        str = s.nextLine();
        MenuItems.get(index).Cost = Float.parseFloat(str);

        // Resets quantity
        MenuItems.get(index).count = 0;
    }

    /**
     * @brief saves any changes to menu.csv
     */
    void SaveChanges(){

    }
}
