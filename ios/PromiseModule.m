//
//  PromiseModule.m
//  ReactNativeDemo
//
//  Created by malin on 2019/10/9.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import "PromiseModule.h"

@implementation PromiseModule

RCT_EXPORT_MODULE();

//这里使用RCT_REMAP_METHOD宏定义Native，他的第一个参数是方法名，后面的参数是方法的实现，
//在JavaScript调用Promise时并不需要在方法名中体现。
RCT_EXPORT_METHOD(numberTransferFunction:(NSString *)x: (NSString *)y resolver:(RCTPromiseResolveBlock)resolver
    rejecter:(RCTPromiseRejectBlock)reject){

  //NSArray * array = @[@"11",@"22"];
  //NSArray * array = @[[NSNumber numberWithInt:11],[NSNumber numberWithInt:22]];
  NSDictionary * strDic = @{@"x":x,@"y":y};
 
  resolver(strDic);
}

@end
