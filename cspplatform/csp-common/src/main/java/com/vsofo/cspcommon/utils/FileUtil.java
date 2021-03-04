package com.vsofo.cspcommon.utils;

import java.io.File;
import java.nio.file.Paths;

/**
 * 文件操作辅助类
 */
public class FileUtil {
    /**
     * 合并路径 prefixPath /123，suffixPath /234 => /123/234
     */
    public static String CombinePath(String prefixPath, String suffixPath) {
        if (prefixPath == null || prefixPath.trim().equals("")) {
            prefixPath = "";
        }
        if (suffixPath == null || suffixPath.trim().equals("")) {
            suffixPath = "";
        }
        return Paths.get(prefixPath, suffixPath).toString();
    }

    /**
     * 获取应用程序运行的当前路径
     */
    public static String GetApplicationCurrentPath() {
        return System.getProperty("user.dir");
    }

    /**
     * 根据 fileNameFilter 文件名过滤器找出所有directory文件夹下符合数组中规定的文件名的文件
     */
    public static File[] ListFilesByFileNameArrayFilter(String directory, String[] fileNameFilter) {
        if (directory == null || "".equals(directory.trim()) || fileNameFilter == null || fileNameFilter.length == 0) {
            return null;
        }
        File file = new File(directory);
        File[] files = file.listFiles((dirPath, fileName) -> {
            for (String filterName : fileNameFilter) {
                if (fileName.equals(filterName)) {
                    return true;
                } else {
                    continue;
                }
            }
            return false;
        });
        file = null;
        return files;
    }

    /**
     * 获取文件后缀名不带点 exe jpg pdf ...
     */
    public static String GetExtensionNameNoDot(String filename) {

        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot > -1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

}