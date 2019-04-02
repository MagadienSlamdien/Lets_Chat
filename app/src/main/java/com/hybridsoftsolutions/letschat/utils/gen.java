package com.hybridsoftsolutions.letschat.utils;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class gen {

    public String GetTimeFromCurrentDate()
    {
        Date date = new Date();
        String strDateFormat = "HH:mm";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        return formattedDate;
    }
}
