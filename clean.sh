#!/bin/bash
#Also note that the cached directory is located in ~/.yarn-cache/:
#yarn cache clean: cleans that directory
#yarn cache list: shows the list of cached dependencies
#yarn cache dir: prints out the path of your cached directory
rm package-lock.json
rm yarn.lock
rm -rf node_modules
rm -rf ~/.rncache
rm -rf ios/Pods
yarn cache clean
yarn install
cd ios
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

