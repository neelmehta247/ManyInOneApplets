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

public class Barcelona extends Activity {
	Button send, ret, aalp;
	TextView tv;
	EditText et;
	InputMethodManager imm;
	String no;
	int nu, teamid = 4;// teamid liv=1,manu=2,chel=3 barca=4 real=5 athel=6
	String player[] = { "Back to last screen", "1.Victor Valdés - Goalkeeper",
			"2.Dani Alves - Defender", "3.Gerard Piqué - Defender",
			"4.Cesc Fábregas - Midfielder", "5.Carles Puyol - Defender",
			"6.Xavi - Midfielder", "7.David Villa - Striker",
			"8.Andrés Iniesta - Midfielder", "9.Alexis Sánchez - Midfielder",
			"10.Lionel Messi - Striker", "11.Thiago Alcántara - Midfielder",
			"12.Jonathan dos Santos - Midfielder",
			"13.José Manuel Pinto - Goalkeeper",
			"14.Javier Mascherano - Defender", "15.Marc Bartra - Defender",
			"16.Sergio Busquets - Midfielder", "17.Pedro - Midfielder",
			"18.Jordi Alba - Defender", "19.Martín Montoya - Defender", null,
			"21.Adriano - Defender", "22.Éric Abidal - Defender",
			"23.Isaac Cuenca - Midfielder", null, "25.Alex Song - Midfielder",
			"26.Marc Muniesa - Defender", null,
			"28.Sergi Roberto - Midfielder", "37.Cristian Tello - Midfielder" };

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
					if (nu == 37) {
						tv.setText(player[29]);
					} else if (nu > 37) {
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
