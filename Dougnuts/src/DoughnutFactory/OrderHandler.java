/**
 * @author simplex
 * @file OrderHandler.java
 * @assignment Project 2
 * @brief Manager class for orders and the inventory because since all ordering
 * is done through this class it's best to pair the inventory stats and order stats.
 */
package DoughnutFactory;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class OrderHandler {
    public Inventory inv;
    public ArrayList<Order> Orders = new ArrayList<Order>();

    /**
     * @brief constructor
     */
    public OrderHandler(Menu M) {
        inv = new Inventory(M);
        ArrayList<DoughnutStack> temp;
        // orderID,price,quantity,status,date,items
        // items: Catagory-Style-Quantity=...=DNR
        String str;
        String ID;
        String date;
        String items;
        float price;
        int quantity;
        int status;

        int year;
        int month;
        int day;

        Date tmp;
        Scanner fp;

        // Loads the file
        try {
            fp = new Scanner(new File("./Dougnuts/res/Orders.csv"));
            while (fp.hasNextLine()) {
                str = fp.nextLine();
                ID = str.split(",", 5)[0];
                try {
                    price = Float.parseFloat(str.split(",", 5)[1]);
                    quantity = Integer.parseInt(str.split(",", 5)[2]);
                    status = Integer.parseInt(str.split(",", 5)[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Ignoring...");
                }
                
                date = str.split(",", 5)[4];
                items = str.split(",", 5)[5];

                // Builds date;
                year = Integer.parseInt(date.split("-", 2)[0]);
                month = Integer.parseInt(date.split("-", 2)[1]);
                day = Integer.parseInt(date.split("-", 2)[2]);
                tmp = new Date(year, month, day);

                // Builds the person's order items
                temp = StackBuild(items, tmp, M);

                Orders.add(new Order(Orders.size(), temp));

            }
            fp.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief builds the donought stacks for each order.
     * @param items The items we are adding onto the stack.
     * @param d     The date it was ordered.
     */
    public ArrayList<DoughnutStack> StackBuild(String items, Date d, Menu M) {
        int cont = CountItems(items);
        ArrayList<DoughnutStack> temp = new ArrayList<DoughnutStack>();
        Doughnut t;
        String str;

        String cat;
        String sty;
        int quant;
        float price;

        for (int i = 0; i < cont - 1; i++) {
            str = items.split("=", cont)[i];

            sty = str.split("-", 2)[1];
            cat = str.split("-", 2)[0];
            quant = Integer.parseInt(str.split("-", 2)[2]);
            price = M.GetPrice(cat, sty);

            t = new Doughnut(sty, cat, price);
            temp.add(new DoughnutStack(t, quant));
        }
        return temp;
    }

    public int CountItems(String items) {
        int cont = 0;
        for (int i = 0; i < items.length(); i++) {
            if (items.charAt(i) == '=') {
                cont++;
            }
        }
        return cont;
    }

    /**
     * @brief creates a new order.
     * @param cord the order we are adding onto the list.
     */
    public void CreateOrder(Order cord) {
        ArrayList<DoughnutStack> ord = new ArrayList<DoughnutStack>();
        // Adds a new order to the list passes the current size for the ID.
        Orders.add(new Order(Orders.size(), ord));
    }

    public int saveOrders() {
        try {
            // Clears file or creates a new if it doesn't exist
            String str = "";
            FileWriter fp = new FileWriter("./Dougnuts/res/Orders.csv", false);
            fp.write("catagory,style,price,quantity");

            // Begins writing
            for (int i = 0; i < Orders.size(); i++) {
                str = Orders.get(i).number + String.valueOf(Orders.get(i).TotalPrice);
                str = str + String.valueOf(Orders.get(i).TotalQuantity) + Orders.get(i).status;
                str = str + Orders.get(i).date.DateToString();
                str = str + Builditems(i);
                str = str + '\n';
                fp.write(str);
            }
            fp.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    /**
     * @brief builds a string of the an index's orders.
     * @param index the index we are building a string of
     * @return A string containing all items.
     */
    public String Builditems(int index) {
        String str = "";
        for (int i = 0; i < Orders.get(index).items.size(); i++) {
            str = str + Orders.get(index).items.get(i).DoughnutType.catagory;
            str = str + "-";
            str = str + Orders.get(index).items.get(i).DoughnutType.Style;
            str = str + "-";
            str = str + Orders.get(index).items.get(i).quantity;
            // Seperates each seperate item group.
            str = str + "=";
        }
        // Do Not Read
        str = str + "DNR";

        return str;
    }

    /**
     * @brief displays all recorded orders
     * @return 0
     */
    public int displayOrders() {
        for (int i = 0; i < Orders.size(); i++) {
            Orders.get(i).displayOrder();
        }
        return 0;
    }

    /**
     * @brief displays only the pending orders.
     * @return
     */
    public int DisplayPendingCondense() {
        System.out.println("Pending orders:");
        System.out.println("-----");
        for (int i = 0; i < Orders.size(); i++) {
            if (Orders.get(i).status == 0) {
                System.out.print(i + " ");
                Orders.get(i).ONumberDisplay();
            }
        }
        System.out.println("-----");
        return 0;
    }

    /**
     * @brief gets the size of an order for generating the order number
     * @return The size of the list
     */
    public int getsize() {
        return Orders.size();
    }

    /**
     * @brief Marks the specified order as complete
     * @param index The index we are updating.
     */
    public void CompleteOrder(int index) {
        Orders.get(index).MarkComplete();
    }
}
