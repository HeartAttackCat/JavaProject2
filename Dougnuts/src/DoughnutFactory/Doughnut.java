/**
 * @author simplex
 * @file Doughtnut.java
 * @assignment Project 2
 * @brief Class for holding information on a single doughnut type
 */
package DoughnutFactory;

public class Doughnut {
    public String Style;
    public String catagory;
    public float Cost;

    /**
     * @brief constructor class
     * @param St  Style of doughnut
     * @param Cat Catagory the doughnut falls under
     * @param c   Cost of the doughnut
     * @param x   quantity of doughnuts; This is temporary.
     */
    public Doughnut(String Cat, String St, float c) {
        Style = St;
        catagory = Cat;
        Cost = c;
    }

}
