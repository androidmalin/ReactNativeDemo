//
//  ToastModule.m
//  ReactNativeDemo
//
//  Created by malin on 2019/9/27.
//  Copyright © 2019 Facebook. All rights reserved.
//  https://github.com/remember17/WHToast

#import "ToastModule.h"
#import <WHToast.h>
#import <UIView+Toast.h>

@implementation ToastModule

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(show:(NSString *)name: (NSInteger)b){
  dispatch_async(dispatch_get_main_queue(), ^{
   [WHToast showMessage:name duration:2 finishHandler:^{
     NSLog(@"%@", name);
      }];
  });
}

@end
