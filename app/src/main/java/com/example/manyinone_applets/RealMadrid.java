package com.example.manyinone_applets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RealMadrid extends Activity {
	Button send, ret, aalp;
	TextView tv;
	EditText et;
	InputMethodManager imm;
	String no;
	int nu, teamid = 5;// teamid liv=1,manu=2,chel=3 barca=4 real=5 athel=6
	String player[] = { "Back to last screen", "1.Iker Casillas - Goalkeeper",
			"2.Raphael Varane - Defender", "3.Pepe - Defender",
			"4.Sergio Ramos - Defender", "5.Fabio Coentrao - Defender",
			"6.Sami Khedira - Midfielder", "7.Cristiano Ronaldo - Midfielder",
			"8.Kaka - Midfielder", "9.Karim Benzema - Striker",
			"10.Mesut Ozil - Midfielder", "11.Ricardo Carvalho - Defender",
			"12.Marcelo - Defender", "13.Antonio Aden - Goalkeeper",
			"14.Xabi Alonso - Midfielder", "15.Michael Essien - Midfielder",
			null, "17.Alvaro Arbeloa - Defender", "18.Raul Albiol - Defender",
			"19.Luka Modric - Midfielder", "20.Gonzalo Higuain - Striker",
			"21.Jose Maria Callejan - Midfielder",
			"22.Angel Di Maria - Midfielder", null, null, null, null,
			"27.Nacho Fernandez - Defender", null,
			"29.Alvaro Morata - Striker", "30.Alex - Midfielder", null, null,
			null, "34.Jose Rodriguez - Midfielder",
			"35.Jesus Fernandez - Goalkeeper", null,
			"37.Denis Cheryshev - Midfielder" };

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
				Intent a = new Intent("com.example.manyinone_applets.ESP");
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
