package com.universe.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Provides handy functions for managing {@link Date}s
 *
 * @since 22/01/2017.
 */
public class DateUtilities {

    /**
     * A reverse date order formatted timestamp
     * @return the formatted date
     */
    public static String getFormattedCurrentDateTime() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date());
    }
}
