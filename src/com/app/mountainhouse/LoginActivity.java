package com.app.mountainhouse;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		Button button = (Button)findViewById(R.id.button_login); 
		button.setOnClickListener(new Button.OnClickListener(){
		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(LoginActivity.this, LobbyActivity.class);
			startActivity(intent); 
			LoginActivity.this.finish(); 	
		}
		});
	}

}
