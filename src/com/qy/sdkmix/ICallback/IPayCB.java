package com.qy.sdkmix.ICallback;

public interface IPayCB{
	/**
	 * ���ѳɹ�
	 * @param msg
	 */
	void OnSuccess(String msg);
	
	/**
	 * ����ʧ��
	 * @param msg
	 */
	void OnFail(String msg);
	
	/**
	 * ����ȡ��
	 * @param msg
	 */
	void OnCancel(String msg);
}
