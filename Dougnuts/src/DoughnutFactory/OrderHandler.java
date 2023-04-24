/**
 * @author simplex
 * @file OrderHandler.java
 * @assignment Project 2
 * @brief Manager class for orders
 */
package DoughnutFactory;
import java.util.ArrayList;
import java.io.*;

public class OrderHandler {
    ArrayList<Order> Orders = new ArrayList<Order>();

    /**
     * @brief constructor
     */
    public OrderHandler(){
        
    }

    /**
     * @brief creates a new order.
     */
    public void CreateOrder(){
        ArrayList<DoughnutStack> ord = new ArrayList<DoughnutStack>();
        // Adds a new order to the list passes the current size for the ID.
        Orders.add(new Order(Orders.size(), ord));        
    }
    
    public int saveOrders(){
        try {
            // Clears file or creates a new if it doesn't exist
            String str = "";
            FileWriter fp = new FileWriter("../../res/menu.csv", false);
            fp.write("catagory,style,price,quantity");

            //Begins writing
            for(int i = 0; i < Orders.size(); i++){
                str = Orders.get(i).number + String.valueOf(Orders.get(i).TotalPrice);
                str = str + String.valueOf(Orders.get(i).TotalQuantity) + Orders.get(i).status;
                str = str + Orders.get(i).date.DateToString();
            }
            fp.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }

    public int getReportData(){
        return 0;
    }

    /**
     * @brief displays all recorded orders
     * @return
     */
    public int displayOrders(){
        for(int i = 0 ; i < Orders.size(); i++){
            System.out.println("-----");
            System.out.println("Order Number: " + Orders.get(i).number);
            // Finish later
        }
        return 0;
    }
}
