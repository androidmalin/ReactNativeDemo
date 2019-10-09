package com.reactnativedemo;

import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;

public class PromiseModule extends ReactContextBaseJavaModule {

    private static final String TAG = "PromiseModule";

    public PromiseModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "PromiseModule";
    }


    //原生模块还支持一种特殊的参数——回调函数。它提供了一个函数来把返回值传回给 JavaScript
    //原生模块通常只应调用回调函数一次。但是，它可以保存 callback 并在将来调用。
    //请务必注意 callback 并非在对应的原生函数返回后立即被执行——注意跨语言通讯是异步的，这个执行过程会通过消息循环来进行。
    @ReactMethod
    public void numberTransferFunction(String x, String y, Promise promise) {
        try {
            WritableMap map = Arguments.createMap();
            Log.d(TAG, "JS调用Android PromiseModule的Native方法numberAddFunction():参数为" + "x:" + x + " y:" + y);
            map.putString("x", x);
            map.putString("y", y);
            promise.resolve(map);
        } catch (IllegalViewOperationException e) {
            promise.reject(e);
        }
    }
}
