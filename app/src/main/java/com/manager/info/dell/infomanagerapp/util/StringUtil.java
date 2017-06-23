package com.manager.info.dell.infomanagerapp.util;

/**
 * Description
 * <p>
 * Created by Liu Huanbin
 * 2017/6/23
 */

public class StringUtil {
    public static boolean isEmpty(String s) {
        if (s == null || s.trim().length() == 0) {
            return true;
        }
        return false;
    }
}
