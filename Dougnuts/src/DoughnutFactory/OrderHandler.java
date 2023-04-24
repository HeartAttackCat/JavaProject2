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

public class OrderHandler {
    public Inventory inv;
    public ArrayList<Order> Orders = new ArrayList<Order>();

    /**
     * @brief constructor
     */
    public OrderHandler() {
        // Load from Orders.csv
    }

    /**
     * @brief creates a new order.
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
            FileWriter fp = new FileWriter("../../res/menu.csv", false);
            fp.write("catagory,style,price,quantity");

            // Begins writing
            for (int i = 0; i < Orders.size(); i++) {
                str = Orders.get(i).number + String.valueOf(Orders.get(i).TotalPrice);
                str = str + String.valueOf(Orders.get(i).TotalQuantity) + Orders.get(i).status;
                str = str + Orders.get(i).date.DateToString() + '\n';
                fp.write(str);
            }
            fp.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    public int getReportData() {
        return 0;
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
