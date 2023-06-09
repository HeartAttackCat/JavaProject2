/**
 * @author simplex
 * @file App.java
 * @assignment Project 2
 * @brief Class for admin level interactions.
 */
package DFUsers;

import java.io.*;
import java.util.Scanner;
import DoughnutFactory.*;

public class Administrator extends User {
    /**
     * @brief constructor class for the user
     */
    public Administrator() {
        super();
    }

    /**
     * @brief user interface exclusive to admin class
     * @return exit case
     */
    @Override
    public int UInterface(Menu M, OrderHandler ords, Scanner s) {
        String str1 = "";
        String str2 = "";
        char a = 'a';
        int num = 2023;
        float pc;
        System.out.println("Welcome User!");
        while (a != 'z') {
            System.out.println("Choose one of the following options");
            System.out.println("a. Generate reports");
            System.out.println("b. Add new a menu item");
            System.out.println("c. Delete a menu item");
            System.out.println("d. Edit a menu item.");
            System.out.println("e. view menu");
            System.out.println("z. exit");
            System.out.print("Enter an input: ");

            str1 = s.nextLine();
            a = str1.charAt(0);

            switch (a) {
                // Call functions from the menu class to represent adding, deleting, etc.
                case 'a':
                case 'A':
                    System.out.print("What year are we interested in: ");
                    str1 = s.nextLine();
                    num = Integer.parseInt(str1);
                    GenerateReports(ords, num);
                    break;

                case 'b':
                case 'B':
                    System.out.print("What catagory are we adding: ");
                    str1 = s.nextLine();
                    System.out.print("What style is the item: ");
                    str2 = s.nextLine();
                    System.out.print("what is the item's cost: ");
                    pc = Float.parseFloat(s.nextLine());
                    M.AddItem(str1, str2, pc);
                    break;

                case 'c':
                case 'C':
                    System.out.print("What catagory are we Deleting: ");
                    str1 = s.nextLine();
                    System.out.print("What style is the item: ");
                    str2 = s.nextLine();    
                    M.DeleteItem(str1, str2);
                    break;

                case 'd':
                case 'D':
                    System.out.print("What catagory are we Editing: ");
                    str1 = s.nextLine();
                    System.out.print("What style is the item: ");
                    str2 = s.nextLine();
                    M.EditItem(str1, str2);
                    break;

                case 'e':
                case 'E':
                    M.ViewMenu();
                    break;

                case 'z':
                case 'Z':
                    return -1;

                default:
                    System.out.println("Error | Unknown input!");
            }
        }

        return 0;
    }

    /**
     * @brief generates sales data reports.
     *        Todo: Last part of user functionally that needs to be added.
     */
    void GenerateReports(OrderHandler ords, int year) {
        Salesrep(ords, year);
        ExpRep(ords, year);
    }

    /**
     * @brief generates the sales reports.
     */
    void Salesrep(OrderHandler ords, int year) {
        String repname = "salesrep" + String.valueOf(year) + ".txt";
        File fp = new File(repname);
        String Winfo = "";
        Order z;
        
        int y;
        float TotalY = 0;
        float totalM[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        // Creates file
        try {
            fp.createNewFile();
        } catch (IOException e) {
        }

        for (int i = 0; i < ords.Orders.size(); i++) {
            z = ords.Orders.get(i);
            y = z.date.year;
            if (y == year) {
                totalM[z.date.month - 1] += z.TotalPrice;
                TotalY += z.TotalPrice;
            }
        }

        // Generates file
        try {
            FileWriter fw = new FileWriter(fp, false);
            Winfo = String.valueOf(TotalY);
            Winfo = "$" + Winfo + " was earned in the year " + String.valueOf(year);
            fw.write(Winfo);
            fw.write("\nMonth\t|\tTotal earnings\n");
            for (int i = 0; i < 12; i++) {
                Winfo = String.valueOf(i + 1);
                Winfo = Winfo + "\t|\t";
                Winfo = Winfo + "$" + String.valueOf(totalM[i]);
                Winfo = Winfo + "\n";
                fw.write(Winfo);
            }
            Winfo = "$" + String.valueOf(TotalY / 52) + " Was earned each week.";
            fw.write(Winfo);
            fw.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @brief generates the expired reports.
     */
    void ExpRep(OrderHandler ords, int year) {
        Date d = new Date();
        String repname = "Expiredrep" + String.valueOf(year) + ".txt";
        File fp = new File(repname);
        String Winfo = "";

        int y;
        int TotalY = 0;
        int totalM[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        // Creates file
        try {
            fp.createNewFile();
        } catch (IOException e) {
        }

        for (int i = 0; i < ords.inv.binv.size(); i++) {
            y = ords.inv.binv.get(i).expire.year;
            if (y == year) {
                totalM[ords.inv.binv.get(i).expire.month] += ords.inv.binv.get(i).quantity;
                TotalY += ords.inv.binv.get(i).quantity;
            }
        }

        // Generates file
        try {
            FileWriter fw = new FileWriter(fp, false);
            Winfo = String.valueOf(TotalY);
            Winfo = Winfo + " total doughnuts were tossed in the year " + String.valueOf(year);
            fw.write(Winfo);
            fw.write("\nMonth\t|\tTotal tossed\n");
            for (int i = 0; i < 12; i++) {
                Winfo = String.valueOf(i + 1);
                Winfo = Winfo + "\t|\t";
                Winfo = Winfo + String.valueOf(totalM[i]);
                Winfo = Winfo + "\n";
                fw.write(Winfo);
            }
            Winfo = String.valueOf(TotalY / 52.0) + " were tossed per week.";
            fw.write(Winfo);
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
