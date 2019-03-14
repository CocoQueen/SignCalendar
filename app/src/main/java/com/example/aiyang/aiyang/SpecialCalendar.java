package com.example.aiyang.aiyang;

import java.util.Calendar;

/**
 *
 * @author：Coco
 * date：2019/3/14
 * version：1.0
 * description:日历工具类
 *
 */
public class SpecialCalendar {

    /**
     * 判断是否是闰年
     */
    public boolean isLeapYear(int year) {
        if (year % 100 == 0 && year % 400 == 0) {
            return true;
        } else if (year % 100 != 0 && year % 4 == 0) {
            return true;
        }
        return false;
    }

    /**
     * 得到某月多少天
     * 1357810腊三十一天永不差
     * 469冬三十日平年二月28
     * 闰年再把一天加
     */
    public int getDaysOfMonth(boolean isLeapYear, int month) {
        int days = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if (isLeapYear) {
                    days = 29;
                } else {
                    days = 28;
                }
        }
        return days;

    }

    /**
     * 判断当前日期为周几0-6（周日-周六）
     */
    public int getWeekdayOfMonth(int mYear, int mMonth, int day) {
        if (mMonth < 3) {
            mMonth += 12;
            --mYear;
        }
        int w = (day + 1 + 2 * mMonth + 3 * (mMonth + 1) / 5 + mYear + (mYear >> 2) - mYear / 100 + mYear / 400) % 7;
        return w;
    }

    /**
     * 判断某年某月1号是周几的方法
     *
     * @param y 年
     * @param m 月
     * @param d 日
     * @param c 世纪
     * @return
     */
    public int getFirstDayWeek(int y, int m, int d, int c) {
        if (m == 1) {
            m = 13;
            y = y - 1;
        } else if (m == 2) {
            m = 14;
            y = y - 1;
        }
        int tempDate = (y + (y / 4) + (c / 4) - 2 * c + (26 * (m + 1) / 10) + d - 1) % 7;
        if (tempDate < 0) {
            return 7 + tempDate;
        }
        return tempDate + 1;
    }
}
