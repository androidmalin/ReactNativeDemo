package com.reactnativedemo;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.IllegalViewOperationException;

import javax.annotation.Nonnull;

public class CallbackTestModule extends ReactContextBaseJavaModule {

    public CallbackTestModule(@Nonnull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nonnull
    @Override
    public String getName() {
        return "CallbackTestModule";
    }

    @ReactMethod
    public void measureLayout(int a, int b,
                              Callback errorCallback,
                              Callback successCallback) {
        try {
            float relativeX = 1 + a;
            float relativeY = 2 + b;
            float width = 3;
            float height = 4;
            successCallback.invoke(relativeX, relativeY, width, height);
        } catch (IllegalViewOperationException e) {
            errorCallback.invoke(e.getMessage());
        }
    }
}
