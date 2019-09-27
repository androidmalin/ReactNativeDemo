//
//  CallbackTestModule.m
//  ReactNativeDemo
//
//  Created by malin on 2019/9/27.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "CallbackTestModule.h"

@implementation CallbackTestModule

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(measureLayout:(NSInteger)a: (NSInteger)b
                  errorCallback:(RCTResponseSenderBlock)errorCallback
                  successCallback:(RCTResponseSenderBlock)successCallback){
  
  successCallback(@[
                    @7777,
                    [NSNumber numberWithInteger:b],
                    [NSNumber numberWithInteger:a],
                    [NSNumber numberWithInteger:b]
  ]);
}

@end
