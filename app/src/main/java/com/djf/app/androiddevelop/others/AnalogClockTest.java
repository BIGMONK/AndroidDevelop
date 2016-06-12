package com.djf.app.androiddevelop.others;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.AnalogClock;
import android.widget.TextView;

import com.djf.app.androiddevelop.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/8.
 */
public class AnalogClockTest extends Activity {

    private AnalogClock analogColock;
    private TextView tv_time;

    private Handler mHandler;
    private Thread mColockThread;
    private String timeString;
    private SimpleDateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analogcolock);

        analogColock = (AnalogClock) findViewById(R.id.ac);
        tv_time = (TextView) findViewById(R.id.tv_time);

        sdf = new SimpleDateFormat("HH:mm:ss");

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                setTime();
            }
        };

        setTime();

    }

    private void setTime() {
        long time = System.currentTimeMillis();
        timeString = sdf.format(new Date(time));
        tv_time.setText(timeString);
        mHandler.sendEmptyMessageDelayed(10, 1000);
    }

}
