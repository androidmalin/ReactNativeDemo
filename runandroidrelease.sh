#!/bin/bash
first_device=`adb devices | awk  'NR==2' | awk  '{print $1}'`
packageName="com.reactnativedemo"
adb -s $first_device uninstall $packageName
react-native run-android --tasks installRelease --deviceId $first_device
