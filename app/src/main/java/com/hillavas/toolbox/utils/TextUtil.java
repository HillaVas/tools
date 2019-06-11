package com.hillavas.toolbox.utils;

import java.util.Locale;
import java.util.StringTokenizer;

public class TextUtil {

    public static boolean isValidNumber(String number) {
        return android.text.TextUtils.isDigitsOnly(number) && number.length() == 11 && number.startsWith("09");
    }

    public static boolean isNetworkUrl(String url) {
        return (url.length() > 6 && url.startsWith("http://")) || (url.length() > 7 && url.startsWith("https://"));
    }

    public static boolean nonNullString(String in) {
        return in != null && in.trim().length() > 0;
    }

    public static String stringTrimmer(String text) {
        if (text != null) {
            return text.trim();
        } else
            return null;
    }

    public static String getDuration(int runTime){
        Locale locale = new Locale("fa");
        return String.format(locale, "مدت فیلم: %d دقیقه", runTime);
    }

    public static String getReleaseDate(String releaseDate){
        Locale locale = new Locale("fa");
        if (releaseDate == null) {
            releaseDate = "--";
        }
        return String.format(locale, "تاریخ انتشار: %s", releaseDate);
    }

    public static String getFormattedNumber(String number){
        number = number.replaceAll(",", "");
        if (number.length() > 0) {
            StringBuilder builder = new StringBuilder();
            for (int i = number.length() - 1; i >= 0; i--) {
                if (i != 0 && i % 3 == 0)
                    builder.insert(0, ",");
                builder.insert(0, number.charAt(i));
            }
            if (builder.charAt(builder.length() - 1) == ',')
                builder.deleteCharAt(builder.length() - 1);

            return builder.toString();
        }
        return "";
    }

    public static String getDecimalFormat(String value)
    {
        StringTokenizer lst = new StringTokenizer(value, ".");
        String str1 = value;
        String str2 = "";
        if (lst.countTokens() > 1)
        {
            str1 = lst.nextToken();
            str2 = lst.nextToken();
        }
        String str3 = "";
        int i = 0;
        int j = -1 + str1.length();
        if (str1.charAt( -1 + str1.length()) == '.')
        {
            j--;
            str3 = ".";
        }
        for (int k = j;; k--)
        {
            if (k < 0)
            {
                if (str2.length() > 0)
                    str3 = str3 + "." + str2;
                return str3;
            }
            if (i == 3)
            {
                str3 = "," + str3;
                i = 0;
            }
            str3 = str1.charAt(k) + str3;
            i++;
        }
    }

    public static String getProducer(String producer){
        Locale locale = new Locale("fa");
        if (!nonNullString(producer)) {
            producer = "--";
        }

        return String.format(locale, "فروشنده: %s", producer);
    }

    public static String getFileExtension(String fileName){
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }

    public static String getProgressTextTime(int totalSeconds) {
        String time = "";
        int min = totalSeconds / 60;
        int sec = totalSeconds % 60;
        if (min < 10)
            time += "0";
        time = time + min + ":";
        if (sec < 10)
            time = time + "0";
        time += sec;
        return time;
    }
}
