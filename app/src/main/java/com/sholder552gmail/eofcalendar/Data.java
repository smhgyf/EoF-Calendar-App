package com.sholder552gmail.eofcalendar;

public class Data {

    public boolean hasMonthCxt = false;
    public String month = "jan";

    private static Data data = new Data();

    public static Data getInstance()
    {
        return data;
    }
}
