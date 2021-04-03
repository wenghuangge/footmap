package com.wenghuangge.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    /***
     * 时间戳转换成时间
     * @param time
     * @return
     */
    public static String timeChange(Long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ctime=simpleDateFormat.format(new Date(time));
        return ctime;
    }
}
