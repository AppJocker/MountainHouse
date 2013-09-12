
package com.app.mountainhouse ;


import android.os.Bundle      ;
import android.app.Activity   ;
import android.util.Log;
import android.view.View      ;
import android.widget.Button  ;
import android.content.Intent ;


public class LoginActivity extends Activity
{
	ConnectDatabase cd;
	@Override protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState ) ;
		setContentView( R.layout.activity_login ) ;

		Button button = (Button) findViewById( R.id.buttonFacebookLogin ) ;
		
		button.setOnClickListener( new Button.OnClickListener()
		{
			@Override public void onClick( View v )
			{
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
				
				Intent intent = new Intent() ;
				intent.setClass( LoginActivity.this , LobbyActivity.class ) ;
				startActivity( intent ) ;
				//LoginActivity.this.finish() ;	
			}
		}) ;		
	}
}
