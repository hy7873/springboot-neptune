package com.hy.utils;

import com.sun.javafx.css.CalculatedValue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: wanghai
 * @Date:2019/12/1 17:27
 * @Copyright:reach-life
 * @Description:
 */
public class DateUtils {

    public static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();

    public static DateFormat getDateFormat(String pattern) {
        DateFormat df = threadLocal.get();
        if (df == null) {
            df = new SimpleDateFormat(pattern);
            threadLocal.set(df);
        }
        return df;
    }

    public static String safeFormat(Date date,String pattern) {
        return getDateFormat(pattern).format(date);
    }

    public static Date safeParse(String dateStr,String pattern) {
        try {
            return getDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getTodayLast() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        return calendar.getTime();
    }

}
