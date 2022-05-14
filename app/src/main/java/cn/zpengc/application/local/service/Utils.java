package cn.zpengc.application.local.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

    public static String formatDate(Date date) {
        return fmt.format(date);
    }

    public static boolean isSameDate(Date d1, Date d2) {
        return fmt.format(d1).equals(fmt.format(d1));
    }

    public static boolean isEmpty(String value) {
        if(value == null || value == "" || value.trim().length()==0) {
            return true;
        }
        return false;
    }
}
