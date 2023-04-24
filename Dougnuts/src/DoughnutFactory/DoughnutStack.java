/**
 * @author simplex
 * @file DoughtnutStack.java
 * @assignment Project 2
 * @brief Class that manages the doughnut stack for various types on a person's
 * order.
 * 
 * TODO: add functions for the individual stacks and operations with removing and adding doughnuts from them
 *      Generate two reports Expired and Good. Update good upon exiting and expired upon opening.
 */
package DoughnutFactory;

public class DoughnutStack {
    public Doughnut DoughnutType;
    public int quantity;
    Date expire;
    boolean good;

    /**
     * @brief constructor for newly backed stacks
     */
    DoughnutStack(Date D, Doughnut t) {
        quantity = 20;
        DoughnutType = t;
        expire = D;
        good = expire.ExpCheck();
        if (good == false) {
            // Implement code in the senario where the doughnut is bad.
        }
    }

    /**
     * @brief Constructor for loading orders.
     * @param D     Date
     * @param t     Doughnut information
     * @param quant quantity we are loading in.
     * @param fresh if the doughnut is fresh or not
     */
    DoughnutStack(Date D, Doughnut t, int quant, boolean fresh) {
        expire = D;
        DoughnutType = t;
        quantity = quant;
        good = fresh;
    }

    /**
     * @breif Constructor for customer orders
     */
    public DoughnutStack(Doughnut t, int quant) {
        expire = new Date();
        DoughnutType = t;
        quantity = quant;
        // Assumed because customer is ordering it was already checked to be good.
        good = true;
    }

    /**
     * @brief returns the current quantity
     * @return The current quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * @breif updates the quantity of the type ordered
     * @param quantity the new quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @breif gets the doughnut type
     * @return the doughtnut type
     */
    public Doughnut getType() {
        return DoughnutType;
    }

    /**
     * @brief sets/updates the doughnut type
     * @param type the type we are setting
     */
    public void setType(Doughnut type) {
        this.DoughnutType = type;
    }

    /**
     * @brief expanded version that prints the current dought stack.
     */
    public void PrintStackInfo() {
        System.out.println(DoughnutType.catagory + " " + DoughnutType.Style);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + (DoughnutType.Cost * quantity));
    }
}
