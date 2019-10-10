//
//  EventModule.m
//  ReactNativeDemo
//
//  Created by malin on 2019/10/10.
//  Copyright © 2019 Facebook. All rights reserved.
//
//http://yangguang1029.github.io/2018/05/28/rn-event-emitter/

#import "EventModule.h"

@implementation EventModule

RCT_EXPORT_MODULE();

- (NSArray<NSString *> *)supportedEvents
{
  return @[@"EventName"];
}

RCT_EXPORT_METHOD(callNativeBySend){
  
  [self sendEventWithName:@"EventName" body:@{@"name": @"EventName"}];
//  [self.bridge enqueueJSCall:@"RCTDeviceEventEmitter"
//      method:@"emit"
//        args:@[@"EventName"]
//  completion:NULL];
}

@end
