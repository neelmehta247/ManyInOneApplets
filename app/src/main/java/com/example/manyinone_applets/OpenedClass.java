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
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class OpenedClass extends Activity implements OnClickListener,
		OnCheckedChangeListener {
	Button bRet;
	TextView question, test;
	RadioGroup rg;
	String getBread, setData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.send);
		initialize();
		Bundle abc = getIntent().getExtras();
		getBread = abc.getString("key");
		question.setText(getBread);
	}

	private void initialize() {
		// TODO Auto-generated method stub
		bRet = (Button) findViewById(R.id.bReturn);
		test = (TextView) findViewById(R.id.tvSend);
		question = (TextView) findViewById(R.id.tvS);
		rg = (RadioGroup) findViewById(R.id.rgSend);
		bRet.setOnClickListener(this);
		rg.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bReturn:
			Intent a = new Intent(OpenedClass.this, QuestionAnswer.class);
			startActivity(a);
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int arg1) {
		// TODO Auto-generated method stub
		switch (arg1) {
		case R.id.rbCrazy:
			setData = "Probably Right!!!";
			break;
		case R.id.rbAwesome:
			setData = "I doubt It!!!";
			break;
		case R.id.rbFantastic:
			setData = "Yeah Whatever!!";
			break;
		}
		test.setText(setData);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
