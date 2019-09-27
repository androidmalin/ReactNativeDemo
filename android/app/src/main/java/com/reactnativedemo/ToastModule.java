package com.reactnativedemo;

import android.view.Gravity;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

public class ToastModule extends ReactContextBaseJavaModule {

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public ToastModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    //这个名字在 JavaScript 端标记这个模块。这里我们把这个模块叫做ToastModule，
    // 这样就可以在 JavaScript 中通过NativeModules.ToastModule访问到这个模块
    @Override
    public String getName() {
        return "ToastModule";
    }

    //方法getConstants返回了需要导出给 JavaScript 使用的常量。
    // 它并不一定需要实现，但在定义一些可以被 JavaScript 同步访问到的预定义的值时非常有用
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    @ReactMethod
    public void show(String message, int duration) {
        Toast toast = Toast.makeText(getReactApplicationContext(), message, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}