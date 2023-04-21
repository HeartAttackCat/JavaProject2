/**
 * @author simplex
 * @file DoughtnutStack.java
 * @assignment Project 2
 * @brief Class that manages the doughnut stack for various types on a person's
 * order.
 */
package DoughnutFactory;

public class DoughnutStack {
    Doughnut DoughnutType;
    int quantity;
    Date expire;
    boolean good;

    /**
     * @brief constructor
     */
    DoughnutStack(String Y, String M, String D, Doughnut t){
        quantity = 20;


        
    }

    /**
     * @brief returns the current quantity
     * @return The current quantity
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * @breif updates the quantity of the type ordered
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * @breif gets the doughnut type
     * @return the doughtnut type
     */
    public Doughnut getType(){
        return DoughnutType;
    }

    /**
     * @brief sets/updates the doughnut type
     * @param type the type we are setting
     */
    public void setType(Doughnut type) {
        this.DoughnutType = type;
    }
}
