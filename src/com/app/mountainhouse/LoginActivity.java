
package com.app.mountainhouse ;


import android.os.Bundle      ;
import android.os.Handler;
import android.app.Activity   ;
import android.view.View      ;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button  ;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent ;
import android.graphics.drawable.AnimationDrawable;

public class LoginActivity extends Activity
{
	ConnectDatabase cd;
	AnimationDrawable AniFrame;
	ImageView MyImageView;
	ImageView IconImage;
	ImageView MyIconImageView;
	
	@Override protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState ) ;
		setContentView( R.layout.activity_login ) ;
	    
		//starting login animation
		startanimation();
		
	}
	
	private void startanimation()
	{		
		
		IconImage = (ImageView)findViewById(R.id.IconImageView);
		MyIconImageView = (ImageView)findViewById(R.id.IconTextImageView);
		MyIconImageView.setVisibility(0);
		AlphaAnimation ta = new AlphaAnimation(0.0f, 1.0f);
		ta.setDuration(2000);
		ta.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationEnd(Animation animation) {
				AlphaAnimation ta0 = new AlphaAnimation(0.0f, 1.0f);
				ta0.setDuration(1000);
			    MyIconImageView.setBackgroundResource(R.drawable.icon_animation);
			    MyIconImageView.startAnimation(ta0);
			    AniFrame = (AnimationDrawable) MyIconImageView.getBackground();
			    AniFrame.start();
			   
			    final Handler handler = new Handler();
		        handler.postDelayed(new Runnable() {
		            @Override
		            public void run() {
		            	AlphaAnimation ta = new AlphaAnimation(1.0f, 0.0f);
		 			    ta.setDuration(2000);
		 			    ta.setFillAfter(true);
		 			    ta.setFillEnabled(true);
		 			    MyIconImageView.startAnimation(ta);
		 			    AlphaAnimation ta2 = new AlphaAnimation(1.0f, 0.0f);
		 			    ta2.setDuration(2000);
		 			    ta2.setFillAfter(true);
		 			    ta2.setFillEnabled(true);
		 			    ta2.setAnimationListener(new AnimationListener() {
							@Override
							public void onAnimationEnd(Animation animation) {
								// TODO Login Start
								MyImageView = (ImageView)findViewById(R.id.HouseImageView);
							    MyImageView.setBackgroundResource(R.drawable.login_animation);
							    AniFrame = (AnimationDrawable) MyImageView.getBackground();
							    AniFrame.start();
							    AlphaAnimation ta3 = new AlphaAnimation(0.0f, 1.0f);
							    ta3.setFillAfter(true);
				 			    ta3.setFillEnabled(true);
				 			    ta3.setDuration(2000);
				 			    MyImageView.startAnimation(ta3);
				 			    MyImageView.setOnClickListener( new Button.OnClickListener()
				 				{
				 					@Override public void onClick( View v )
				 					{
				 						AlphaAnimation ta = new AlphaAnimation(1f, 0f);
				 						ta.setFillAfter(true);
						 			    ta.setFillEnabled(true);
				 						ta.setDuration(2000);
				 						ta.setAnimationListener(new AnimationListener() {

											@Override
											public void onAnimationEnd(
													Animation animation) {
												// TODO Auto-generated method stub
												MyImageView.setVisibility(0);
												Intent intent = new Intent();
						 						intent.setClass( LoginActivity.this , LobbyActivity.class ) ;
						 						startActivity( intent ) ;
												
											}

											@Override
											public void onAnimationRepeat(
													Animation animation) {}

											@Override
											public void onAnimationStart(
													Animation animation) {}
				 							
				 						});
				 						MyImageView.startAnimation(ta);
				 						TextView touchscreen = (TextView)findViewById(R.id.texttouchscreen);
				 						AlphaAnimation ta2 = new AlphaAnimation(0.5f, 0f);
				 						ta2.setDuration(2000);
				 						ta2.setFillAfter(true);
						 			    ta2.setFillEnabled(true);
						 			    touchscreen.startAnimation(ta2);
						 			    
				 						/*example database connect*/ // To small tiger FB login use class example	
				 						/*cd = new ConnectDatabase();
				 						if(cd.createconnect())
				 						{
				 							int type = 0; //FB = 0, G+ = 1;
				 							String ID = "80"; // get ID from FB
				 							String Name = "fu"; // get Name from FB
				 							String PlayerName = "";
				 							
				 							int logintype = cd.login(type, ID, Name);
				 							//0 = fail
				 							//1 = register success, and set player name
				 							//2 = already register, and you can get player name
				 							
				 							if(logintype == 1) 
				 							{
				 								PlayerName = "ABC";
				 								cd.setplayername(type, ID, PlayerName);
				 							}else if(logintype == 2)
				 							{
				 								PlayerName = cd.getplayername(type, ID);
				 								if(PlayerName == null)
				 								{
				 									PlayerName = "ABC";
				 									cd.setplayername(type, ID, PlayerName);
				 								}
				 							}	
				 						}*/ 
				 						 
				 						//LoginActivity.this.finish() ;	
				 					}
				 				}) ;	
				 			    
				 			    AlphaAnimation ta4 = new AlphaAnimation(0.2f, 1.0f);
				 			    ta4.setDuration(300);
							    ta4.setRepeatCount(Animation.INFINITE);
							    ta4.setRepeatMode(Animation.REVERSE);
				 			    TextView touchscreen = (TextView)findViewById(R.id.texttouchscreen);
				 			    touchscreen.setVisibility(1);
				 			    touchscreen.startAnimation(ta4);
				 					
							}

							@Override 
							public void onAnimationRepeat(Animation animation) {}

							@Override
							public void onAnimationStart(Animation animation) {}
		 			    	
		 			    });
		 			    IconImage.startAnimation(ta2);
		            }
		        }, 3500);
		    }

			@Override
			public void onAnimationRepeat(Animation animation) {}

			@Override
			public void onAnimationStart(Animation animation) {}
		});
		IconImage.startAnimation(ta);
	}
}
