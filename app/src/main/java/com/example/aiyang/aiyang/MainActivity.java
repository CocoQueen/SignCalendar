package com.example.aiyang.aiyang;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author：Coco
 * date：2019/3/14
 * version：1.0
 * description:本月日历
 *
 */
public class MainActivity extends AppCompatActivity implements GridView.OnItemClickListener {
    private GridView registration_calendar_gv;
    private TextView today;
    private RegistrationAdapter adapter;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
    //年
    int mMonth = 0;
    //月
    int mYear = 0;
    //日
    int mDay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registration_calendar_gv = (GridView) findViewById(R.id.registration_calendar_gv);
        today = (TextView) findViewById(R.id.today);

        Calendar calendar = Calendar.getInstance();
        // 获取当前年份
        mYear = calendar.get(Calendar.YEAR);
        // 获取当前月份以（0开头）
        mMonth = calendar.get(Calendar.MONTH) + 1;
        // 获取当前天以（0开头）
        mDay = calendar.get(Calendar.DATE);

        SpecialCalendar mCalendar = new SpecialCalendar();
        boolean isLeapYear = mCalendar.isLeapYear(mYear);
        int mDays = mCalendar.getDaysOfMonth(isLeapYear, mMonth);
        int week = mCalendar.getWeekdayOfMonth(mYear, mMonth, mDay);
        int firstDayWeek = mCalendar.getFirstDayWeek(mYear, mMonth, 1, 21);

        adapter = new RegistrationAdapter(this, mDays, week, mDay, firstDayWeek);
        registration_calendar_gv.setAdapter(adapter);
        registration_calendar_gv.setOnItemClickListener(this);
//        today.setText(mYear + "年" + mMonth + "月" + mDay + "日");
        //不显示日
        if (mMonth < 10) {
            today.setText(mYear + "/0" + mMonth + "");
        } else {
            today.setText(mYear + "/" + mMonth + "");
        }
    }

    /**
     * 点击事件切换为签到
     *
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String today = mYear + "-" + mMonth + "-" + l;
        if (l != 0) {
            if (l == mDay) {
                TextView today_tv = (TextView) view.findViewById(R.id.day);
                today_tv.setBackgroundResource(R.mipmap.member_ok);
                today_tv.setTextColor(Color.BLACK);
                today_tv.setText(l + "");
                view.setBackgroundColor(Color.parseColor("#ffffff"));
                Toast.makeText(view.getContext(), "签到成功", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(view.getContext(), "您选择的日期：" + today, Toast.LENGTH_SHORT).show();

            }
        }
    }
}
