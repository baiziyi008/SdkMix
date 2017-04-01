package com.qy.sdkmix.ICallback;

public interface IPayCB{
	/**
	 * 付费成功
	 * @param msg
	 */
	void OnSuccess(String msg);
	
	/**
	 * 付费失败
	 * @param msg
	 */
	void OnFail(String msg);
	
	/**
	 * 付费取消
	 * @param msg
	 */
	void OnCancel(String msg);
}
