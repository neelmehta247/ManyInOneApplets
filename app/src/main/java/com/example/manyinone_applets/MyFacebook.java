package com.example.manyinone_applets;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

public class MyFacebook extends Activity {
	WebView OnlyOne;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.facebook);
		OnlyOne = (WebView) findViewById(R.id.webView1);
		OnlyOne.loadUrl("http://www.facebook.com/NeeeeeeeeeeeeeeeeeeL");
		OnlyOne.getSettings().setJavaScriptEnabled(true);
		OnlyOne.setWebViewClient(new ourViewClient());
	}
}
