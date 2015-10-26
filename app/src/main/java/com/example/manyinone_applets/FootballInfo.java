package com.example.manyinone_applets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FootballInfo extends Activity implements OnClickListener {
	Button epl, esp, ret;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.footballinitialize);
		epl = (Button) findViewById(R.id.epl);
		esp = (Button) findViewById(R.id.esp);
		ret = (Button) findViewById(R.id.bMENFBINTI);
		epl.setOnClickListener(this);
		ret.setOnClickListener(this);
		esp.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.esp:
			Intent b = new Intent("com.example.manyinone_applets.ESP");
			startActivity(b);
			break;
		case R.id.epl:
			Intent a = new Intent("com.example.manyinone_applets.EPL");
			startActivity(a);
			break;
		case R.id.bMENFBINTI:
			Intent z = new Intent("com.example.manyinone_applets.MENU");
			startActivity(z);
			break;
		}
	}

}
