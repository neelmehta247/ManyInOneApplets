package com.example.manyinone_applets;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class Browser extends Activity implements OnClickListener {
	WebView browser;
	Button goback, goforward, refresh, clear, go;
	EditText etURL;
	InputMethodManager imm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.browser);
		browser = (WebView) findViewById(R.id.wvBrow);
		browser.getSettings().setJavaScriptEnabled(true);
		browser.setWebViewClient(new ourViewClient());
		browser.loadUrl("http://www.google.com");
		goback = (Button) findViewById(R.id.bGOBACK);
		goforward = (Button) findViewById(R.id.bGOFORWARD);
		refresh = (Button) findViewById(R.id.bREFRESH);
		clear = (Button) findViewById(R.id.bCLEAR);
		go = (Button) findViewById(R.id.bGO);
		etURL = (EditText) findViewById(R.id.etURl);
		goback.setOnClickListener(this);
		go.setOnClickListener(this);
		goforward.setOnClickListener(this);
		refresh.setOnClickListener(this);
		clear.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.bGO:
			String url = etURL.getText().toString();
			browser.loadUrl(url);
			imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(etURL.getWindowToken(), 0);
			break;
		case R.id.bGOBACK:
			if (browser.canGoBack())
				browser.goBack();
			break;
		case R.id.bGOFORWARD:
			if (browser.canGoForward())
				browser.goForward();
			break;
		case R.id.bREFRESH:
			browser.reload();
			break;
		case R.id.bCLEAR:
			browser.clearHistory();
			break;
		}
	}

}
