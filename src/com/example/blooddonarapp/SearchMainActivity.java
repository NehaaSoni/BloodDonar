package com.example.blooddonarapp;

import java.sql.*;
import java.util.ArrayList;


import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;
public class SearchMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_main);
	}
	public void searchclick(View v)
	{
		Spinner s1 = (Spinner)findViewById(R.id.spinner1);
		Spinner s2 = (Spinner)findViewById(R.id.spinner2);
		
		
		String bg = s2.getSelectedItem().toString();
		String city = s1.getSelectedItem().toString();
		GridView gv = (GridView) findViewById(R.id.gridView1);
		
		
		try
		{
		
			ArrayList<String> x = new ArrayList();
			x.add("Name");
			x.add("Mobile");
			
			ConnectionClass c = new ConnectionClass();
			Connection conn = c.CONN();
			String sql = "select * from regblood where ucity='"+
			city+"' and bgroup='"+bg+"'";
			
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while (rs.next())
			{
				x.add(rs.getString(1));
				x.add(rs.getString(2));
				
			}
			
			
			gv.setAdapter(new ArrayAdapter<String>(
					getApplicationContext(),
					android.R.layout.simple_list_item_1,x));
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
		getMenuInflater().inflate(R.menu.search_main, menu);
		return true;
	}

}
