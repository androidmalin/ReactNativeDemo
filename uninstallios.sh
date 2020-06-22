#!/bin/bash
packageName="org.reactjs.native.example.ReactNativeDemo"
xcrun simctl terminate booted $packageName
xcrun simctl uninstall booted $packageName
