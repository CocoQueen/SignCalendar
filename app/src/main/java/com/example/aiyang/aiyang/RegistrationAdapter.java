package com.example.aiyang.aiyang;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Calendar;

/**
 *
 * @author：Coco
 * date：2019/3/14
 * version：1.0
 * description:日历 适配器
 *
 */
public class RegistrationAdapter extends BaseAdapter {
    private Context context;
    private final int days;
    private final int week;
    private int[] dayNumber;
    private final int day;
    /**
     * 某年某月1号是周几
     */
    int firstDayWeek;

    public RegistrationAdapter(Context context, int days, int week, int day, int firstDayWeek) {
        this.context = context;
        this.days = days;
        this.week = week;
        this.day = day;
        this.firstDayWeek = firstDayWeek;
        getEveryDay();
    }


    @Override
    public int getCount() {
        return 42;
    }

    @Override
    public String getItem(int i) {

        return null;
    }

    @Override
    public long getItemId(int i) {
        return dayNumber[i];
    }//点击时

    private ViewHolder viewHolder;

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (null == view) {
            view = LayoutInflater.from(context).inflate(R.layout.item_registrationadatper, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.day.setText(dayNumber[i] == 0 ? "" : dayNumber[i] + "");
        //奇数天设置签到
        if (dayNumber[i] != 0 && dayNumber[i] < day && dayNumber[i] % 2 == 1) {
            viewHolder.day.setBackgroundResource(R.mipmap.member_ok);
        }
        if (dayNumber[i] == day) {
            viewHolder.day.setText(day + "");
//            view.setBackgroundResource(R.mipmap.ic_launcher);
            viewHolder.day.setTextColor(Color.parseColor("#000000"));
        }

        return view;
    }

    private class ViewHolder {
        private TextView day;

        public ViewHolder(View view) {
            this.day = (TextView) view.findViewById(R.id.day);
        }
    }

    /**
     * 得到42格子 每一格子的值
     * <p>
     * days:本月天数
     * <p>
     * week：单前日期周几
     * <p>
     * 42：本页展示数据
     * <p>
     *  +firstDayWeek
     *   思路：获得某个月一号是周几，然后将这一天设置为一号，
     *   &&前加为了将本月天数显示全，&&后加是为了确定在哪个位置标注1号
     */
    private void getEveryDay() {
        dayNumber = new int[42];
        switch (week) {
            case 0:
                for (int i = 0; i < 42; i++) {
                    if (i < days + week + firstDayWeek && i >= week + firstDayWeek) {
                        dayNumber[i] = i - week - (firstDayWeek - 1);
                    } else {
                        dayNumber[i] = 0;
                    }
                }
                break;
            case 1:
                for (int i = 0; i < 42; i++) {
                    if (i < days + week + (firstDayWeek - 1) && i >= (week + firstDayWeek - 1)) {
                        dayNumber[i] = i - week - (firstDayWeek - 2);
                    } else {
                        dayNumber[i] = 0;
                    }
                }
                break;
            case 2:
                for (int i = 0; i < 42; i++) {
                    if (i < days + week + (firstDayWeek - 2) && i >= week + (firstDayWeek - 2)) {
                        dayNumber[i] = i - week - (firstDayWeek - 3);
                    } else {
                        dayNumber[i] = 0;
                    }
                }
                break;
            case 3:
                for (int i = 0; i < 42; i++) {
                    if (i < days + week + (firstDayWeek - 3) && i >= (firstDayWeek - 3)) {
                        dayNumber[i] = i - week - (firstDayWeek - 4);
                    } else {
                        dayNumber[i] = 0;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < 42; i++) {
                    if (i < days + week + (firstDayWeek - 4) && i >= week + (firstDayWeek - 4)) {
                        dayNumber[i] = i - week - (firstDayWeek - 5);
                    } else {
                        dayNumber[i] = 0;
                    }
                }

                break;
            case 5:
                for (int i = 0; i < 42; i++) {
                    if (i < days + week + (firstDayWeek - 5) && i >= week + (firstDayWeek - 5)) {
                        dayNumber[i] = i - week - (firstDayWeek - 6);
                    } else {
                        dayNumber[i] = 0;
                    }
                }
                break;
            case 6:
                for (int i = 0; i < 42; i++) {
                    if (i < days + week + (firstDayWeek - 6) && i >= week + (firstDayWeek - 6)) {
                        dayNumber[i] = i - week - (firstDayWeek - 7);
                    } else {
                        dayNumber[i] = 0;
                    }
                }
                break;
            default:
                break;
        }
    }
}
