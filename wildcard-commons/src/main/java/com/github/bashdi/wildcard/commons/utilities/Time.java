package com.github.bashdi.wildcard.commons.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {

    public static LocalDateTime addToCurrentTime(int seconds) {
        return addToCurrentTime(0,0, seconds);
    }



    public static LocalDateTime addToCurrentTime(int minutes, int seconds) {
        return addToCurrentTime(0,minutes, seconds);
    }



    public static LocalDateTime addToCurrentTime(int hours, int minutes, int seconds) {
        return  getCurrentTime().plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
    }



    public static LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }



    public static String localDateTimeToString(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        return dateTimeFormatter.format(localDateTime);
    }



    public static int toSeconds(int hours, int minutes) {
        return toSeconds(0, hours, minutes);
    }



    public static int toSeconds(int days, int hours, int minutes) {
        int seconds = 0;
        hours += days * 24;
        minutes += hours * 60;
        seconds = minutes * 60;
        return seconds;
    }

}
