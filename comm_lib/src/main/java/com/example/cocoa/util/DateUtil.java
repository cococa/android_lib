package com.example.cocoa.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Administrator on 2015/8/17.
 */
public final class DateUtil {

    public static final int TAG_TODAY = 0;
    public static final int TAG_YESTERDAY = -1;
    public static final int TAG_BEFOR_YESTERDAY = -2;

    public DateUtil() {
    }


    public static final String[] FOMAT_ARRAY = {
            "yyyy-MM-dd",
            "HH:mm",
            "MM-dd HH:mm",
            "yyyy-MM-dd HH:mm",
    };


    /**
     * 字符串转时间  默认 "yyyy-MM-dd"
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        return strToDate(strDate, FOMAT_ARRAY[0]);
    }

    /**
     * 字符串转时间
     *
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 获取前天（-2）， 昨天（-1），今天(0)的日期
     *
     * @param tag
     * @return
     */
    public String getBYTDay(int tag) {
        if (tag != TAG_TODAY || tag != TAG_YESTERDAY || tag != TAG_BEFOR_YESTERDAY) {
            throw new IllegalArgumentException("DateUtil BYT TAG error");
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, tag);
        return new SimpleDateFormat(FOMAT_ARRAY[0]).format(cal.getTime());
    }


    /**
     * 获取时间是上午时段还是下午
     * 1== am
     *
     * @param date
     * @return
     */
    public static int getAmPm(long date) {
        GregorianCalendar ca = new GregorianCalendar();
        ca.setTime(new Date(date));
        return ca.get(GregorianCalendar.AM_PM);
    }

    /**
     * 获取时间是上午时段还是下午
     * 1== am
     *
     * @param date
     * @return
     */
    public static int getAmPm(Date date) {
        GregorianCalendar ca = new GregorianCalendar();
        ca.setTime(date);
        return ca.get(GregorianCalendar.AM_PM);
    }


}
