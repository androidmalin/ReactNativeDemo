import React, {Component} from 'react';
import {
  Button,
  StyleSheet,
  View,
  Text,
  NativeEventEmitter,
  Platform,
  NativeModules,
} from 'react-native';
import ToastModule from './ToastModule';
import CallbackTestModule from './CallbackTestModule';
import PromiseModule from './PromiseModule';
import EventModule from './EventModule';
var subscription;

export default class ButtonBasics extends Component {
  constructor(props) {
    super(props);
    //初始化state对象
    this.state = {
      content: '这是个预定的接受消息',
    };
  }

  //componentDidMount() 会在组件挂载后（插入 DOM 树中）立即调用。依赖于 DOM 节点的初始化应该放在这里。
  //这个方法是比较适合添加订阅的地方。如果添加了订阅，请不要忘记在 componentWillUnmount() 里取消订阅
  componentDidMount() {
    const eventModuleEmitter = new NativeEventEmitter(EventModule);
    subscription = eventModuleEmitter.addListener('EventName', () => {
      this.showState();
      if (Platform.OS === 'android') {
        console.log('receive android native event');
      } else if (Platform.OS === 'ios') {
        console.log('receive ios native event');
      } else {
        console.log('receive unkown platform native event');
      }
    });
  }

  componentWillUnmount() {
    //https://stackoverflow.com/a/36901160/3326683
    subscription.remove();
  }
  _onPressButton() {
    CallbackTestModule.callbackNumberAddFunction(
      100,
      1000,
      msg => {
        console.log('Native回调给JS' + msg);
        ToastModule.show(msg, ToastModule.SHORT);
      },
      result => {
        if (Platform.OS === 'android') {
          console.log('android callbackNumberAddFunction result:' + result);
          ToastModule.show('android result:' + result, ToastModule.SHORT);
        } else if (Platform.OS === 'ios') {
          console.log('ios callbackNumberAddFunction result:' + result);
          ToastModule.show('ios result:' + result, ToastModule.LONG);
        } else {
          console.log(
            'unkown platform callbackNumberAddFunction result:' + result,
          );
          ToastModule.show(
            'unkown platform result:' + result,
            ToastModule.SHORT,
          );
        }
        promiseModuleFunction();
        promiseModuleFunction2();
      },
    );
  }

  render() {
    return (
      <View style={styles.container}>
        <View style={styles.buttonContainer}>
          <Button
            onPress={this._onPressButton}
            title="Js调用Native,Native回调结果给Js,Js再次调用Native的Toast,将数据显示出来"
          />
        </View>
        <Text>{this.state.content}</Text>
        <Button
          onPress={this.callNative.bind(this)}
          title="当你点我的时候会调用原生方法，原生方法延迟3s后会向前端发送事件。
          前端一直在监听该事件，如果收到，则给出alert提示! send 方式"
        />
        <View style={styles.buttonContainer}>
          <Button
            onPress={this._onPressButton}
            title="Press Me"
            color="#841584"
          />
        </View>
        <View style={styles.alternativeLayoutButtonContainer}>
          <Button onPress={this._onPressButton} title="This looks great!" />
          <Button onPress={this._onPressButton} title="OK!" color="#841584" />
        </View>
      </View>
    );
  }

  callNative() {
    console.log('js callNativeBySend');
    NativeModules.EventModule.callNativeBySend();
  }
  showState() {
    this.setState({content: '已经收到了原生模块发送来的事件,send event 方式'});
  }
}

function promiseModuleFunction() {
  PromiseModule.numberTransferFunction('1', '2')
    .then(e => {
      console.log('JSLOG:' + 'x:' + e.x + ',y:' + e.y);
    })
    .catch(error => {
      console.error('JSLOG:' + 'catch error:' + error);
    });
}

//async表示函数里有异步操作，await表示紧跟在后面的表达式需要等待结果。
//http://es6.ruanyifeng.com/#docs/async
async function promiseModuleFunction2() {
  try {
    var {x, y} = await PromiseModule.numberTransferFunction('1', '2');
    console.log('JSLOG2:' + 'x:' + x + ',y:' + y);
  } catch (e) {
    console.error('JSLOG2:' + 'catch error:' + e);
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  buttonContainer: {
    margin: 20,
  },
  alternativeLayoutButtonContainer: {
    margin: 20,
    flexDirection: 'row',
    justifyContent: 'space-between',
  },
});
