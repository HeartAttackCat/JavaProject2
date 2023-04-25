/**
 * @author simplex
 * @file Order.java
 * @assignment Project 2
 * @brief Class that handles information for a single order
 */
package DoughnutFactory;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;

public class Order {
    public String number;
    public ArrayList<DoughnutStack> items;
    public Date date;
    public int status;
    public float TotalPrice;
    public int TotalQuantity;

    /**
     * @brief constructor Without number already created
     */
    public Order(int Onum, ArrayList<DoughnutStack> ord) {
        date = new Date();
        number = date.DateToString();
        number = number + String.valueOf(Onum);
        // Zero == Processing | One == Processed
        items = ord;
        status = 0;
        TotalPrice = 0;
        TotalQuantity = 0;

        for (int i = 0; i < ord.size(); i++) {
            TotalPrice = TotalPrice + (ord.get(i).DoughnutType.Cost * ord.get(i).quantity);
            TotalQuantity += ord.get(i).quantity;
        }

    }

    /**
     * @brief constructor Order number already created
     */
    public Order(String Onum, ArrayList<DoughnutStack> ord, Date d, int status, float price) {
        date = d;
        number = Onum;
        items = ord;
        this.status = status;
        TotalPrice = price;
        TotalQuantity = 0;

        for (int i = 0; i < ord.size(); i++) {
            TotalQuantity += ord.get(i).quantity;
        }

    }

    /**
     * @brief displays an order
     */
    public void displayOrder() {
        System.out.println("-----");
        System.out.println("Order number: " + number);
        System.out.println(date.DateToString());
        System.out.println("Price: " + TotalPrice);
        System.out.println(TotalQuantity + " Item(s) ordered");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).DoughnutType.catagory + " " + items.get(i).DoughnutType.Style+ ": " + items.get(i).getQuantity());
        }
        if (status == 0) {
            System.out.println("Order being processed.");
        } else {
            System.out.println("Order has been finished.");
        }
        System.out.println("-----");
    }

    public void ONumberDisplay() {
        System.out.println(number);
    }

    /**
     * @brief updates the order to complete
     */
    void MarkComplete() {
        status = 1;
    }

}
