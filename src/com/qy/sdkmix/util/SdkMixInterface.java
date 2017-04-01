package com.qy.sdkmix.util;

import cn.cmgame.billing.api.GameInterface;

import com.qy.sdkmix.ICallback.IPayCB;
import com.xhsdk.tb.com.XHInterface;
import com.xhsdk.tb.com.XHTools;
import com.xhsdk.tb.http.XHHttp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

public class SdkMixInterface {

	private static String mSdkType = null;
	
	/**
	 * 初始化SDK
	 * @param main
	 */
	public static void initSdkMix(Activity main){
		//migu初始化
		GameInterface.initializeApp(main);
		//中至初始化
	}
	
	/**
	 * 不含透传参数的支付
	 * @param context	上下文
	 * @param payCode	SDK提供方提供映射编码，游戏方不需要考虑各个运营商的计费点道具编码
	 * @param callback	支付回调
	 */
	public static void pay(Context context, String payCode, IPayCB callback){
		TaskSdkType	taskSdkType = new TaskSdkType(context, payCode, callback);
		taskSdkType.execute();
	}
	
	/**
	 * 含透传参数的支付
	 * @param context	上下文
	 * @param payCode	SDK提供方提供映射编码，游戏方不需要考虑各个运营商的计费点道具编码
	 * @param cpParam	（可为null）：传入规则为：
			1.格式为16位，仅支持大小写字母和数字
			2.我们的sdk会替换前5位作为我们sdk的标识
			3.没有传cpParam的我们会自动生成一个cpParam传入

	 * @param callback	支付回调
	 */
	public static void pay(Context context, String payCode, String cpParam, IPayCB callback){
		
	}
}
