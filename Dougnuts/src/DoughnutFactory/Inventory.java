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
     *        check if expired | Yes? Add to bad | No? Add to good
     */
    public Inventory(Menu M) {
        String str;
        String catagory;
        String type;
        String date;

        int year;
        int month;
        int day;
        int quant;
        float price;
        boolean fresh;

        Date d;
        Doughnut temp;
        Scanner fp;

        // Loads the file
        try {
            fp = new Scanner(new File("./inv.csv"));
            System.out.println(fp.nextLine());
            System.out.println(fp.hasNextLine());
            while (fp.hasNextLine()) {
                str = fp.nextLine();
                catagory = str.split(",", 4)[0];
                type = str.split(",", 4)[1];
                date = str.split(",", 4)[2];
                quant = Integer.parseInt(str.split(",", 4)[3]);
                price = Float.parseFloat(str.split(",", 4)[4]);

                year = Integer.parseInt(date.split("-", 3)[0]);
                month = Integer.parseInt(date.split("-", 3)[1]);
                day = Integer.parseInt(date.split("-", 3)[2]);

                temp = new Doughnut(str, catagory, price);
                d = new Date(year, month, day);
                fresh = d.ExpCheck();

                if (fresh == true) {
                    ginv.add(new DoughnutStack(d, temp, quant, fresh));
                } else {
                    binv.add(new DoughnutStack(d, temp, quant, fresh));
                }
            }
            fp.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief creates a new stack in the stores inventory
     * @param cat Catagory of doughnut
     * @param sty Style of Doughnut
     * @param M   Menu
     * @return 0
     */
    public int newstack(String cat, String sty, Menu M) {
        float price;
        int index;
        Doughnut tmp;

        index = M.IsItem(cat, sty);
        if (index >= 0) {
            price = M.GetPrice(index);
            tmp = new Doughnut(sty, cat, price);
            ginv.add(new DoughnutStack(tmp, 20));
            System.out.println("Item has been added to inventory.");
        } else {
            System.out.println("Error item does not exist");
        }
        return 0;
    }

    public int takeFromStack() {
        return 0;
    }

    public void SaveInv() {
        String Winfo = "Catagory,style,quantity,date,price";
        try {
            RandomAccessFile raf = new RandomAccessFile("./res/inv.csv", "rws");
            try {
                raf.seek(0);
                raf.writeBytes(Winfo);
                // Writes in the expired inventory
                for (int i = 0; i < binv.size(); i++) {
                    Winfo = ("\n");
                    Winfo += binv.get(i).DoughnutType.catagory;
                    Winfo += binv.get(i).DoughnutType.Style;
                    Winfo += String.valueOf(binv.get(i).quantity);
                    Winfo += binv.get(i).expire.DateToString();
                    Winfo += String.valueOf(binv.get(i).DoughnutType.Cost);
                    raf.writeBytes(Winfo);
                }
                // Writes the good inventory
                for (int i = 0; i < binv.size(); i++) {
                    Winfo = ("\n");
                    Winfo += ginv.get(i).DoughnutType.catagory;
                    Winfo += ginv.get(i).DoughnutType.Style;
                    Winfo += String.valueOf(ginv.get(i).quantity);
                    Winfo += ginv.get(i).expire.DateToString();
                    Winfo += String.valueOf(ginv.get(i).DoughnutType.Cost);
                    raf.writeBytes(Winfo);
                }
                raf.close();
            } catch (IOException e) {

            }
        } catch (FileNotFoundException e) {

        }
    }
}
