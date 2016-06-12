package com.djf.app.androiddevelop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.djf.app.androiddevelop.SlidingToFinish.SlidingActivity;
import com.djf.app.androiddevelop.activityLifecycle.ActivityLifeCycleTest;
import com.djf.app.androiddevelop.mytitle.TitleLayout;
import com.djf.app.androiddevelop.others.AnalogClockTest;
import com.djf.app.androiddevelop.others.DateAndTimeDisplay;
import com.djf.app.androiddevelop.others.LinkifyTest;
import com.djf.app.androiddevelop.others.SearchActivity;
import com.djf.app.androiddevelop.others.SpinnerAndAutoComplete;
import com.djf.app.androiddevelop.utils.MyLog;
import com.djf.app.androiddevelop.utils.MyToast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button colock;
    private Button search;
    private Button controller;
    private ViewGroup views;
    private Button display;
    private ImageView imageView;
    private Button linkify;
    private Button activitylifecycle;
    private Button slidingactivity;

    private TitleLayout title;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//  定义夜间模式资源后生效
// AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        // 隐藏掉系统自带标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        TextView SDCard= (TextView) findViewById(R.id.SDCard);
        SDCard.setText(Environment.getExternalStorageDirectory().getPath());

        title = (TitleLayout) findViewById(R.id.title);
        title.titleEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyToast.SimpleShow(MainActivity.this, "点击编辑");
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView);

        File file = new File(getFilesDir(), "ic.png");

//        String fileName = "/storage/sdcard/ic.png";
//        File file = new File(fileName);
        if (file.exists()) {
//            Bitmap bitmap = BitmapFactory.decodeFile(fileName);
            Bitmap bitmap = null;
            try {
                bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imageView.setImageBitmap(bitmap);
        }

        colock = (Button) findViewById(R.id.clock);
        colock.setOnClickListener(this);
        search = (Button) findViewById(R.id.search);
        search.setOnClickListener(this);
        controller = (Button) findViewById(R.id.controller);
        controller.setOnClickListener(this);
        display = (Button) findViewById(R.id.display);
        display.setOnClickListener(this);
        linkify = (Button) findViewById(R.id.linkify);
        linkify.setOnClickListener(this);
        activitylifecycle = (Button) findViewById(R.id.activitylifecycle);
        activitylifecycle.setOnClickListener(this);
        slidingactivity = (Button) findViewById(R.id.slidingactivity);
        slidingactivity.setOnClickListener(this);

        MyLog.i(getClass().getName());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.slidingactivity:
                Intent intent = new Intent(this, SlidingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.translate_in, 0);
                break;
            case R.id.controller:
                startActivity(new Intent(this, SpinnerAndAutoComplete.class));
                break;
            case R.id.search:
                startActivity(new Intent(this, SearchActivity.class));
                break;
            case R.id.clock:
                startActivity(new Intent(this, AnalogClockTest.class));
                break;
            case R.id.display:
                startActivity(new Intent(this, DateAndTimeDisplay.class));
                break;
            case R.id.linkify:
                startActivity(new Intent(this, LinkifyTest.class));
                break;
            case R.id.activitylifecycle:
                startActivity(new Intent(this, ActivityLifeCycleTest.class));
                break;

            default:
                break;

        }

        if (v == title.titleEdit) {

        }

    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.translate_up_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.translate_up_out);
    }
}
