package com.djf.app.androiddevelop.mytitle;/**
 * Created by Administrator on 2016/5/15.
 */

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.djf.app.androiddevelop.R;

/**
 * ProjectName：AndroidDevelop
 * PackageName:com.djf.app.androiddevelop.mytitle
 * FileName:TitleLayout
 * Administrator  2016/5/15   19:25
 */
public class TitleLayout extends LinearLayout {

    public  Button titleBack;
    public  Button titleEdit;

    public TitleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.title, this);

        this.titleBack = (Button) findViewById(R.id.title_back);
        this.titleEdit = (Button) findViewById(R.id.title_edit);
        this.titleBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();

            }
        });

        this.titleEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You clicked Edit button",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
