package com.example.x27_registerbroadbyservice;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class RegisterService extends Service {

	private ScreenReceiver receiver;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		//ע��㲥������
		
		//1.�����㲥�����߶���
		receiver = new ScreenReceiver();
		//2.����intent-filter ����
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_SCREEN_ON);
		filter.addAction(Intent.ACTION_SCREEN_OFF);
		//3.ע��㲥������
		registerReceiver(receiver, filter);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//���ע��㲥������
		unregisterReceiver(receiver);
	}
}