package com.example.manyinone_applets;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CALLLAP extends ListActivity {

	String getBread[];

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle abc = getIntent().getExtras();
		getBread = abc.getStringArray("key");

		// fullscreen without top bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// end of fullscrren things needed
		setListAdapter(new ArrayAdapter<String>(CALLLAP.this,
				android.R.layout.simple_list_item_1, getBread));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		if (position == 0) {
			Intent a = new Intent("com.example.manyinone_applets.STOPWATCH");
			startActivity(a);
		}
	}
}
