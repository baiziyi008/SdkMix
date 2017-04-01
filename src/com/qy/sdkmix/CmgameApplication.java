package com.qy.sdkmix;

import android.app.Application;

public class CmgameApplication extends Application {
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		try {
			System.loadLibrary("megjb ");
		} catch (Exception e) {

		}

	}
}
