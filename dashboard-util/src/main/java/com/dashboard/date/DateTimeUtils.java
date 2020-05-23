package com.dashboard.date;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;

/**
 * @author konglinghui
 * @description 日期工具类
 * @date 2019/9/5 15:00
 **/
public final class DateTimeUtils implements Serializable {

    public static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static final long serialVersionUID = 5186750118608821663L;

    private DateTimeUtils() {
    }

    /**
     * 获取某年的开始时间的0时0分0秒
     *
     * @return
     */
    public static Timestamp getFirstDateTimeOfYear(int year) {
        // int year = LocalDateTime.now().getYear();
        LocalDateTime localDateTime = LocalDateTime.of(year, 1, 1, 0, 0, 0);
        return Timestamp.valueOf(localDateTime);
    }

    /**
     * 获取某年的最后一天的最后一秒
     *
     * @return
     */
    public static Timestamp getLastDateTimeOfYear(int year) {
        // int year = LocalDateTime.now().getYear();
        LocalDateTime localDateTime = LocalDateTime.of(year, 12, 31, 23, 59, 59);
        return Timestamp.valueOf(localDateTime);
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

    /**
     * 获取当前时间毫秒值
     *
     * @return
     */
    public static Timestamp currentTimeStamp() {
        return Timestamp.valueOf(LocalDateTime.now());
    }

    /**
     * 返回当前的日期
     *
     * @return
     */
    public static LocalDate getCurrentLocalDate() {
        return LocalDate.now();
    }

    /**
     * 返回当前日期时间
     *
     * @return
     */
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    /**
     * 返回当前日期字符串 yyyyMMdd
     *
     * @return
     */
    public static String getCurrentDateStr() {
        return LocalDate.now().format(DATE_FORMATTER);
    }

    /**
     * 返回当前日期时间字符串 yyyyMMddHHmmss
     *
     * @return
     */
    public static String getCurrentDateTimeStr() {
        return LocalDateTime.now().format(DATETIME_FORMATTER);
    }

    public static LocalDate parseLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    public static LocalDate parseLocalDate(String dateStr, String pattern) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, DATETIME_FORMATTER);
    }

    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String pattern) {
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 日期相隔天数
     *
     * @param startDateInclusive
     * @param endDateExclusive
     * @return
     */
    public static int periodDays(LocalDate startDateInclusive, LocalDate endDateExclusive) {
        return Period.between(startDateInclusive, endDateExclusive).getDays();
    }

    /**
     * 日期相隔小时
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationHours(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toHours();
    }

    /**
     * 日期相隔分钟
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMinutes(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMinutes();
    }

    /**
     * 日期相隔毫秒数
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long durationMillis(Temporal startInclusive, Temporal endExclusive) {
        return Duration.between(startInclusive, endExclusive).toMillis();
    }

    /**
     * 是否当天
     *
     * @param date
     * @return
     */
    public static boolean isToday(LocalDate date) {
        return getCurrentLocalDate().equals(date);
    }

    /**
     * 获取本月的第一天
     *
     * @return
     */
    public static String getFirstDayOfThisMonth() {
        return getCurrentLocalDate().with(TemporalAdjusters.firstDayOfMonth()).format(DATE_FORMATTER);
    }

    /**
     * 获取本月的最后一天
     *
     * @return
     */
    public static String getLastDayOfThisMonth() {
        return getCurrentLocalDate().with(TemporalAdjusters.lastDayOfMonth()).format(DATE_FORMATTER);
    }

    /**
     * 获取2017-01的第一个周一
     *
     * @return
     */
    public static String getFirstMonday() {
        return LocalDate.parse("2017-01-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY))
                .format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的后两周
     *
     * @return
     */
    public static String getCurDateAfterTwoWeek() {
        return getCurrentLocalDate().plus(2, ChronoUnit.WEEKS).format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的6个月后的日期
     *
     * @return
     */
    public static String getCurDateAfterSixMonth() {
        return getCurrentLocalDate().plus(6, ChronoUnit.MONTHS).format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的5年后的日期
     *
     * @return
     */
    public static String getCurDateAfterFiveYear() {
        return getCurrentLocalDate().plus(5, ChronoUnit.YEARS).format(DATE_FORMATTER);
    }

    /**
     * 获取当前日期的20年后的日期
     *
     * @return
     */
    public static String getCurDateAfterTwentyYear() {
        return getCurrentLocalDate().plus(2, ChronoUnit.DECADES).format(DATE_FORMATTER);
    }

    /**
     * 字符串转时间
     *
     * @return
     */
    public static LocalDate stringToDate(String time) {
        return LocalDate.parse(time, DATE_FORMATTER);
    }

    /**
     * 字符串转timestamp
     *
     * @param timestamp 格式：yyyy-MM-dd
     * @return
     */
    public static Timestamp stringToTimestamp(String timestamp) {
        return Timestamp.valueOf(timestamp + " 00:00:00.0");
    }
}