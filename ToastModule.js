/**
 * This exposes the native ToastModule module as a JS module. This has a
 * function 'show' which takes the following parameters:
 *
 * 1. String message: A string with the text to toast
 * 2. int duration: The duration of the toast. May be ToastModule.SHORT or
 *    ToastModule.LONG
 */
import {NativeModules} from 'react-native';
// 下一句中的ToastModule即对应上文
// public String getName()中返回的字符串
export default NativeModules.ToastModule;
