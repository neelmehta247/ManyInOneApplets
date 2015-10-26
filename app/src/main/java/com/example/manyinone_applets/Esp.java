package com.example.manyinone_applets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Esp extends Activity implements OnClickListener {
	Button barca, real, athel, ret;
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
		barca = (Button) findViewById(R.id.UseButton1);
		real = (Button) findViewById(R.id.UseButton2);
		athel = (Button) findViewById(R.id.UseButton3);
		athel.setVisibility(View.GONE);
		barca.setText("F.C.Barcelona");
		real.setText("Real Madrid");
		athel.setText("Atheletico Madrid");
		t = (TextView) findViewById(R.id.textView1);
		ret = (Button) findViewById(R.id.menFB);
		ret.setOnClickListener(this);
		barca.setOnClickListener(this);
		real.setOnClickListener(this);
		athel.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.UseButton1:
			Intent i = new Intent("com.example.manyinone_applets.BARCELONA");
			startActivity(i);
			break;
		case R.id.UseButton3:
			Intent a = new Intent("com.example.manyinone_applets.ATHEL");
			startActivity(a);
			break;
		case R.id.UseButton2:
			Intent q = new Intent("com.example.manyinone_applets.REALMADRID");
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
