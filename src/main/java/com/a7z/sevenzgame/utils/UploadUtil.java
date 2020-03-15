package com.a7z.sevenzgame.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 上传工具类
 * 获取上传路径
 * @author lq
 * @create 2020/3/14-01:04
 */
public class UploadUtil {

    /**
     * 获得整个项目的根目录的绝对路径
     * @return
     */
    public static String getUploadFilePath() {
        String path = UploadUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        path = path.substring(1, path.length());
        try {
            path = URLDecoder.decode(path, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        int lastIndex = path.lastIndexOf("/") + 1;
        path = path.substring(0, lastIndex);
        File file = new File("");
        return file.getAbsolutePath() + "/";
    }
}
