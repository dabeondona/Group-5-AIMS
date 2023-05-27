
package com.mycompany.japps;


public class newsletterContent {
    private String month;
    private String day;
    private int dayInt;
    
    public newsletterContent(String month, String day, int dayInt) {
        this.month = month;
        this.day = day;
        this.dayInt = dayInt;
    }
    
    public String toString() {
        return month + " " + dayInt;
    }
}
