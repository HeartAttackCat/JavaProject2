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

    /**
     * @brief returns the current quantity
     * @return The current quantity
     */
    int getQuantity(){
        return this.quantity;
    }

    /**
     * @breif updates the quantity of the type ordered
     * @param quantity the new quantity
     */
    void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * @breif gets the doughnut type
     * @return the doughtnut type
     */
    Doughnut getType(){
        return DoughnutType;
    }

    /**
     * @brief sets/updates the doughnut type
     * @param type the type we are setting
     */
    void setType(Doughnut type) {
        this.DoughnutType = type;
    }
}
