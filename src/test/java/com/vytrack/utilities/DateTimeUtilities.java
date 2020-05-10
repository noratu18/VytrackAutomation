package com.vytrack.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilities {

    /**
     *
     * @param format MMM dd, yyyy
     * @return current date as a String
     */
    public static String getCurrentDate(String format){
        return LocalDate.now().format(DateTimeFormatter.ofPattern(format));
    }

    /**
     *
     * @param start
     * @param end
     * @param format h:m a
     * @return difference between end time and start time as a long
     */
    public static long getTimeDifference(String start, String end, String format){
        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern(format));
        LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern(format) );
        return ChronoUnit.HOURS.between(startTime, endTime);
    }
}
