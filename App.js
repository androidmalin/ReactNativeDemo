import React, {Component} from 'react';
import {Button, StyleSheet, View} from 'react-native';
// import ToastExample from './ToastExample';
import CallbackTestModule from './CallbackTestModule';

export default class ButtonBasics extends Component {
  _onPressButton() {
    CallbackTestModule.measureLayout(
      100,
      1000,
      msg => {
        console.log('Native回调给JS' + msg);
        //ToastExample.show(msg, ToastExample.SHORT);
      },
      (x, y, a, b) => {
        if (x === 6666) {
          console.log(
            'Android Native回调给JS' +
              'x:' +
              x +
              ' ' +
              'y:' +
              y +
              ' ' +
              'a:' +
              a +
              ' ' +
              'b:' +
              b,
          );
        } else if (x === 7777) {
          console.log(
            'iOS Native回调给JS' +
              'x:' +
              x +
              ' ' +
              'y:' +
              y +
              ' ' +
              'a:' +
              a +
              ' ' +
              'b:' +
              b,
          );
        } else {
          console.log(
            '未知 Native 回调给JS' +
              'x:' +
              x +
              ' ' +
              'y:' +
              y +
              ' ' +
              'a:' +
              a +
              ' ' +
              'b:' +
              b,
          );
        }
        // ToastExample.show(
        //   relativeX + ':' + relativeY + ':' + width + ':' + height,
        //   ToastExample.SHORT,
        // );
      },
    );
  }

  render() {
    return (
      <View style={styles.container}>
        <View style={styles.buttonContainer}>
          <Button onPress={this._onPressButton} title="Press Me" />
        </View>
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
