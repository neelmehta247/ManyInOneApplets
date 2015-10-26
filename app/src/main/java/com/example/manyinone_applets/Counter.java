package com.example.manyinone_applets;

import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Counter extends Activity {
	static int counter;
	Button add, sub, res, men;
	TextView display;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_counter);
		counter = 0;
		add = (Button) findViewById(R.id.bAdd);
		men = (Button) findViewById(R.id.bMenu);
		sub = (Button) findViewById(R.id.bSub);
		res = (Button) findViewById(R.id.bRes);
		display = (TextView) findViewById(R.id.tvDisp);
		add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				counter++;
				display.setText("The Total Is " + counter);
			}
		});
		sub.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				counter--;
				display.setText("The Total Is " + counter);
			}
		});
		res.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				counter = 0;
				display.setText("The Total Is " + counter);
			}
		});
		men.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a = new Intent("com.example.manyinone_applets.MENU");
				startActivity(a);
			}
		});
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
