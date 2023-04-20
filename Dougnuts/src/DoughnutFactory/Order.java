/**
 * @author simplex
 * @file Order.java
 * @assignment Project 2
 * @brief Class that handles information for a single order
 */
package DoughnutFactory;
import java.util.ArrayList;

public class Order {
    int number;
    ArrayList<DoughnutStack> items;
    Date date;
    String name;
    int TotalPrice;
    int TotalQuantity;

    /**
     * @brief constructor
     */
    Order(){

    }

    /**
     * @brief displays an order
     */
    public void displayOrder(){
        System.out.println("-----");
        System.out.println(name +"'s order");
        System.out.println("Order number: " + number);
        System.out.println(date.DateToString());
        System.out.println("Price: " + TotalPrice);
        System.out.println(TotalQuantity + "Item(s) ordered");
        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).DoughnutType + ": " + items.get(i).getQuantity());
        }
        System.out.println("-----");
    }

}
