package com.djf.app.androiddevelop.others;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import com.djf.app.androiddevelop.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/8.
 */
public class SpinnerAndAutoComplete extends Activity {

    /**
     * 选择填充
     */
    private Spinner spinner;
    /**
     * 自动完成
     */
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller_layout);

        initView();

        initData();

    }

    /**
     * 填充数据
     */
    private void initData() {
        String[] strings = new String[]{"AAAA", "ABBBB", "ABCCCC", "ABCDDDD"};

        ArrayList<String> datas = new ArrayList<String>() {
        };

        for (String string : strings) {
            datas.add(string);
        }

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, datas);
        spinner.setAdapter(spinnerArrayAdapter);

        ArrayAdapter<String> autoCompleteTextViewAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, datas);
        autoCompleteTextView.setAdapter(autoCompleteTextViewAdapter);


    }

    /**
     * 初始化布局、控件
     */
    private void initView() {
        spinner = (Spinner) findViewById(R.id.spinner);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

    }
}
