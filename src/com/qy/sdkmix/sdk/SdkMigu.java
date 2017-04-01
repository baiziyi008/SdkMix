package com.qy.sdkmix.sdk;

import cn.cmgame.billing.api.BillingResult;
import cn.cmgame.billing.api.GameInterface;

import com.qy.sdkmix.ICallback.IPayCB;

import android.content.Context;
import android.os.Handler;

public class SdkMigu implements Runnable {

	private Context context;
	// private Handler gfhandler = null;
	private String payCode = null;
	private String cpparam = null;

	private IPayCB callback;

	public SdkMigu(Context context, String payCode, String cpparam,
			IPayCB callback) {
		super();
		this.context = context;
		this.payCode = payCode;
		this.cpparam = cpparam;
		this.callback = callback;
	}

	public SdkMigu(Context context, String payCode, IPayCB callback) {
		this.context = context;
		this.payCode = payCode;
		this.callback = callback;
	}

	@Override
	public void run() {
		GameInterface.doBilling(context, true, true, payCode, cpparam,
				new GameInterface.IPayCallback() {

					@Override
					public void onResult(int resultCode, String billingIndex,
							Object arg) {
						switch (resultCode) {
						case BillingResult.SUCCESS:
							// 成功
							callback.OnSuccess(billingIndex);
							break;
						case BillingResult.FAILED:
							// 失败
							callback.OnFail(billingIndex);
							break;
						case BillingResult.CANCELLED:
							// 取消
							callback.OnCancel(billingIndex);
							break;
						}

					}
				});
	}

}
