package com.reactnativedemo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

public class EventModule extends ReactContextBaseJavaModule implements LifecycleEventListener {

    private static final String TAG = "EventModule";
    private ReactApplicationContext mReactContext;

    public EventModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
        //给上下文对象赋值
        mReactContext = reactContext;
        reactContext.addLifecycleEventListener(this);
    }

    @NonNull
    @Override
    public String getName() {
        return "EventModule";
    }

    @ReactMethod
    public void callNativeBySend() {
        fun();
    }

    private void fun() {
        //在该方法中开启线程，并且延迟3秒，然后向JavaScript端发送事件。
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //发送事件,事件名为EventName
            WritableMap map = Arguments.createMap();
            map.putString("client", "android");
            sendEvent(mReactContext, map);
        }).start();
    }

    //定义发送事件的函数
    private void sendEvent(ReactContext reactContext, @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("EventName", params);//原生调Rn
    }

    @Override
    public void onHostResume() {
        // Activity `onResume`
        Log.d(TAG, "onHostResume");
    }

    @Override
    public void onHostPause() {
        // Activity `onPause`
        Log.d(TAG, "onHostPause");
    }

    @Override
    public void onHostDestroy() {
        // Activity `onDestroy`
        Log.d(TAG, "onHostDestroy");
    }
}
