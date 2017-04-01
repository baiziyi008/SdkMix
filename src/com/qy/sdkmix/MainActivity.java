package com.qy.sdkmix;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import cn.cmgame.billing.api.GameInterface;


public class MainActivity extends Activity {

	Button btn = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		findView();
		pay();
	}

	private void pay() {
		// TODO Auto-generated method stub
	}

	private void init() {
		// TODO Auto-generated method stub
	}

	private void findView() {
		// TODO Auto-generated method stub
		btn = (Button)findViewById(R.id.btnBilling);
	}

}
