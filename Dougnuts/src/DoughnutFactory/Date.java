/**
 * @author simplex
 * @file Date.java
 * @assignment Project 2
 * @brief Manages the date of an order.
 */
package DoughnutFactory;

public class Date {
    int day;
    int month;
    int year;

    /**
     * @brief converts the current date into a string
     * @return Returns the date as a string
     */
    public String DateToString(){
        String d = Integer.toString(year) + "\\" + Integer.toString(month)
        + "\\" + Integer.toString(day);
        return d;
    }

    /**
     * @brief super function for setting up the date class
     * @param year the user inputed year
     * @param month the user inputed month
     * @param day the user inputed day
     */
    Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * @brief super function for when no information on date is provided.
     */
    Date(){
        
    }
}
