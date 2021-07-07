package com.github.bashdi.wildcard.shutdownapp.logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeConverter {

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
}
