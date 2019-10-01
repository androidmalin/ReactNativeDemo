#!/bin/bash
first_device=`adb devices | awk  'NR==2' | awk  '{print $1}'`
react-native run-android --deviceId $first_device
