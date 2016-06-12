package com.djf.app.androiddevelop.activityLifecycle;

import android.app.Activity;
import android.os.Bundle;

import com.djf.app.androiddevelop.R;

import static com.djf.app.androiddevelop.utils.LogUtil.d;

/**
 * Created by Administrator on 2016/5/9.
 */
public class DialogActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_layout);
        d("%s", "onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        d("%s", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        d("%s", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        d("%s", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        d("%s", "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        d("%s", "onDestroy");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        d("%s", "onRestart");
    }
}
