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
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<Doughnut> MenuItems = new ArrayList<>();

    /**
     * @brief super function for menu class. Imports Menu.csv to load values for
     *        each item
     *        in the array list.
     */
    public Menu() {
        String str;
        String catagory;
        String type;
        String price;
        ArrayList<String> data = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            data.add("NULL");
        }
        Scanner fp;

        // Loads the file
        try {
            fp = new Scanner(new File("./Dougnuts/res/menu.csv"));
            while (fp.hasNextLine()) {
                str = fp.nextLine();
                catagory = str.split(",", 3)[0];
                type = str.split(",", 3)[1];
                price = str.split(",", 3)[2];
                MenuItems.add(new Doughnut(catagory, type, Float.parseFloat(price)));
            }
            fp.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief Prints out the entire menu.
     */
    public void ViewMenu() {
        System.out.println("Type\tItem\tPrice");
        for (int i = 0; i < MenuItems.size(); i++) {
            System.out.print(MenuItems.get(i).catagory + "\t");
            System.out.print(MenuItems.get(i).Style + "\t");
            System.out.println(MenuItems.get(i).Cost);
        }

    }

    /**
     * @brief Adds a new item to the menu
     * @note ADMIN ONLY FUNCTION
     * @param CatName The catagory we are adding to.
     * @param Iname   the item name
     * @param c       the cost of the item
     * @return if successful return 0
     */
    public int AddItem(String CatName, String Iname, float c) {
        MenuItems.add(new Doughnut(CatName, Iname, c));
        SaveChanges();
        return 0;
    }

    /**
     * @brief Deletes a new item to the menu
     * @note ADMIN ONLY FUNCTION
     * @param CatName the catagory of the doughnut.
     * @param Iname   the items name.
     * @return if successful return 0; upon failure return 1 (Item not found)
     */
    public int DeleteItem(String CatName, String Iname) {

        for (int i = 0; i < MenuItems.size(); i++) {
            if (CatName.compareTo(MenuItems.get(i).catagory) == 0 && Iname.compareTo(MenuItems.get(i).Style) == 0) {
                MenuItems.remove(i);
                SaveChanges();
                return 0;
            }
        }
        SaveChanges();
        return 1;
    }

    /**
     * @brief edits an existing item on the menu
     * @note ADMIN ONLY FUNCTION
     * @return if successful return 0 ; upon failure return 1 (Item note found)
     */
    public int EditItem(String CatName, String Iname) {
        for (int i = 0; i < MenuItems.size(); i++) {
            if (CatName.compareTo(MenuItems.get(i).catagory) == 0 && Iname.compareTo(MenuItems.get(i).Style) == 0) {
                UpdateItem(i);
                SaveChanges();
                return 0;
            }
        }
        SaveChanges();
        return 1;
    }

    /**
     * @brief focuses on updating a single item where the index was provided
     * @NOTE: This is a very ugly implementation will fix if we have time after the
     *        project
     *        works.
     * @param index The index we are editing
     */
    public void UpdateItem(int index) {
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
        s.close();
        SaveChanges();
    }

    /**
     * @brief saves any changes to menu.csv.
     */
    public void SaveChanges() {
        try {
            // Clears file or creates a new if it doesn't exist
            clearmenu();
            String str = "";
            FileWriter fp = new FileWriter("./Dougnuts/res/menu.csv", false);
            fp.write("catagory,style,price,quantity");

            // Begins writing
            for (int i = 0; i < MenuItems.size(); i++) {
                str = "";
                str = MenuItems.get(i).catagory + MenuItems.get(i).Style;
                str = str + String.valueOf(MenuItems.get(i).Cost);
            }
            fp.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * @brief clears the menu.csv in case
     * @return If it created a new file 1 if created. 0 if file already exists.
     */
    public int clearmenu() {
        try {
            File myObj = new File("./Dougnuts/res/menu.csv");
            if (myObj.createNewFile()) {
                return 1;
            }
            FileWriter fw = new FileWriter("./Dougnuts/res/menu.csv", false);
            PrintWriter pw = new PrintWriter(fw, false);
            pw.flush();
            pw.close();
            fw.close();

        } catch (Exception exception) {

        }
        return 0;
    }

    /**
     * @brief Determines if an item is in the list
     * @Note if time permits overhaul other functions to use this one.
     * @param cat  Catagory of Doughnut
     * @param type Type of doughnut
     * @return index if found | -1 if catagory doesn't exist | -2 if catagory
     *         is real but type is not
     */
    public int IsItem(String cat, String type) {
        for (int i = 0; i < MenuItems.size(); i++) {
            if (MenuItems.get(i).catagory.compareToIgnoreCase(cat) == 0) {
                if (MenuItems.get(i).Style.compareToIgnoreCase(type) == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * @brief gets an item's price when index is unknown
     * @param cat  Item's catagory
     * @param type Items type
     * @return Is real? Return price | Not real? return 0
     */
    public float GetPrice(String cat, String type) {
        int z = IsItem(cat, type);
        if (z >= 0) {
            return MenuItems.get(z).Cost;
        }
        return 0;
    }

    /**
     * @brief gets an item's price when index is known.
     * @param cat  Item's catagory
     * @param type Items type
     * @return Is real? Return price | Not real? return 0
     */
    public float GetPrice(int index) {
        return MenuItems.get(index).Cost;
    }
}