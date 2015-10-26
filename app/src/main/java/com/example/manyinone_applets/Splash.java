package com.example.manyinone_applets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
    //MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        //song = MediaPlayer.create(Splash.this, R.raw.bng);
        //song.start();
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent a = new Intent("com.example.manyinone_applets.MENU");
                    startActivity(a);
                }
            }
        };
        timer.start();

    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        //song.release();
        finish();
    }

}
