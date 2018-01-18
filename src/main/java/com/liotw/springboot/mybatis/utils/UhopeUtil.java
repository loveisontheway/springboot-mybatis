package com.liotw.springboot.mybatis.utils;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 自制工具类
 * @author jiangjialiang on 2017/12/20
 * @version 1.0.0
 */
public class UhopeUtil {

    /** 获取东八区时间 */
    public static Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));

    /**
     * 年
     * @return Integer 年份
     */
    public static Integer getYear() {
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 月，0表示1月份
     * @return Integer 月份
     */
    public static Integer getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 当前天数
     * @return int 天数
     */
    public static int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 本月最小天数
     * @return int 月最小天数
     */
    public static int getMinDayInMonth() {
        return calendar.getActualMinimum(calendar.DAY_OF_MONTH);
    }

    /**
     * 本月最大天数
     * @return int 月最大天数
     */
    public static int getMaxDayInMonth() {
        return calendar.getActualMaximum(calendar.DAY_OF_MONTH);
    }

    /**
     * 当前小时
     * @return int 时
     */
    public static int getHour() {
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 当前分钟
     * @return int 分
     */
    public static int getMinute() {
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 当前秒
     * @return int 秒
     */
    public static int getSecond() {
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 通过月份算出季度
     * @param month 月份
     * @return int 季度
     */
    public static int getQuarter(int month) {
        int quarter;
        switch (month) {
            case 1:
            case 2:
            case 3:
                quarter = 1;
                break;
            case 4:
            case 5:
            case 6:
                quarter = 2;
                break;
            case 7:
            case 8:
            case 9:
                quarter = 3;
                break;
            case 10:
            case 11:
            case 12:
                quarter = 4;
                break;
            default:
                quarter = 0;
        }
        return quarter;
    }

    /**
     * 正则表达式: 判断字符串是否为数字的方法的几种方法
     * @param str 检验的字符串
     * @return boolean true:是数字 false:不是数字
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("-?[1-9]\\d*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}
