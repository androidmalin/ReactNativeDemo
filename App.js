import React, {Component} from 'react';
import {Button, StyleSheet, View} from 'react-native';
import ToastExample from './ToastExample';
import CallbackTestModule from './CallbackTestModule';

export default class ButtonBasics extends Component {
  _onPressButton() {
    CallbackTestModule.measureLayout(
      100,
      1000,
      msg => {
        console.log(msg);
        ToastExample.show(msg, ToastExample.SHORT);
      },
      (relativeX, relativeY, width, height) => {
        console.log(relativeX + ':' + relativeY + ':' + width + ':' + height);
        ToastExample.show(
          relativeX + ':' + relativeY + ':' + width + ':' + height,
          ToastExample.SHORT,
        );
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
