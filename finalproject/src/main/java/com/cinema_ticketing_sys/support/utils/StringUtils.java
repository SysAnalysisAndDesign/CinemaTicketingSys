package com.cinema_ticketing_sys.support.utils;

/**
 * Created by KC on 2017/5/18.
 *
 * 字符串相关工具类
 */
public class StringUtils {

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.trim().length() == 0;
    }
}