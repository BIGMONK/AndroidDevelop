package com.djf.app.androiddevelop.SlidingToFinish;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.djf.app.androiddevelop.R;

public class SlidingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 隐藏掉系统自带标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_sliding_layout);

		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(SlidingActivity.this,
						SecondActivity.class));
			}
		});
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(0,R.anim.translate_out);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(0,R.anim.translate_out);
	}
}
