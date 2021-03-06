package com.matsol.android.app.dialpadtest.utils;

import com.matsol.android.app.dialpadtest.ui.DialpadActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.sip.SipAudioCall;
import android.net.sip.SipProfile;

public class IncomingCallReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		SipAudioCall incomingCall = null;
		try {

			SipAudioCall.Listener listener = new SipAudioCall.Listener() {
				@Override
				public void onRinging(SipAudioCall call, SipProfile caller) {
					try {
						call.answerCall(30);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};

			DialpadActivity wtActivity = (DialpadActivity) context;

			incomingCall = wtActivity.manager.takeAudioCall(intent, listener);
			incomingCall.answerCall(30);
			incomingCall.startAudio();
			incomingCall.setSpeakerMode(true);
			if (incomingCall.isMuted()) {
				incomingCall.toggleMute();
			}

			wtActivity.call = incomingCall;

			wtActivity.updateStatus(incomingCall);

		} catch (Exception e) {
			if (incomingCall != null) {
				incomingCall.close();
			}
		}
	}

}
