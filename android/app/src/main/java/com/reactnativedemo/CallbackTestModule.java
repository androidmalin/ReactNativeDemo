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

    @ReactMethod
    public void measureLayout(int a, int b, Callback errorCallback, Callback successCallback) {
        try {
            Log.d(TAG, "JS调用Android Native方法measureLayout():参数为" + "a:" + a + " b:" + b);
            successCallback.invoke(6666, b, a, b);
        } catch (IllegalViewOperationException e) {
            errorCallback.invoke(e.getMessage());
        }
    }
}
