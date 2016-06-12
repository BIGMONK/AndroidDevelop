package com.djf.app.androiddevelop.others;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.djf.app.androiddevelop.R;

/**
 * Created by Administrator on 2016/5/8.
 */
public class LinkifyTest extends Activity {

    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkifytest);

        textView= (TextView) findViewById(R.id.myTextview1);
        editText= (EditText) findViewById(R.id.myEditText1);


        editText.setOnKeyListener(new EditText.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

               textView.setText(editText.getText());

                Linkify.addLinks(textView,Linkify.WEB_URLS|Linkify.EMAIL_ADDRESSES|Linkify.PHONE_NUMBERS);

                return false;
            }

        });
    }
}
