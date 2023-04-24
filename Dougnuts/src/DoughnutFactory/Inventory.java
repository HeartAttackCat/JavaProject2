/**
 * @author simplex
 * @file Inventory.java
 * @assignment Project 2
 * @brief Manages all inventory information with the doughnuts.
 */

package DoughnutFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    ArrayList<DoughnutStack> ginv = new ArrayList<DoughnutStack>();
    ArrayList<DoughnutStack> binv = new ArrayList<DoughnutStack>();

    /**
     * @brief constructor class
     *        TODO:
     *        Read from inventory file and initalize
     *        check if expired  | Yes? Add to bad; date = 0-0-0  only used for generating the 
     *                                 expired report.
     *                          | No? add to good; 
     */
    public Inventory() {
        String str;
        String catagory;
        String type;
        String date;
        int quant;
        Doughnut temp; 
        Scanner fp;

        // Loads the file
        try {
            fp = new Scanner(new File("./menu.csv"));
            System.out.println(fp.nextLine());
            System.out.println(fp.hasNextLine());
            while (fp.hasNextLine()) {
                str = fp.nextLine();
                System.out.print(str);
                catagory = str.split(",", 4)[0];
                type = str.split(",", 4)[1];
                date = str.split(",", 4)[2];
                quant = Integer.parseInt(str.split(",", 4)[3]);
                
                
            }
            fp.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
    }

    public int newitem() {
        return 0;
    }

}
