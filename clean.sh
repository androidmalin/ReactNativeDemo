#!/bin/bash
#Also note that the cached directory is located in ~/.yarn-cache/:
#yarn cache clean: cleans that directory
#yarn cache list: shows the list of cached dependencies
#yarn cache dir: prints out the path of your cached directory

rm package-lock.json
#rm yarn.lock
#rm -rf node_modules
rm -rf ~/.rncache
rm -rf ios/Pods
#yarn cache clean

#upgrade dependencies
#yarn upgrade-interactive --latest
#需要手动选择升级的依赖包，按空格键选择，a 键切换所有，i 键反选选择

yarn install
cd ios
#could not build module 'Foundation'
#rm -rf /Users/malin/Library/Developer/Xcode/DerivedData/ModuleCache.noindex/*
rm -rf /Users/malin/Library/Developer/Xcode/DerivedData/ReactNativeDemo-*
rm -rf ios/build
rm -rf ios/Pods
pod install
cd ..
cd android
rm -rf .idea/ .gradle/
find . -name "build" -type d | xargs rm -rf
find . -name "*.iml" -type f | xargs rm -rf
find . -name ".settings" -type d | xargs rm -rf
find . -name ".project" -type f | xargs rm -rf
find . -name ".classpath" -type f | xargs rm -rf
cd ..

