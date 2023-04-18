/**
 * @author simplex
 * @file Doughtnut.java
 * @assignment Project 2
 * @brief Class for holding information on a single doughnut type
 */
package DoughnutFactory;

public class Doughnut {
    String Style;
    String catagory;
    float Cost;
    int count;

    /**
     * @brief constructor class
     * @param St Style of doughnut
     * @param Cat Catagory the doughnut falls under
     * @param c Cost of the doughnut
     * @param x quantity of doughnuts; This is temporary.
     */
    Doughnut(String St, String Cat, float c, int x){
        Style = St;
        catagory = Cat;
        Cost = c;
        count = x;
    }

}
