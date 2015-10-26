package com.example.manyinone_applets;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PrimeFinder extends Activity {
    int prime = 0;
    TextView tvPrime;
    EditText etLimit;
    LinearLayout llP;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.prime);
        llP = (LinearLayout) findViewById(R.id.llP);
        pb = (ProgressBar) findViewById(R.id.pB1);
        tvPrime = (TextView) findViewById(R.id.tvPrime);
        etLimit = (EditText) findViewById(R.id.etPrime);
    }

    public boolean prime(int a) {
        if (a % 2 == 0) {
            return false;
        }
        for (int i = 3; i < Math.ceil(Math.sqrt(a)); i += 2) {
            if (a % i == 0)
                return false;
        }
        return true;
    }

    public void searchClick(View view) {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(etLimit.getWindowToken(), 0);
            String a = etLimit.getText().toString();
            prime = Integer.parseInt(a);
            if (prime < 0 || prime == 0) {
                tvPrime.setText("This is an invalid entry, enter numbers over 0");
            } else {
                new FindPrimes().execute(prime);
            }

        } catch (Exception e) {
            tvPrime.setText("This is an invalid entry, enter numbers over 0");
        }
    }

    public void returnClick(View view) {
        Intent a = new Intent("com.example.manyinone_applets.MENU");
        startActivity(a);
    }

    class FindPrimes extends AsyncTask<Integer, String, String> {

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            llP.setVisibility(View.GONE);
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            llP.setVisibility(View.VISIBLE);
            pb.setMax(prime);
            tvPrime.setText("");
        }

        StringBuilder b = new StringBuilder("2");

        @Override
        protected void onProgressUpdate(String... values) {
            // TODO Auto-generated method stub
            super.onProgressUpdate(values);
            tvPrime.setText(b.toString());
            pb.setProgress(Integer.parseInt(values[0]));
        }

        @Override
        protected String doInBackground(Integer... params) {
            // TODO Auto-generated method stub
            long cTime = System.currentTimeMillis();
            for (int j = 2; j <= prime; j++) {
                if (prime(j)) {
                    b.append(", " + j);
                    long time = System.currentTimeMillis();
                    long diff = time - cTime;
                    if (((diff) % 3000) < 10) {
                        publishProgress(j + "");
                    }
                }
            }
            publishProgress(prime + "");
            return null;
        }
    }
}
