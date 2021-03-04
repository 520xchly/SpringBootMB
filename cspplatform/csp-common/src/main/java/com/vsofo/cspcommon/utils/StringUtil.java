package com.vsofo.cspcommon.utils;

/**
 * 字符串辅助类
 */
public class StringUtil {

    /**
     * 如果字符串为空或空字符串，则返回设置的默认值，否则返回原值
     */
    public static String IsNullOrEmptyStrAndReturnDefaultValue(String srcStr, String defaultValue) {
        if (srcStr == null || "".equals(srcStr.trim()) || "null".equals(srcStr.trim())) {
            return defaultValue;
        } else {
            return srcStr;
        }
    }

    /**
     * 字符串是否为空或空字符串
     */
    public static boolean IsNullOrEmptyStr(String srcStr) {
        if (srcStr == null || "".equals(srcStr.trim()) || "null".equals(srcStr.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将相对文件路径改为url中Path路径
     */
    public static String ChangeRelativeFilePathToUrlPath(String srcStr) {
        if (srcStr == null || "".equals(srcStr.trim()) || "null".equals(srcStr.trim())) {
            return "";
        } else {
            // return srcStr.replaceAll("\\.\\/|\\/\\/|\\|\\\\", "")
            return srcStr.replace("./", "/").replace("\\\\", "/").replace("\\", "/").replace("//", "/");
        }
    }
    

}
