package com.example.manyinone_applets;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String classes[] = { "Counter", "TextPlay", "SetWallpaper",
			"QuestionAnswer", "FootballInfo", "Stopwatch", "Browser", "MyFacebook", "PrimeFinder" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// fullscreen without top bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// end of fullscrren things needed
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, classes));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String ch = classes[position];
		try {
			Class ourClass = Class.forName("com.example.manyinone_applets."
					+ ch);
			Intent a = new Intent(Menu.this, ourClass);
			startActivity(a);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater BlowUp = getMenuInflater();
		BlowUp.inflate(R.menu.activity_counter, menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("com.example.manyinone_applets.ABOUT");
			startActivity(i);
			break;
		case R.id.exit:
			finish();
			break;
		case R.id.version:
			Intent c = new Intent("com.example.manyinone_applets.VERSION");
			startActivity(c);
			break;
		}
		return false;
	}

}
