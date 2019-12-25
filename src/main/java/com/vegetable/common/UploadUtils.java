package com.vegetable.common;

import java.util.Date;

/**
 * @ClassName : UploadUtils
 * @Description : 图片上传的工具类
 * @Author : 袁田婷
 * @Date: 2019-12-24 11:10
 */
public class UploadUtils {

    /**
     * 获得新文件名称（毫秒数+4位随机数）
     *
     * @return 返回新的文件名称
     */
    public static String getFileName() {
        String fileName = null;

        // 获得1——1000之间的随机数
        int num = (int) (Math.random() * 1000 + 1);
        // 将随机数设置为4位
        String tempNum = "000" + num;
        tempNum = tempNum.substring(tempNum.length() - 4);

        Date date = new Date();
        fileName = date.getTime() + tempNum;

        return fileName;
    }


    /**
     * 返回文件的扩展名
     * @param fileName 文件名
     * @return 成功返回成功文件扩展名，否者返回null
     */
    public static String getExtendedName(String fileName) {
        if(fileName == null || fileName.length() == 0) {
            return null;
        }
        //获得文件名中.最后一次出现的位置
        int index = fileName.lastIndexOf(".");
        if(index == -1) {
            return null;
        }
        return fileName.substring(index);
    }


}
