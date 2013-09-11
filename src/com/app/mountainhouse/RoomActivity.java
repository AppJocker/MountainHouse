package com.app.mountainhouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoomActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_room);
	Button button = (Button)findViewById(R.id.button_startstory); 
	button.setOnClickListener(new Button.OnClickListener(){
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(RoomActivity.this, StoryActivity.class);
			startActivity(intent); 
			RoomActivity.this.finish(); 	
		} 
	});
	}

}
