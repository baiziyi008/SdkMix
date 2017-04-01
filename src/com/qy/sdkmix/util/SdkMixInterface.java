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
	 * ��ʼ��SDK
	 * @param main
	 */
	public static void initSdkMix(Activity main){
		//migu��ʼ��
		GameInterface.initializeApp(main);
		//������ʼ��
	}
	
	/**
	 * ����͸��������֧��
	 * @param context	������
	 * @param payCode	SDK�ṩ���ṩӳ����룬��Ϸ������Ҫ���Ǹ�����Ӫ�̵ļƷѵ���߱���
	 * @param callback	֧���ص�
	 */
	public static void pay(Context context, String payCode, IPayCB callback){
		TaskSdkType	taskSdkType = new TaskSdkType(context, payCode, callback);
		taskSdkType.execute();
	}
	
	/**
	 * ��͸��������֧��
	 * @param context	������
	 * @param payCode	SDK�ṩ���ṩӳ����룬��Ϸ������Ҫ���Ǹ�����Ӫ�̵ļƷѵ���߱���
	 * @param cpParam	����Ϊnull�����������Ϊ��
			1.��ʽΪ16λ����֧�ִ�Сд��ĸ������
			2.���ǵ�sdk���滻ǰ5λ��Ϊ����sdk�ı�ʶ
			3.û�д�cpParam�����ǻ��Զ�����һ��cpParam����

	 * @param callback	֧���ص�
	 */
	public static void pay(Context context, String payCode, String cpParam, IPayCB callback){
		
	}
}
