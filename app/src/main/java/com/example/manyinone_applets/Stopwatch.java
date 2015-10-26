package com.example.manyinone_applets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Stopwatch extends Activity {
	/** Called when the activity is first created. */

	private Handler mHandler = new Handler();
	private long startTime;
	private static long elapsedTime, lapTime = 0, lapStartTime = 0;
	private final int REFRESH_RATE = 100;
	private String hours, minutes, seconds, milliseconds, milseconds, sec, min,
			hr;
	private long secs, mins, hrs;
	private boolean stopped = false;
	private static int countLap = 1, check = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.timer1);
	}

	public void startClick(View view) {
		showStopButton();
		if (stopped) {
			startTime = System.currentTimeMillis() - elapsedTime;
		} else {
			startTime = System.currentTimeMillis();
		}
		mHandler.removeCallbacks(startTimer);
		mHandler.postDelayed(startTimer, 0);
	}

	public void stopClick(View view) {
		hideStopButton();
		mHandler.removeCallbacks(startTimer);
		stopped = true;
		check = 1;
		lapClick(view);
	}

	public void lapClick(View view) {
		countLap++;
		lapStartTime = elapsedTime;
		mHandler.removeCallbacks(startTimer);
		secs = (long) (lapTime / 1000);
		mins = (long) ((lapTime / 1000) / 60);
		hrs = (long) (((lapTime / 1000) / 60) / 60);

		/*
		 * Convert the sec to String and format to ensure it has a leading zero
		 * when required
		 */
		secs = secs % 60;
		sec = String.valueOf(secs);
		if (secs == 0) {
			sec = "00";
		}
		if (secs < 10 && secs > 0) {
			sec = "0" + sec;
		}

		/* Convert the min to String and format the String */

		mins = mins % 60;
		min = String.valueOf(mins);
		if (mins == 0) {
			min = "00";
		}
		if (mins < 10 && mins > 0) {
			min = "0" + min;
		}

		/* Convert the hr to String and format the String */

		hr = String.valueOf(hrs);
		if (hrs == 0) {
			hr = "00";
		}
		if (hrs < 10 && hrs > 0) {
			hr = "0" + hr;
		}

		/*
		 * Although we are not using milsec on the timer in this example I
		 * included the code in the event that you wanted to include it on your
		 * own
		 */
		milseconds = String.valueOf((long) lapTime);
		if (milseconds.length() == 2) {
			milseconds = "0" + milseconds;
		}
		if (milseconds.length() <= 1) {
			milseconds = "00";
		}
		milseconds = milseconds.substring(milseconds.length() - 3,
				milseconds.length() - 2);

		/* Setting the timer text to the elapsed time */
		String a = ((TextView) findViewById(R.id.tvLap)).getText().toString();
		((TextView) findViewById(R.id.tvLap)).setText((countLap - 1) + "." + hr
				+ ":" + min + ":" + sec + "." + milseconds + "	(" + hours + ":"
				+ minutes + ":" + seconds + "." + milliseconds + ")" + "	" + a);
		if (check != 1)
			mHandler.postDelayed(startTimer, 0);
		else
			check = 0;

	}

	public void resetClick(View view) {
		stopped = false;
		((TextView) findViewById(R.id.timer)).setText("00:00:00");
		((TextView) findViewById(R.id.timerMs)).setText(".0");
		((TextView) findViewById(R.id.tvLap)).setText("");
		countLap = 1;
		elapsedTime = 0;
		lapTime = 0;
		lapStartTime = 0;
	}

	public void retClick(View view) {
		Intent a = new Intent("com.example.manyinone_applets.MENU");
		startActivity(a);
	}

	private void updateTimer(float time) {
		secs = (long) (time / 1000);
		mins = (long) ((time / 1000) / 60);
		hrs = (long) (((time / 1000) / 60) / 60);

		/*
		 * Convert the seconds to String and format to ensure it has a leading
		 * zero when required
		 */
		secs = secs % 60;
		seconds = String.valueOf(secs);
		if (secs == 0) {
			seconds = "00";
		}
		if (secs < 10 && secs > 0) {
			seconds = "0" + seconds;
		}

		/* Convert the minutes to String and format the String */

		mins = mins % 60;
		minutes = String.valueOf(mins);
		if (mins == 0) {
			minutes = "00";
		}
		if (mins < 10 && mins > 0) {
			minutes = "0" + minutes;
		}

		/* Convert the hours to String and format the String */

		hours = String.valueOf(hrs);
		if (hrs == 0) {
			hours = "00";
		}
		if (hrs < 10 && hrs > 0) {
			hours = "0" + hours;
		}

		/*
		 * Although we are not using milliseconds on the timer in this example I
		 * included the code in the event that you wanted to include it on your
		 * own
		 */
		milliseconds = String.valueOf((long) time);
		if (milliseconds.length() == 2) {
			milliseconds = "0" + milliseconds;
		}
		if (milliseconds.length() <= 1) {
			milliseconds = "00";
		}
		milliseconds = milliseconds.substring(milliseconds.length() - 3,
				milliseconds.length() - 2);

		/* Setting the timer text to the elapsed time */
		((TextView) findViewById(R.id.timer)).setText(hours + ":" + minutes
				+ ":" + seconds);
		((TextView) findViewById(R.id.timerMs)).setText("." + milliseconds);
	}

	private Runnable startTimer = new Runnable() {
		public void run() {
			elapsedTime = System.currentTimeMillis() - startTime;
			lapTime = elapsedTime - lapStartTime;
			updateTimer(elapsedTime);

			mHandler.postDelayed(this, REFRESH_RATE);
		}
	};

	private void showStopButton() {
		((Button) findViewById(R.id.startButton)).setVisibility(View.GONE);
		((Button) findViewById(R.id.resetButton)).setVisibility(View.GONE);
		((Button) findViewById(R.id.stopButton)).setVisibility(View.VISIBLE);
		((Button) findViewById(R.id.lapButton)).setVisibility(View.VISIBLE);
	}

	private void hideStopButton() {
		((Button) findViewById(R.id.startButton)).setVisibility(View.VISIBLE);
		((Button) findViewById(R.id.resetButton)).setVisibility(View.VISIBLE);
		((Button) findViewById(R.id.stopButton)).setVisibility(View.GONE);
		((Button) findViewById(R.id.lapButton)).setVisibility(View.GONE);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}