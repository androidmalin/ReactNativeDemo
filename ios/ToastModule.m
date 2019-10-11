//
//  ToastModule.m
//  ReactNativeDemo
//
//  Created by malin on 2019/9/27.
//  Copyright © 2019 Facebook. All rights reserved.
//  https://github.com/remember17/WHToast

#import "ToastModule.h"
#import <WHToast.h>

@implementation ToastModule

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(show:(NSString *)name: (NSInteger)b){
  dispatch_async(dispatch_get_main_queue(), ^{
   [WHToast showMessage:name duration:2 finishHandler:^{
     NSLog(@"%@", name);
      }];
  });
}

- (NSDictionary *)constantsToExport
{
  return @{ @"SHORT":[NSNumber numberWithInt:1],
            @"LONG":[NSNumber numberWithInt:2] };
}

//If you override - constantsToExport then you should also implement + requiresMainQueueSetup to 
//let React Native know if your module needs to be initialized on the main thread. 
//Otherwise you will see a warning that in the future your module may be initialized on a background thread unless you explicitly opt out with + requiresMainQueueSetup:
+ (BOOL)requiresMainQueueSetup
{
  return YES;  // only do this if your module initialization relies on calling UIKit!
}

@end
