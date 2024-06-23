package com.example.flightsandsearchservice.utils;

import java.util.Date;

public class Helper {
    public Boolean compareDate(Date date1, Date date2) {
        if(date1.before(date2)){
            return true;
        }
        return false;
    }
}
