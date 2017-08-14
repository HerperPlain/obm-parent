package com.obm.common.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Harper.Plain(hp.黄朴)
 * 数据格式化处理，及数据判断类
 */
public class StringUtils {

    public static String charsToString(char[] chars){
        String str = "";
        for (char c :chars){
            str+=c;
        }
        return str;
    }
    public static boolean isEmpty(String data){
        if( data == null ) return true;
        if( "".equals(data.trim()) ) return true;
        if( "undefined".equalsIgnoreCase(data.trim()) ) return true;
        return false;
    }
    public static String getIpAddress(HttpServletRequest request) {
        String localIP = "127.0.0.1";
        String ip = request.getHeader("x-forwarded-for");
        if (isEmpty(ip) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (isEmpty(ip) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (isEmpty(ip) || (ip.equalsIgnoreCase(localIP)) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
