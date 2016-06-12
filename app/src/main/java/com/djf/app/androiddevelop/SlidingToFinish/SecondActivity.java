package com.djf.app.androiddevelop.SlidingToFinish;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.djf.app.androiddevelop.R;

import java.util.ArrayList;

public class SecondActivity extends BaseActivity {
    ArrayList<String> datas = new ArrayList<>();
    private ListView lv;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_layout);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        //设置刷新时动画的颜色，可以设置4个
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_green_light);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        //隐藏刷新图标
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 6000);
            }
        });

        for (int i = 0; i < 20; i++) {
            datas.add(i + "SwipeRefreshLayout");
        }
        lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        lv.setAdapter(adapter);


    }
}
