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
                    GenerateReports(ords, num);
                    break;

                case 'b':
                case 'B':
                    M.AddItem(str1, str2, a);
                    break;

                case 'c':
                case 'C':
                    M.DeleteItem(str1, str2);
                    break;

                case 'd':
                case 'D':
                    M.EditItem(str1, str2);
                    break;

                case 'e':
                case 'E':
                    M.ViewMenu();
                    break;

                case 'z':
                case 'Z':
                    return 0;

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
        Date d = new Date();
        String repname = "salesrep" + String.valueOf(year) + ".txt";
        File fp = new File(repname);
        String Winfo = "";

        int y;
        float TotalY = 0;
        float totalM[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

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
                Winfo = String.valueOf(i);
                Winfo = Winfo + "\t|\t";
                Winfo = Winfo + String.valueOf(totalM[i]);
                Winfo = Winfo + "\n";
                fw.write(Winfo);
            }
            Winfo = String.valueOf(TotalY / 52) + " doughnuts on average were tossed each week.";
            fw.write(Winfo);

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
                Winfo = String.valueOf(i);
                Winfo = Winfo + "\t|\t";
                Winfo = Winfo + String.valueOf(totalM[i]);
                Winfo = Winfo + "\n";
                fw.write(Winfo);
            }
            Winfo = String.valueOf(TotalY / 52) + " doughnuts on average were tossed each week.";
            fw.write(Winfo);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
