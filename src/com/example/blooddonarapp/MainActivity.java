package com.example.blooddonarapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.content.*;
import android.widget.*;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	Button b1 = (Button) findViewById(R.id.button1);
	b1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		
			Intent x = new Intent(getApplicationContext(),
					RegMainActivity.class);
			startActivity(x);
			
			
		}
	});
	Button b2 = (Button) findViewById(R.id.button2);
b2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		
			Intent x = new Intent(getApplicationContext(),
					SearchMainActivity.class);
			startActivity(x);
			
			
		}
	});
	Button b3 = (Button) findViewById(R.id.button3);
	
b3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		
	finish();		
			
		}
	});
	
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
