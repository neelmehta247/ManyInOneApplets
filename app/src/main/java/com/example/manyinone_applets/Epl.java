package com.example.manyinone_applets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Epl extends Activity implements OnClickListener {
	Button liv, manu, chel, ret;
	TextView t;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.football);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		liv = (Button) findViewById(R.id.UseButton1);
		manu = (Button) findViewById(R.id.UseButton2);
		chel = (Button) findViewById(R.id.UseButton3);
		liv.setText("Liverpool");
		manu.setText("Manchester United");
		chel.setText("Chelsea");
		t = (TextView) findViewById(R.id.textView1);
		ret = (Button) findViewById(R.id.menFB);
		ret.setOnClickListener(this);
		liv.setOnClickListener(this);
		manu.setOnClickListener(this);
		chel.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.UseButton1:
			Intent i = new Intent("com.example.manyinone_applets.LIVERPOOL");
			startActivity(i);
			break;
		case R.id.UseButton3:
			Intent a = new Intent("com.example.manyinone_applets.CHELSEA");
			startActivity(a);
			break;
		case R.id.UseButton2:
			Intent q = new Intent("com.example.manyinone_applets.MANCHESTERUTD");
			startActivity(q);
			break;
		case R.id.menFB:
			Intent z = new Intent("com.example.manyinone_applets.FOOTBALLINFO");
			startActivity(z);
			break;
		}
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
