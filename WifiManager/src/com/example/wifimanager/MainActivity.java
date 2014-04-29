package com.example.wifimanager;

import android.os.Bundle;
import android.os.Debug;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

Boolean isInternetPresent = false;
	
	// Connection detector class
	connectiondetector cd;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnStatus = (Button)findViewById(R.id.btn_check);
        Button btnstrength =  (Button) findViewById(R.id.btn_strength); 
        Button btnlink = (Button) findViewById(R.id.btn_link);
		// creating connection detector class instance
		cd = new connectiondetector(getApplicationContext());

		/**
		 * Check Internet status button click event
		 * */
		btnstrength.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				 TODO Auto-generated method stub
				try
				{
					int strength = cd.fetchWifiInfo();
					
					//TextView txt = (TextView) findViewById(R.id.output);
					//String testString = Integer.valueOf(strength).toString();
					//txt.append("Hi");
					//showAlertDialog(MainActivity.this,Integer.toString(strength), null, false);
				}
				catch(Exception ex)
				{
					showAlertDialog(MainActivity.this, ex.getMessage().toString(), null, false);
				}
			}
		});
		btnStatus.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				
				// get Internet status
				isInternetPresent = cd.isConnectingToInternet();

				// check for Internet status
				if (isInternetPresent) {
					// Internet Connection is Present
					// make HTTP requests
					showAlertDialog(MainActivity.this, "Internet Connection",
							"You have internet connection", true);
				} else {
					// Internet connection is not present
					// Ask user to connect to Internet
					showAlertDialog(MainActivity.this, "No Internet Connection",
							"You don't have internet connection.", false);
				}
			}

		});

	}

	/**
	 * Function to display simple Alert Dialog
	 * @param context - application context
	 * @param title - alert dialog title
	 * @param message - alert message
	 * @param status - success/failure (used to set icon)
	 * */
	public void showAlertDialog(Context context, String title, String message, Boolean status) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();

		// Setting Dialog Title
		alertDialog.setTitle(title);

		// Setting Dialog Message
		alertDialog.setMessage(message);
		
		// Setting alert dialog icon
		alertDialog.setIcon((status) ? R.drawable.ic_launcher : R.drawable.ic_launcher);

		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			}
		});

		// Showing Alert Message
		alertDialog.show();
	}
 
	

	
}
