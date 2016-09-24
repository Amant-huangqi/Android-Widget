package com.example.test_widget;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

public class TimerService extends Service {
	
	private Timer timer;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				undateViews();
			}
		}, 0, 1000);
	}
	
	private void undateViews() {
		String time = sdf.format(new Date());
		RemoteViews rv = new RemoteViews(getPackageName(),R.layout.widget);
		rv.setTextViewText(R.id.tv, time);
		AppWidgetManager manger = AppWidgetManager.getInstance(getApplicationContext());
		ComponentName cn = new ComponentName(getApplicationContext(),WidgetProvider.class);
		manger.updateAppWidget(cn, rv);

	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		timer = null;
	}

}
