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
    public ArrayList<DoughnutStack> ginv = new ArrayList<DoughnutStack>();
    public ArrayList<DoughnutStack> binv = new ArrayList<DoughnutStack>();

    /**
     * @brief constructor class
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
            fp = new Scanner(new File("./Dougnuts/res/inv.csv"));
            fp.nextLine();
            while (fp.hasNextLine()) {
                //Catagory,style,quantity,date,price
                str = fp.nextLine();
                catagory = str.split(",", 5)[0];
                type = str.split(",", 5)[1];
                date = str.split(",", 5)[3];
                quant = Integer.parseInt(str.split(",", 5)[2]);
                price = Float.parseFloat(str.split(",", 5)[4]);

                year = Integer.parseInt(date.split("-", 3)[0]);
                month = Integer.parseInt(date.split("-", 3)[1]);
                day = Integer.parseInt(date.split("-", 3)[2]);

                temp = new Doughnut(catagory, type, price);
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
            tmp = new Doughnut(cat, sty, price);
            ginv.add(new DoughnutStack(tmp, 20));
            System.out.println("Item has been added to inventory.");
        } else {
            return -1;
        }
        return 0;
    }

    public int InvRequest(String cat, String sty, int cont, Menu M) {
        int index;
        while (cont >= 1) {
            index = searchginv(cat, sty);
            if (index <= -1) {
                // Assumed employee will validate to add more.
                if (newstack(cat, sty, M) == -1){
                    return -1;
                }
            } else if (cont > ginv.get(index).quantity) {
                cont -= ginv.get(index).quantity;
                ginv.get(index).quantity = 0;
            } else {
                ginv.get(index).quantity -= cont;
                cont = 0;
            }

        }
        return 0;
    }

    /**
     * @brief searches inventory for a specified item that currently has doughnuts
     *        in it
     * @param cat
     * @param style
     * @return
     */
    public int searchginv(String cat, String style) {
        for (int i = 0; i < ginv.size(); i++) {
            if (ginv.get(i).DoughnutType.catagory.compareToIgnoreCase(cat) == 0) {
                if (ginv.get(i).DoughnutType.Style.compareToIgnoreCase(style) == 0) {
                    if (ginv.get(i).quantity > 0) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * @brief Saves our current inventory into inv.csv
     */
    public void SaveInv() {
        String zadj = "0";
        String Winfo = "Catagory,style,quantity,date,price\n";
        try {
            RandomAccessFile raf = new RandomAccessFile("./Dougnuts/res/inv.csv", "rws");
            try {
                raf.seek(0);
                raf.writeBytes(Winfo);
                // Writes in the expired inventory
                for (int i = 0; i < binv.size(); i++) {
                    DoughnutStack temp = binv.get(i);
                    Winfo = String.format("%s,%s,%s,%s,%s\n", temp.DoughnutType.catagory, temp.DoughnutType.Style, String.valueOf(temp.quantity), temp.expire.DateToString(), String.valueOf(temp.DoughnutType.Cost));
                    raf.writeBytes(Winfo);
                }
                // Writes the good inventory
                for (int i = 0; i < ginv.size(); i++) {
                    DoughnutStack temp = ginv.get(i);
                    Winfo = String.format("%s,%s,%s,%s,%s", temp.DoughnutType.catagory, temp.DoughnutType.Style, String.valueOf(temp.quantity), temp.expire.DateToString(), String.valueOf(temp.DoughnutType.Cost));
                    raf.writeBytes(Winfo);
                }
                raf.close();
            } catch (IOException e) {

            }
        } catch (FileNotFoundException e) {

        }
    }
}
