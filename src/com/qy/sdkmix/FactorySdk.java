package com.qy.sdkmix;

public class FactorySdk {

	public static <T extends IMixSdk> T createSdk(Class<T> c){
		IMixSdk	iMixSdk = null;
		try {
			iMixSdk	= (IMixSdk)Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sdk creating error~!");
		}
		return (T)iMixSdk;
	}
	
}
