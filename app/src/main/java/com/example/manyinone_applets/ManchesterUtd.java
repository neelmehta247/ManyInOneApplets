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

public class ManchesterUtd extends Activity {
	Button send, ret, aalp;
	TextView tv;
	EditText et;
	InputMethodManager imm;
	String no;
	int nu, teamid = 2;// teamid liv=1,manu=2,chel=3
	String player[] = { "Back to last screen", "1.David De Gea - Goalkeeper",
			"2.Rafael Da Silva - Defender", "3.Patrice Evra - Defender",
			"4.Phil Jones - Defender", "5.Rio Ferdinand - Defender",
			"6.Jonny Evans - Defender", "7.Antonio Valencia - Midfielder",
			"8.Oliveira Anderson - Midfielder", null,
			"10.Wayne Rooney - Striker", "11.Ryan Giggs - Midfielder",
			"12.Chris Smalling - Defender",
			"13.Anders Lindegaard - Goalkeeper",
			"14.Javier Hernandez - Striker", "15.Nemanja Vidic - Defender",
			"16.Michael Carrick - Midfielder", "17.Luis Nani - Midfielder",
			"18.Ashley Young - Midfielder", "19.Danny Welbeck - Striker",
			"20.Robin van Persie - Striker", "21.Angelo Henriquez - Striker",
			"22.Paul Scholes - Midfielder", "23.Tom Cleverley - Midfielder",
			"24.Darren Fletcher - Midfielder", "25.Nick Powell - Striker",
			"26.Shinji Kagawa - Midfielder", "27.Federico Macheda - Striker",
			"28.Alexander Buttner - Defender", null, null,
			"31.Scott Wootton - Defender", null,
			"33.Tiago Manuel Dias Correia - Striker", null,
			"35.Jesse Lingard  - Midfielder", "36.Marnick Vermijl - Defender",
			"37.Robert Brady - Midfielder", "38.Michael Keane - Defender",
			"39.Tom Thorpe - Defender", null, "41.Joshua King - Striker", null,
			null, null, null, "46.Ryan Tunnicliffe - Midfielder", null,
			"48.William Keane - Striker", "49.Frederic Veseli - Defender",
			"50.Sam Johnstone - Goalkeeper" };

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
