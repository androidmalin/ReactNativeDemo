#!/bin/bash
first_device=`adb devices | awk  'NR==2' | awk  '{print $1}'`
packageName="com.reactnativedemo"
adb -s $first_device uninstall $packageName
react-native run-android --deviceId=$first_device --tasks=installDebug --variant=debug
#or use
#npx react-native run-android
