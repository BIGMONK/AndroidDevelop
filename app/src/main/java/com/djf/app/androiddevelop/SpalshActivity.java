package com.djf.app.androiddevelop;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.djf.app.androiddevelop.utils.MyLog;
import com.djf.app.androiddevelop.utils.ThreadUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


public class SpalshActivity extends AppCompatActivity {

    Handler handler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(SpalshActivity.this, MainActivity.class));
            finish();
            // 第一个参数是下一个activity启动的动画，第二个参数是当前activity结束的动画
            overridePendingTransition(R.anim.translate_down_in, R.anim.translate_up_out);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh);

        //初始化界面动画
        overridePendingTransition(R.anim.animzoomin, 0);

        ImageView imageView = (ImageView) findViewById(R.id.iv_icon);

        TranslateAnimation translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0.5f);
        translateAnimation.setDuration(1000);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new OvershootInterpolator());

        imageView.startAnimation(translateAnimation);


        ThreadUtils.runOnBackThread(new Runnable() {
            @Override
            public void run() {
                String[] fileName = {"ic.png"};
                for (String string : fileName) {
                    MyLog.i("准备copy" + string);
                    File file = new File(getFilesDir(), string);
                    if (file.exists() && file.length() > 0) {
                        MyLog.i("不用copy" + string);
                        continue;
                    }
                    MyLog.i("正在copy" + string);
                    // 拿到资产目录的管理者
                    AssetManager assetManager = getAssets();
                    try {
                        InputStream inputStream = assetManager.open(string);
                        // 定义输出流
                        FileOutputStream fileOutputStream = openFileOutput(
                                string, MODE_PRIVATE);
                        int len = -1;
                        byte[] buf = new byte[2048];
                        while ((len = inputStream.read(buf)) != -1) {
                            fileOutputStream.write(buf, 0, len);
                        }
                        inputStream.close();
                        fileOutputStream.close();

                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });

        handler.postDelayed(r, 2000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (handler != null) {
            handler.removeCallbacks(r);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacks(r);
        }
    }
}
