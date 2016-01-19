package com.example.test46;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Color;

public class MainActivity extends Activity {

	int i = 20;
	int max = 100;
	private CustomProgressBar customProgress;
	
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (i < max) {
				int progress = ++i;
				customProgress.setProgress(progress);
				customProgress.setText(progress + "/" + max);
				handler.sendEmptyMessageDelayed(0, 200);
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();

	}

	private void initView() {
		float density = getResources().getDisplayMetrics().density;
		customProgress = (CustomProgressBar) findViewById(R.id.text1);
		customProgress.setBackgroundColor(Color.GRAY);
		customProgress.setProgressColor(Color.GREEN);
		customProgress.setTextColor(Color.BLACK);
		customProgress.setCorner((int) (density * 20 / 2));
		customProgress.setTextSize((int) (density * 14));
		
		handler.sendEmptyMessage(0);


	}


}
