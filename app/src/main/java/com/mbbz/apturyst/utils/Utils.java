package com.mbbz.apturyst.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Klasa udostępniająca różne przydatne statyczne metody
 */

public class Utils {

    private Utils() {}

    public static String getCurrentDateTime() {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy_MM_dd__hh-mm-ss", Locale.getDefault());
        Date now = new Date();
        return dt.format(now);
    }
}
