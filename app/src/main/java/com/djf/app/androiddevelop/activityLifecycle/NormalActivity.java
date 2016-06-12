package com.djf.app.androiddevelop.activityLifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.djf.app.androiddevelop.R;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.djf.app.androiddevelop.utils.LogUtil.d;

/**
 * Created by Administrator on 2016/5/9.
 */
public class NormalActivity extends Activity{
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_layout);
        d("%s", "onCreate");

        tv= (TextView) findViewById(R.id.tv);

        //HashMap测试
        HashMap<Integer,String> hashMap=new HashMap<>();
        hashMap.put(1,"a");
        hashMap.put(2,"b");
        hashMap.put(3,"c");
        hashMap.put(3,"d");

        Set<Integer> integers = hashMap.keySet();
        for (int i = 0; i <integers.size(); i++) {
            System.out.println(integers.toArray()[i]);
        }
        Collection<String> values = hashMap.values();
        for (int i = 0; i <values.size() ; i++) {
            System.out.println(values.toArray()[i]);
        }

        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        Object[] objects = entries.toArray();
        for (int i = 0; i <entries.size() ; i++) {
            System.out.println(objects[i].toString());
        }
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
