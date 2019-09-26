/* eslint-disable react-native/no-inline-styles */
import React, {Component} from 'react';
import {View} from 'react-native';

export default class ViewStyleBase extends Component {
  render() {
    return (
      <View>
        <View style={{width: 50, height: 50, backgroundColor: 'red'}} />
        <View style={{width: 100, height: 100, backgroundColor: 'green'}} />
        <View style={{width: 150, height: 150, backgroundColor: 'blue'}} />
      </View>
    );
  }
}
