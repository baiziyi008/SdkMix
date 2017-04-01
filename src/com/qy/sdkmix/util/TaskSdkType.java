package com.qy.sdkmix.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.qy.sdkmix.Constant.SdkType;
import com.qy.sdkmix.ICallback.IPayCB;
import com.qy.sdkmix.sdk.SdkMigu;
import com.xhsdk.tb.com.InitFuncs;
import com.xhsdk.tb.com.XHTools;
import com.xhsdk.tb.http.XHHttp;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

public class TaskSdkType extends AsyncTask<Void, Void, String>{

	private Context context;
	private String payCode = null;
	private String cpparam = null;
	private IPayCB callback;
	
	private String TAG = "TaskSdkType";
	

	public TaskSdkType(Context context, String payCode, String cpparam,
			IPayCB callback) {
		super();
		this.context = context;
		this.payCode = payCode;
		this.cpparam = cpparam;
		this.callback = callback;
	}

	public TaskSdkType(Context context, String payCode, IPayCB callback) {
		super();
		this.context = context;
		this.payCode = payCode;
		this.callback = callback;
	}

	@Override
	protected String doInBackground(Void... params) {
		Map resultMap = getSdkType();
		String resultStr = parseMap(resultMap);
		
		return resultStr;
	}

	@Override
	protected void onPostExecute(String result) {
		switch (result) {
		case SdkType.TYPE_MIGU:
			SdkMigu	sdk = new SdkMigu(context, payCode, callback);
			Thread	thread = new Thread(sdk);
			thread.start();
			break;

		default:
			break;
		}
	}

	
	private String parseMap(Map resultMap){
		String resultStr = null;
		
		return resultStr;
	}
	
	private Map getSdkType() {
        if (XHTools.isNetworkAvailable(context)) {
            String postBody = regPostBody();
            Log.e(TAG, "request:" + postBody);
            String response = XHHttp.sendRequest("getGameSdkType", postBody, context);
            Log.e(TAG, "response:" + response);
            if (TextUtils.isEmpty(response)) {
                return getDefaultErrorMap();
            } else {
                return getResponseMap(response);
            }

        }
        return getDefaultErrorMap();
    }

    private Map getResponseMap(String response) {
        Map resultMap = new HashMap();
        try {
            Gson gson = new Gson();
            Map map = gson.fromJson(response, Map.class);
            Set<String> set = map.keySet();
            for (String key : set)
                resultMap.put(key, map.get(key));

            String areaId = null;
            try {
                areaId = map.get("areaId").toString();
            } catch (Exception e) {

            }
            if (!TextUtils.isEmpty(areaId) && !"0".equals(areaId) && TextUtils.isEmpty(InitFuncs.getString("areaId", ""))) {
                InitFuncs.putString("areaId", areaId);
            }
            resultMap.remove("areaId");

            return resultMap;
        } catch (JsonSyntaxException ex) {
            ex.printStackTrace();
            return getDefaultErrorMap();
        }
    }

    private Map getDefaultErrorMap() {
        Map resultMap = new HashMap();
        resultMap.put("code", -1);
        return resultMap;
    }

    private String regPostBody() {
        try {
            JSONObject person = new JSONObject();
            person.put("areaId", InitFuncs.getString("areaId", ""));
            person.put("gameId", InitFuncs.getString("gameId", ""));
            person.put("channelId", InitFuncs.getString("channelId", ""));
            person.put("imsi", InitFuncs.getString("imsi", "-1"));
            person.put("imei", InitFuncs.getString("imei", "-1"));
            person.put("mobilePhone", InitFuncs.getString("mobilePhone", ""));
            person.put("model", InitFuncs.getString("model", ""));
            person.put("mnc", InitFuncs.getString("mnc", "-1"));
            person.put("mcc", InitFuncs.getString("mcc", "-1"));
            person.put("lac", InitFuncs.getString("lac", "-1"));
            person.put("cellId", InitFuncs.getString("cellId", "-1"));
            person.put("iccid",InitFuncs.getString("iccid","-1"));
            return person.toString();
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }
}
