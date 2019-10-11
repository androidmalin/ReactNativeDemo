package com.reactnativedemo;

import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.IllegalViewOperationException;

import javax.annotation.Nonnull;

public class CallbackTestModule extends ReactContextBaseJavaModule {

    private static final String TAG = "CallbackTestModule";

    public CallbackTestModule(@Nonnull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nonnull
    @Override
    public String getName() {
        return "CallbackTestModule";
    }

    //原生模块还支持一种特殊的参数——回调函数。它提供了一个函数来把返回值传回给 JavaScript
    //原生模块通常只应调用回调函数一次。但是，它可以保存 callback 并在将来调用。
    //请务必注意 callback 并非在对应的原生函数返回后立即被执行——注意跨语言通讯是异步的，这个执行过程会通过消息循环来进行。
    @ReactMethod
    public void callbackNumberAddFunction(int a, int b, Callback errorCallback, Callback successCallback) {
        try {
            Log.d(TAG, "JS调用Android Native方法callbackFunction():参数为" + "a:" + a + " b:" + b);
            successCallback.invoke(a + b);
        } catch (IllegalViewOperationException e) {
            errorCallback.invoke(e.getMessage());
        }
    }
}
