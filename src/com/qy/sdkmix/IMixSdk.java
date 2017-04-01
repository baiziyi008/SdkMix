package com.qy.sdkmix;

public interface IMixSdk {
	void init();
	void init(ILoginCB cb);
	void pay(String billingIndex, String cpparam, IPayCB callback);
	
	interface	ILoginCB{
		void OnResult(String ret);
	}
	
	interface	IPayCB{
		void onResult(int resultCode, String billingIndex, Object obj);
	}
}
