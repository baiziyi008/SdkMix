package com.qy.sdkmix.util;

import android.app.Application;

public class AppCenter extends Application{
	@Override
	public void onCreate() {
		try {
			System.loadLibrary("megjb ");
		} catch (Exception e) {
			
		}
	}
}
