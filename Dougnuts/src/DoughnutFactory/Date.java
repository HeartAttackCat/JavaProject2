/**
 * @author simplex
 * @file Date.java
 * @assignment Project 2
 * @brief Manages the date of an order.
 */
package DoughnutFactory;

import java.time.LocalDate;

public class Date {
    int day;
    int month;
    int year;

    /**
     * @brief converts the current date into a string
     * @return Returns the date as a string
     */
    public String DateToString(){
        // Keep as -'s to stay consistent with time.LocalDate
        String d = Integer.toString(year) + "-" + Integer.toString(month)
        + "-" + Integer.toString(day);
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
        LocalDate today = java.time.LocalDate.now();
        String str = today.toString();
        year = Integer.parseInt(str.split("-", 2)[0]);
        month = Integer.parseInt(str.split("-", 2)[1]);
        day = Integer.parseInt(str.split("-", 2)[2]);
    }

    /**
     * @brief checks if a current batch is expired.
     * 
     * @return true if expired and false if still fresh.
     */
    public boolean ExpCheck(){

        return false;
    }
}
