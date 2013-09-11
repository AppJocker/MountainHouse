package com.app.mountainhouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LobbyActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_lobby);
	Button button = (Button)findViewById(R.id.button_joinroom); 
	button.setOnClickListener(new Button.OnClickListener(){
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(LobbyActivity.this, RoomActivity.class);
			startActivity(intent); 
			LobbyActivity.this.finish(); 	
		} 
	});
	}

}
