package com.reactnativedemo;

import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * https://github.com/sucese/react-native/blob/master/doc/ReactNative%E6%BA%90%E7%A0%81%E7%AF%87/6ReactNative%E6%BA%90%E7%A0%81%E7%AF%87%EF%BC%9A%E9%80%9A%E4%BF%A1%E6%9C%BA%E5%88%B6.md
 * JS代码调用Java代码
 */
public class ToastModule extends ReactContextBaseJavaModule {

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public ToastModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    //这个名字在 JavaScript 端标记这个模块。这里我们把这个模块叫做ToastModule，
    // 这样就可以在 JavaScript 中通过NativeModules.ToastModule访问到这个模块
    // 返回模块名字供JS代码调用
    @NonNull
    @Override
    public String getName() {
        return "ToastModule";
    }

    //方法getConstants返回了需要导出给 JavaScript 使用的常量。
    // 它并不一定需要实现，但在定义一些可以被 JavaScript 同步访问到的预定义的值时非常有用
    // 返回常量供JS代码调用
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    // 暴露给JS代码的方法，加@ReactMethod注解，且该方法总是void。
    // 要导出一个方法给 JavaScript 使用，Java 方法需要使用注解@ReactMethod。
    // 方法的返回类型必须为void。React Native 的跨语言访问是异步进行的，所以想要给 JavaScript 返回一个值的唯一办法是使用回调函数或者发送事件
    @ReactMethod
    public void show(String message, int duration) {
        Toast toast = Toast.makeText(getReactApplicationContext(), message, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}