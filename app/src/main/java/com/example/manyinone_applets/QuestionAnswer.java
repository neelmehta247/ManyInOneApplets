package com.example.manyinone_applets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class QuestionAnswer extends Activity implements View.OnClickListener {
	Button start, ret;
	TextView tv;
	EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.get);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub

		start = (Button) findViewById(R.id.bSA);
		ret = (Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.tvGet);
		et = (EditText) findViewById(R.id.etGet);
		start.setOnClickListener(this);
		ret.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bSA:
			String bread = et.getText().toString();
			Bundle b = new Bundle();
			b.putString("key", bread);
			Intent a = new Intent(QuestionAnswer.this, OpenedClass.class);
			a.putExtras(b);
			startActivity(a);
			break;
		case R.id.button1:
			Intent s = new Intent("com.example.manyinone_applets.MENU");
			startActivity(s);

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
