package br.com.guiabolsobackend.utils;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

    public static Date setDate(int day, int monday, int year) {
        Calendar calendar = getCurrentDateCalendar();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.MONDAY, monday);
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

    public static Calendar getCurrentDateCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    public static Date setDateRandom(int monday, int year) {
        Calendar calendar = getCurrentDateCalendar();
        calendar.set(Calendar.MONDAY, monday);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_MONTH,
                IntegerUtil.aleatorioNaFaixa(1, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)));
        return calendar.getTime();
    }



}
