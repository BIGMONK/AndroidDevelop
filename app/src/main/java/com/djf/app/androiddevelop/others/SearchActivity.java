package com.djf.app.androiddevelop.others;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.djf.app.androiddevelop.R;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/8.
 */
public class SearchActivity extends Activity implements View.OnClickListener {

    private EditText et_input;
    private TextView tv_result;
    private Button bt_search;
    private String result = "";
    private ArrayList<String> filePathList;
    private File file;
    private File storageDirectory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        et_input = (EditText) findViewById(R.id.et_input);
        tv_result = (TextView) findViewById(R.id.tv_result);
        bt_search = (Button) findViewById(R.id.bt_search);

        bt_search.setOnClickListener(this);
        filePathList = new ArrayList<String>();
        storageDirectory = new File("/storage/sdcard");

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_search) {
            getFilePathList(storageDirectory, filePathList);
            String key = et_input.getText().toString().trim();
            if (TextUtils.isEmpty(key)) {
                tv_result.setText("请输入搜索内容");
                return;
            }

            StringBuffer sb = new StringBuffer();
            for (String s : filePathList) {
                if (s.contains(key)) {
                    sb.append(s + "\n");
                }
            }
            if (sb.length() > 0) {
                tv_result.setText(sb.toString());

            } else {
                tv_result.setText("搜不到哦");
            }
        }
    }

    private void getFilePathList(File file, ArrayList<String> list) {
        if (file.exists() && file.isDirectory()) {
            for (File f : file.listFiles()) {
                getFilePathList(f, list);
            }
        }
        list.add(file.getPath());
        System.out.println(file.getPath());
    }
}
