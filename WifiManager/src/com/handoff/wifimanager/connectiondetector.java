package com.handoff.wifimanager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
public class connectiondetector 
{
	private Context _context;
	public WifiInfo wifinfo;
	public WifiManager wifimanager;
	public connectiondetector(Context context){
		this._context = context;
	
	}
	public boolean isConnectingToInternet(){
		ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
		  if (connectivity != null) 
		  {
			  NetworkInfo[] info = connectivity.getAllNetworkInfo();
			  if (info != null) 
				  for (int i = 0; i < info.length; i++) 
					  if (info[i].getState() == NetworkInfo.State.CONNECTED)
					  {
						  return true;
					  }

		  }
		  return false;
	}
	
	public int  fetchWifiInfo()
	{
	     wifinfo = wifimanager.getConnectionInfo();
		int i = wifinfo.getLinkSpeed();
		return i;
	}
	
}
