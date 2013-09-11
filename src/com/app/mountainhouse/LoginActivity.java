
package com.app.mountainhouse ;


import android.os.Bundle      ;
import android.app.Activity   ;
import android.view.View      ;
import android.widget.Button  ;
import android.content.Intent ;


public class LoginActivity extends Activity
{
	@Override protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate( savedInstanceState ) ;
		setContentView( R.layout.activity_login ) ;

		Button button = (Button) findViewById( R.id.buttonFacebookLogin ) ;
		
		button.setOnClickListener( new Button.OnClickListener()
		{
			@Override public void onClick( View v )
			{
				Intent intent = new Intent() ;
				intent.setClass( LoginActivity.this , LobbyActivity.class ) ;
				startActivity( intent ) ;
				//LoginActivity.this.finish() ;
			}
		}) ;

	}
}
