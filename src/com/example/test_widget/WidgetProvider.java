package com.example.test_widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class WidgetProvider extends AppWidgetProvider {
	
	//widget被从屏幕移除
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
		context.stopService(new Intent(context,TimerService.class));
	}
	
	//第一个widget添加到屏幕上执行
	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		super.onEnabled(context);
		context.startService(new Intent(context,TimerService.class));
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
	}
	
	//刷新的时候执行
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		//刷新widget
		//remoteViews 和 AppWidgetManager
	}

}
