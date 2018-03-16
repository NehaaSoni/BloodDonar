package com.example.blooddonarapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;

import java.sql.*;

public class RegMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg_main);
	}
	
	public void submitclick(View v)
	{
		EditText t1 = (EditText) findViewById(R.id.editText1);
		EditText t2 = (EditText) findViewById(R.id.editText2);
		Spinner s1 = (Spinner)findViewById(R.id.spinner1);
		Spinner s2 = (Spinner)findViewById(R.id.spinner2);
		
		String name =t1.getText().toString();
		String mobile = t2.getText().toString();
		String bg = s1.getSelectedItem().toString();
		String city = s2.getSelectedItem().toString();
		
		if(name.length()==0 || mobile.length()==0)
		{
			Toast.makeText(getBaseContext(), "Value cannot be empty",
					Toast.LENGTH_SHORT).show();
			return;
		}
		
		try
		{
			ConnectionClass c = new ConnectionClass();
			Connection conn = c.CONN();
			String sql = "Insert into regblood values('"+
		name+"','"+mobile+"','"+bg+"','"+city+"')";
			Statement stat = conn.createStatement();
			stat.execute(sql);
			stat.close();
			conn.close();
			Toast.makeText(getBaseContext(),"record saved",
					Toast.LENGTH_SHORT).show();
		}
		catch(Exception ex)
		{
			Toast.makeText(getBaseContext(), ex.toString(),
					Toast.LENGTH_SHORT).show();
			
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reg_main, menu);
		return true;
	}

}
