package com.sholder552gmail.eofcalendar;

public class Data {

    public boolean hasMonthCxt = false;
    public String month = "jan";

    private static Data data = new Data();

    //Have a data structure in here to take in all months with 30 days and map them, and all months with 31 days and map them

    public int getMonthInfo() {
    /* checks our month variable and sends back the amount of days within the month. Could then use this data to add a couple fragments
    on to each end of our pageviewer. Then we could have a buttons 'View Next Month' and 'View Previous Month' to allow people to switch
    over and keep reading.
     */
        int[] monthArray = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (data.hasMonthCxt) {
            if (data.month == "jan"){
                return monthArray[0];
            }
            if (data.month == "feb"){
                return monthArray[1];
            }
            if (data.month == "mar"){
                return monthArray[2];
            }
            if (data.month == "apr"){
                return monthArray[3];
            }
            if (data.month == "may"){
                return monthArray[4];
            }
            if (data.month == "jun"){
                return monthArray[5];
            }
            if (data.month == "jul"){
                return monthArray[6];
            }
            if (data.month == "aug"){
                return monthArray[7];
            }
            if (data.month == "sep"){
                return monthArray[8];
            }
            if (data.month == "oct"){
                return monthArray[9];
            }
            if (data.month == "nov"){
                return monthArray[10];
            }
            if (data.month == "dec"){
                return monthArray[11];
            }
        }
        return monthArray[0];
    };

    public static Data getInstance()
    {
        return data;
    }
}
