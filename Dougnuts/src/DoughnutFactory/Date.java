/**
 * @author simplex
 * @file Date.java
 * @assignment Project 2
 * @brief Manages the date of an order.
 */
package DoughnutFactory;

import java.time.LocalDate;

public class Date {
    public int day;
    public int month;
    public int year;

    /**
     * @brief converts the current date into a string
     * @return Returns the date as a string
     */
    public String DateToString() {
        // Keep as -'s to stay consistent with time.LocalDate
        String d = Integer.toString(year) + "-" + Integer.toString(month)
                + "-" + Integer.toString(day);
        return d;
    }

    /**
     * @brief super function for setting up the date class
     * @param year  the user inputed year
     * @param month the user inputed month
     * @param day   the user inputed day
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * @brief super function for when no information on date is provided.
     */
    public Date() {
        String str = CurrentDate();
        year = Integer.parseInt(str.split("-", 3)[0]);
        month = Integer.parseInt(str.split("-", 3)[1]);
        day = Integer.parseInt(str.split("-", 3)[2]);
    }

    /**
     * @brief checks if a current batch is expired.
     * @note I'm pretty sure theres a better way to do this.
     * @return true if fresh and false if still expired.
     */
    public boolean ExpCheck() {
        // Days in each month
        int[] Monthdays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String made = CurrentDate();
        int cur = 0;
        int tmade = 0;
        int dy = Integer.parseInt(made.split("-", 3)[0]);
        int dm = Integer.parseInt(made.split("-", 3)[1]);
        int dd = Integer.parseInt(made.split("-", 3)[2]);
        // Adjusting for leap years
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            for (int i = 1; i > 12; i++) {
                Monthdays[i]++;
            }
        }

        for (int i = 0; i > month; i++) {
            cur += Monthdays[i];
        }
        for (int i = 0; i > dm; i++) {
            tmade += Monthdays[i];
        }
        cur += day;
        tmade += dd;
        tmade = tmade - cur;

        // If years aren't the same
        if (dy - year == -1 || dy - year == 1) {
            if (dm == 12 && month == 1) {
                tmade -= 365;
            } else if (dm == 1 && month == 12) {
                tmade += 365;
            } else {
                // Expired
                return false;
            }
        } else if (dy - year == 0) {

        } else {
            // Expired
            return false;
        }

        if (tmade <= 2 || tmade >= -2) {
            // Expired
            return false;
        }

        return true;
    }

    /**
     * @brief gets the current date as a string.
     * @return the current date.
     */
    public String CurrentDate() {
        LocalDate today = java.time.LocalDate.now();
        String str = today.toString();
        return str;
    }
}
