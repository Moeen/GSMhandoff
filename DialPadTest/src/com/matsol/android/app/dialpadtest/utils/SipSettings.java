package com.matsol.android.app.dialpadtest.utils;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockPreferenceActivity;
import com.matsol.android.app.dialpadtest.R;

public class SipSettings extends SherlockPreferenceActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Note that none of the preferences are actually defined here.
		// They're all in the XML file res/xml/preferences.xml.
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}
}
