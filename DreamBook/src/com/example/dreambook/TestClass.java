package com.example.dreambook;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class TestClass extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test_class);
		String content = getIntent().getExtras().getString("string");
		TextView testTV = (TextView) findViewById(R.id.test_name);
		testTV.setText(content);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_test_class, menu);
		return true;
	}

}
