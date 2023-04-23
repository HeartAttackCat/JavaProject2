/**
 * @author simplex
 * @file OrderHandler.java
 * @assignment Project 2
 * @brief Manager class for orders
 */
package DoughnutFactory;
import java.util.ArrayList;

public class OrderHandler {
    ArrayList<Order> Orders = new ArrayList<Order>();

    /**
     * @brief constructor
     */
    OrderHandler(){
        
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
        return 0;
    }

    public int loadOrders(){
        return 0;
    }

    public int getReportData(){
        return 0;
    }

    public int displayOrders(){
        return 0;
    }
}
