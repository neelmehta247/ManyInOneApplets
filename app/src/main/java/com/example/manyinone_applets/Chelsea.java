package com.example.manyinone_applets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Chelsea extends Activity {
	Button send, ret, aalp;
	TextView tv;
	EditText et;
	String no;
	InputMethodManager imm;
	int nu, teamid = 3;// teamid liv=1,manu=2,chel=3
	String player[] = { "Back to last screen", "1.Petr Cech - Goalkeeper",
			"2.Branislav Ivanovic - Defender", "3.Ashley Cole - Defender",
			"4.David Luiz - Defender", null, "6.Oriol Romeu - Midfielder",
			"7.Ramires - Midfielder", "8.Frank Lampard - Midfielder",
			"9.Fernando Torres - Striker", "10.Juan Mata - Midfielder",
			"11.Oscar - Midfielder", "12.John Obi Mikel - Midfielder",
			"13.Victor Moses - Midfielder", null,
			"15.Florent Malouda - Midfielder", null,
			"17.Eden Hazard - Midfielder", null,
			"19.Paulo Ferreira - Defender", null,
			"21.Marko Marin - Midfielder", "22.Ross Turnbull - Goalkeeper",
			null, "24.Gary Cahill - Defender", null,
			"26.John Terry - Defender", null,
			"28.Cesar Azpilicueta - Defender", "29.	Demba Ba - Striker",
			"30.Yossi Benayoun - Midfielder", null, null, null,
			"34.Ryan Bertrand - Defender", null, null, null, null, null,
			"40.Henrique Hilario - Goalkeeper" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.footinfo);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		send = (Button) findViewById(R.id.bSend);
		tv = (TextView) findViewById(R.id.tvPlayerName);
		et = (EditText) findViewById(R.id.etFootInfo);
		ret = (Button) findViewById(R.id.bRetFBI);
		aalp = (Button) findViewById(R.id.bSeePlay);
		send.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					no = et.getText().toString();
					nu = Integer.parseInt(no);
					if (nu > 40) {
						tv.setText("Nobody in the team has that number");
					} else if (player[nu] == null) {
						tv.setText("Nobody in the team has that number");
					} else {
						tv.setText(player[nu]);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// hide keyboard
				imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				// hide Keyboard end
				imm.hideSoftInputFromWindow(et.getWindowToken(), 0);
			}
		});
		ret.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent a = new Intent("com.example.manyinone_applets.EPL");
				startActivity(a);
			}
		});
		aalp.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int c = 0;
				for (int i = 0; i < player.length; i++) {
					if (player[i] != null) {
						c++;
					}
				}
				String[] blah = new String[c];
				int b = 0;
				for (int i = 0; i < player.length; i++) {
					if (player[i] != null) {
						blah[b] = player[i];
						b++;
					}
				}
				Bundle ab = new Bundle();
				ab.putStringArray("key", blah);
				ab.putInt("keyint", teamid);
				Intent a = new Intent(
						"com.example.manyinone_applets.ALLPLAYERS");
				a.putExtras(ab);
				startActivity(a);
			}
		});

	}
}
