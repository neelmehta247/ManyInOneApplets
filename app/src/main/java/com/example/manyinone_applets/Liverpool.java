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

public class Liverpool extends Activity {
	Button send, ret, aalp;
	TextView tv;
	EditText et;
	InputMethodManager imm;
	String no;
	int nu, teamid = 1;// teamid liv=1,manu=2,chel=3
	String player[] = { "Back to last screen", "1.Brad Jones - Goalkeeper",
			"2.Glen Johnson - Defender", "3.Jose Enrique - Defender",
			"4.Nuri Sahin - Midfielder", "5.Daniel Agger - Defender", null,
			"7.Luis Suarez - Striker", "8.Steven Gerrard - Midfielder", null,
			null, "11.Oussama Assaidi - Striker", null, null,
			"14.Jordan Henderson - Midfielder",
			"15.Daniel Sturridge - Striker", "16.Sebastian Coates - Defender",
			null, null, "19.Stewart Downing - Midfielder", null,
			"21.Lucas Leiva - Midfielder", "22.Danny Wilson - Defender",
			"23.Jamie Carragher - Defender", "24.Joe Allen - Midfielder",
			"25.Pepe Reina - Goalkeeper", null, null, null,
			"29.Fabio Borini - Striker", "30.Jesus Suso - Striker",
			"31.Raheem Sterling - Midfielder",
			"32.Alexander Doni - Goalkeeper", "33.Jonjo Shelvy - Midfielder",
			"34.Martin Kelly - Defender", "35.Conor Coady - Midfielder", null,
			"37.Martin Skrtel - Defender", "38.John Flanagan - Defender", null,
			null, null, "42.Peter Gulacsi - Goalkeeper", null, null, null,
			null, "47.Andre Wisdom - Defender", null,
			"49.Jack Robinson - Defender", "50.Adam Morgan - Striker" };

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
					if (nu > 50) {
						tv.setText("Nobody in the team has that number");
					} else if (player[nu] == null) {
						tv.setText("Nobody in the team has that number");
					} else {
						tv.setText(player[nu]);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
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
