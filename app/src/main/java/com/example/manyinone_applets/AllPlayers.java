package com.example.manyinone_applets;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AllPlayers extends ListActivity {

	String getBread[];
	int teamid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle abc = getIntent().getExtras();
		getBread = abc.getStringArray("key");
		teamid = abc.getInt("keyint");
		// fullscreen without top bar
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// end of fullscrren things needed
		setListAdapter(new ArrayAdapter<String>(AllPlayers.this,
				android.R.layout.simple_list_item_1, getBread));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		// teamid liv = 1
		// manu = 2
		// chel = 3 barca=4,real=5,athel-6
		if (position == 0) {
			if (teamid == 1) {
				Intent a = new Intent("com.example.manyinone_applets.LIVERPOOL");
				startActivity(a);
			} else if (teamid == 2) {
				Intent a = new Intent(
						"com.example.manyinone_applets.MANCHESTERUTD");
				startActivity(a);
			} else if (teamid == 3) {
				Intent a = new Intent("com.example.manyinone_applets.CHELSEA");
				startActivity(a);
			} else if (teamid == 4) {
				Intent a = new Intent("com.example.manyinone_applets.BARCELONA");
				startActivity(a);
			} else if (teamid == 5) {
				Intent a = new Intent(
						"com.example.manyinone_applets.REALMADRID");
				startActivity(a);
			}
		}
	}
}
