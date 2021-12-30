package com.jiaoniban.client.controller;

import android.content.Context;
import android.util.Log;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class PushServiceController {
    private Context mContext;

    public PushServiceController(Context mContext) {
        XGPushConfig.enableDebug(mContext,true);
        this.mContext = mContext;
    }

    public void initPushService(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                XGPushManager.registerPush(mContext, new XGIOperateCallback() {
                    @Override
                    public void onSuccess(Object o, int i) {
                        Log.d("TPush", "注册成功，设备token为：" + o);
                    }
                    @Override
                    public void onFail(Object o, int i, String s) {
                        Log.d("TPush", "注册失败，错误码：" + i + ",错误信息：" + s);
                    }
                });
            }
        }).start();
    }

    public void finishPushService(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                XGPushManager.unregisterPush(mContext, new XGIOperateCallback() {
                    @Override
                    public void onSuccess(Object o, int i) {
                        Log.d("TPush", "取消成功，设备token为：" + o);
                    }

                    @Override
                    public void onFail(Object o, int i, String s) {
                        Log.d("TPush", "取消注册失败，错误码：" + i + ",错误信息：" + s);
                    }
                });
            }
        }).start();
    }

    public void registerTagRule(String[] tag){
        new Thread(new Runnable() {
            @Override
            public void run() {
                XGPushManager.clearAndAppendTags(mContext,
                        "Registered",
                        new HashSet<String>(Arrays.asList(tag)),
                        new XGIOperateCallback() {
                            @Override
                            public void onSuccess(Object o, int i) {
                                Log.d("TPush", "注册成功，参数为：" + o);
                            }

                            @Override
                            public void onFail(Object o, int i, String s) {
                                Log.d("TPush", "注册失败，参数为：" + o);
                            }
                        });
            }
        }).start();
    }

}
