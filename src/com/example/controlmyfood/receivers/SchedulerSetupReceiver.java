package com.example.controlmyfood.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.controlmyfood.controller.AlarmController;

public class SchedulerSetupReceiver extends BroadcastReceiver {

	private static final String TAG = "ControlMyFood";

	@Override
	public void onReceive(final Context context, final Intent intent) {

		Log.d(TAG, "Broadcast from booting received, setting alarm");

		AlarmController alarmController = new AlarmController();
		alarmController.initAlarm(context);
	}

}
