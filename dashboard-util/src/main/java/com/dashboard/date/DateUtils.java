package com.dashboard.date;

import java.time.LocalDateTime;

/**
 * @author konglinghui
 * @description 日期工具类
 * @date 2019/9/5 15:00
 **/
public final class DateUtils {

    private DateUtils() {
    }

    /**
     * 获取当天开始时间
     *
     * @return
     */
    public static LocalDateTime startDateTimeOfDay() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }
}
