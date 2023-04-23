/**
 * @author simplex
 * @file Order.java
 * @assignment Project 2
 * @brief Class that handles information for a single order
 */
package DoughnutFactory;
import java.util.ArrayList;

public class Order {
    String number;
    ArrayList<DoughnutStack> items;
    Date date;
    int status;
    float TotalPrice;
    int TotalQuantity;

    /**
     * @brief constructor
     */
    public Order(int Onum, ArrayList<DoughnutStack> ord){
        date = new Date();
        number = date.DateToString();
        number = number + Integer.parseInt(number);
        // Zero == Processing | One == Processed
        items = ord;
        status = 0;
        TotalPrice = 0;
        TotalQuantity = 0;

        for(int i = 0; i < ord.size(); i++){
            TotalPrice = TotalPrice + (ord.get(i).DoughnutType.Cost * ord.get(i).quantity);
            TotalQuantity += ord.get(i).quantity;
        }
        
    }

    /**
     * @brief displays an order
     */
    public void displayOrder(){
        System.out.println("-----");
        System.out.println("Order number: " + number);
        System.out.println(date.DateToString());
        System.out.println("Price: " + TotalPrice);
        System.out.println(TotalQuantity + "Item(s) ordered");
        for(int i = 0; i < items.size(); i++){
            System.out.println(items.get(i).DoughnutType + ": " + items.get(i).getQuantity());
        }
        if (status == 0){
            System.out.println("Order being processed.");
        } else {
            System.out.println("Order has been finished.");
        }
        System.out.println("-----");
    }

}
