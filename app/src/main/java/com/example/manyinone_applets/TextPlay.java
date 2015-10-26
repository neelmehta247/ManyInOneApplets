package com.example.manyinone_applets;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class TextPlay extends Activity {

	protected static final CharSequence ABC = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.text);
		Button stext = (Button) findViewById(R.id.bText);
		Button Menu = (Button) findViewById(R.id.bMenuTP);
		final ToggleButton tbtext = (ToggleButton) findViewById(R.id.tbText);
		final EditText input = (EditText) findViewById(R.id.etText);
		final TextView disp = (TextView) findViewById(R.id.tvText2);
		Menu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a = new Intent("com.example.manyinone_applets.MENU");
				startActivity(a);
			}
		});
		tbtext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (tbtext.isChecked()) {
					input.setInputType(InputType.TYPE_CLASS_TEXT
							| InputType.TYPE_TEXT_VARIATION_PASSWORD);
				} else {
					input.setInputType(InputType.TYPE_CLASS_TEXT);
				}
			}
		});
		stext.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String f = input.getText().toString();
				if (f.contains("ABC")) {
					Random crazy = new Random();
					disp.setText("ABC!!!!");
					disp.setTextSize(crazy.nextInt(75));
					disp.setTextColor(Color.rgb(crazy.nextInt(255),
							crazy.nextInt(255), crazy.nextInt(255)));
				} else if (f.contains("abc")) {
					Random crazy = new Random();
					disp.setText("abc!!!!");
					disp.setTextSize(crazy.nextInt(75));
					disp.setTextColor(Color.rgb(crazy.nextInt(255),
							crazy.nextInt(255), crazy.nextInt(255)));
				} else {
					disp.setText(f + "");
				}
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
