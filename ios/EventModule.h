//
//  EventModule.h
//  ReactNativeDemo
//
//  Created by malin on 2019/10/10.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <React/RCTBridgeModule.h>
#import <React/RCTEventEmitter.h>

//官方文档推荐的原生往js层传递消息的方式，iOS端是继承RCTEventEmitter，然后调用sendEventWithName方法
//http://yangguang1029.github.io/2018/05/28/rn-event-emitter/
@interface EventModule : RCTEventEmitter <RCTBridgeModule>

@end

