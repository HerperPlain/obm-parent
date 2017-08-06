package com.obm.common.util;

public class StringUtils {

    public static String charsToString(char[] chars){
        String str = "";
        for (char c :chars){
            str+=c;
        }
        return str;
    }
}
