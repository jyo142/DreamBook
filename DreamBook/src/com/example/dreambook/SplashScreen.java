package com.example.dreambook;

import com.parse.Parse;
import com.parse.ParseUser;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.widget.TextView;

public class SplashScreen extends Activity {

	private static int SPLASH_TIME_OUT = 3000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Parse.initialize(this, "RDPrQnZpcvH8r3DOolpDjHKPI1cKdI2wXIYefXo0", "Izgv2fEsKKWIFxPT2QV6zn8F84Er8XZtnv3BhtJY"); 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		
		setFonts();
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// method will be executed once the timer is over
				// Start your app main activity
				ParseUser currentUser = ParseUser.getCurrentUser();
				Intent mainIntent;
				if (currentUser != null) {
					// redirect the user to the main lobby if they are already recognized
					mainIntent = new Intent(SplashScreen.this, MainLobby.class);
				} else {
					mainIntent = new Intent(SplashScreen.this, TitlePage.class);
				}
				startActivity(mainIntent);
				// close the activity
				finish();
			}
		}, SPLASH_TIME_OUT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash_screen, menu);
		return true;
	}
	
	private void setFonts() {
		Typeface tf = Typeface.createFromAsset(getAssets(), "BaroqueScript.ttf");
		TextView titleTV = (TextView) findViewById(R.id.splash_title);
		TextView messageTV = (TextView) findViewById(R.id.splash_message);
		titleTV.setTypeface(tf);
		messageTV.setTypeface(tf);
	}

}
