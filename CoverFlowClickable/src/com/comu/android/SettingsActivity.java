package com.comu.android;


import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;



public class SettingsActivity  extends BetterActivity{
	

	protected void onCreate(Bundle savedInstanceState) {
		// Called when the activity is first created
			super.onCreate(savedInstanceState);
			setContentView(R.layout.settings);
			
			final TextView theme_op = (TextView)findViewById(R.id.theme);
			theme_op.setText("Tema Değiştir");
			theme_op.setTextSize(TypedValue.DENSITY_DEFAULT, 25);
			
			final TextView wallpaper_op = (TextView)findViewById(R.id.wallpaper);
			wallpaper_op.setText("Duvar Kağıdı Değiştir");
			wallpaper_op.setTextSize(TypedValue.DENSITY_DEFAULT, 25);
	
	
	
			theme_op.setOnClickListener(new OnClickListener(){
				public void onClick(View arg){
					
					Intent intent = new Intent(getApplicationContext(),ThemeActivity.class);
					startActivity(intent);
	    				        		
				}
        
			});
			wallpaper_op.setOnClickListener(new OnClickListener(){
				public void onClick(View arg){
        	
        	    				        		
				}
        
			});
	
	}
}