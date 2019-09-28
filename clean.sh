#!/bin/bash
rm -rf node_modules && \
rm -rf ~/.rncache && \
rm -rf ios/Pods && \
rm -rf android/.gradle && \
rm -rf android/app/build && \
yarn cache clean && \
yarn install  && \
cd ios  && \
pod install  && \
cd ..
