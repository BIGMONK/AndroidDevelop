package com.djf.app.androiddevelop.activityLifecycle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.djf.app.androiddevelop.R;

import java.util.ArrayList;

import static com.djf.app.androiddevelop.utils.LogUtil.d;

/**
 * Created by Administrator on 2016/5/9.
 */
public class ActivityLifeCycleTest extends Activity {
    public static ArrayList<String> lifecycle=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_lifecycletest);
        d("%s", "onCreate");
      
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLifeCycleTest.this,
                        NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLifeCycleTest.this,
                        DialogActivity.class);
                startActivity(intent);
            }
        });
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
