package com.github.bashdi.wildcard.shutdownapp.logic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TimeConverter {

    public static LocalDateTime addToCurrentTime(int hours, int minutes, int seconds) {
        return  getCurrentTime().plusHours(hours).plusMinutes(minutes).plusSeconds(seconds);
    }

    public static LocalDateTime getCurrentTime() {
        return LocalDateTime.now();
    }

    public static String localDateTimeToString(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yy hh:mm");
        return localDateTime.format(dateTimeFormatter);
    }
}
