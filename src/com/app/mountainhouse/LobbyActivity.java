package com.app.mountainhouse;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuItem;

public class LobbyActivity extends Activity {
	
	private String userId ="GeneBear"; 
	private int levelNum = 45;
	private int expPercent = 63;
	private int moneyNum = 99999;
	
	protected static final int MENU_ABOUT = Menu.FIRST;
	protected static final int MENU_Quit = Menu.FIRST+1;	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lobby);
		setUserInfo();
	} // onCreate()
	
	public void setUserInfo() {
		TextView userName = (TextView)findViewById(R.id.idLabel);
		userName.setText("Name: " +userId);
		
		TextView level = (TextView)findViewById(R.id.levelText);
		level.setText("level"+Integer.toString(levelNum));
		
		TextView money = (TextView)findViewById(R.id.moneyLabel);
		money.setText("Money:" + Integer.toString(moneyNum));
		
		MyProgress expBar = (MyProgress)findViewById(R.id.levelExpBar);
		expBar.setProgress(expPercent);	
	} //setUserInfo()
	
	public void settingClick(View cvView)
	{
		openOptionsDialog();
	} //settingClick()
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		//return true;
		super.onCreateOptionsMenu(menu);
		menu.add(0, MENU_ABOUT, 0, "about... ");
		menu.add(1, MENU_Quit, 1, "exit");
		return true ;
	} // onCreateOptionsMenu()
	
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch(item.getItemId()) {
		case MENU_ABOUT:
			openOptionsDialog();
			break;
		case MENU_Quit:
			finish();
			break;
		}
		
		return true;
	} // onOptionsItemSelected()

	private void openOptionsDialog() {
		AlertDialog.Builder dialog = new AlertDialog.Builder(LobbyActivity.this);
		
		dialog.setTitle("只是個無聊的測試");
		dialog.setMessage("別說了，真的超無聊");
		
		dialog.setPositiveButton("time to work",
				 new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int i){}	
					}
					)
			.setNegativeButton("Yahoo~!!", 
				 new DialogInterface.OnClickListener() {
				
					@Override
					public void onClick(DialogInterface dialog, int i) {
						// TODO Auto-generated method stub
						Uri uri = Uri.parse("http://tw.yahoo.com/");
						Intent intent = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(intent);
				}
			});
		
		dialog.show();
	} // openOptionsDialog()
	
}

