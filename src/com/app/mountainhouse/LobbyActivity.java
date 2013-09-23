package com.app.mountainhouse;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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
		
		Button settingBtn = (Button)findViewById(R.id.settingButtom);
		settingBtn.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				openOptionsDialog();
			}
			
		});
		
		
		LinearLayout main_layout = (LinearLayout)findViewById(R.id.lobby_main_layout);
		LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lobby_news_layout, null, true);
		main_layout.addView(view);
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
	
	public void newsBtnClick(View cvView)
	{
		LinearLayout main_layout = (LinearLayout)findViewById(R.id.lobby_main_layout);
		LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lobby_news_layout, null, true);
		main_layout.removeAllViewsInLayout();
		main_layout.addView(view);		
	}
	
	public void infoBtnClick(View cvView)
	{
		LinearLayout main_layout = (LinearLayout)findViewById(R.id.lobby_main_layout);
		LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lobby_info_layout, null, true);
		main_layout.removeAllViewsInLayout();
		main_layout.addView(view);		
	}
	
	public void friendListBtnClick(View cvView)
	{
		LinearLayout main_layout = (LinearLayout)findViewById(R.id.lobby_main_layout);
		LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lobby_friendlist_layout, null, true);
		main_layout.removeAllViewsInLayout();
		main_layout.addView(view);		
	}
	
	public void itemBtnClick(View cvView)
	{
		LinearLayout main_layout = (LinearLayout)findViewById(R.id.lobby_main_layout);
		LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lobby_item_layout, null, true);
		main_layout.removeAllViewsInLayout();
		main_layout.addView(view);
	}
	
	public void stageBtnClick(View cvView)
	{
		LinearLayout main_layout = (LinearLayout)findViewById(R.id.lobby_main_layout);
		LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lobby_stage_layout, null, true);
		main_layout.removeAllViewsInLayout();
		main_layout.addView(view);		
	}
	
	public void shoppingBtnClick(View cvView)
	{
		LinearLayout main_layout = (LinearLayout)findViewById(R.id.lobby_main_layout);
		LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(R.layout.lobby_shopping_layout, null, true);
		main_layout.removeAllViewsInLayout();
		main_layout.addView(view);		
	}
	
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
			openAboutDialog();
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
	
	private void openAboutDialog() {
		AlertDialog.Builder dialog = new AlertDialog.Builder(LobbyActivity.this);
		
		dialog.setTitle("About author");
		dialog.setMessage("edit by GeneChu" + "\n"+ "ver1_20130923" );
		
		dialog.setPositiveButton("leave",
				 new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int i){}	
			});
		
		dialog.show();
	} // openOptionsDialog()
	
}

