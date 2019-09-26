import React, {Component} from 'react';
import {Text, View} from 'react-native';

export default class HelloWorldApp extends Component {
  render() {
    return (
      // eslint-disable-next-line react-native/no-inline-styles
      <View style={{flex: 1, justifyContent: 'center', alignItems: 'center'}}>
        <Text>Hello, World!</Text>
      </View>
    );
  }
}
