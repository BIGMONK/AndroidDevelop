package com.djf.app.androiddevelop.others;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.djf.app.androiddevelop.R;
import com.djf.app.androiddevelop.animation.TVOffAnimation;

/**
 * Created by Administrator on 2016/5/8.
 */
public class DateAndTimeDisplay extends Activity {

    private DatePicker datePicker;
    private TimePicker timePicker;
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    private TextView tv_display;

    private ScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateandtimedisplay);

        sv= (ScrollView) findViewById(R.id.sv);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);


        tv_display = (TextView) findViewById(R.id.tv_display);

        datePicker.init(mYear, mMonth, mDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                updateDisplay();
            }
        });
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                mHour=hourOfDay;
                mMinute=minute;
                updateDisplay();
            }
        });
    }

    private void updateDisplay() {
        tv_display.setText(new StringBuffer().append(mYear)
                .append("/")
                .append(mMonth)
                .append("/")
                .append(mDay)
                .append("\t")
                .append(mHour)
                .append(":")
                .append(mMinute)
        );
    }

    @Override
    public void finish() {


        super.finish();
    }
}
