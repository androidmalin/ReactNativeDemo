import React, {Component} from 'react';
import {FlatList, StyleSheet, Text, View} from 'react-native';

export default class FlatListBasics extends Component {
  render() {
    return (
      <View style={styles.container}>
        <FlatList
          data={[
            {key: 'Devin'},
            {key: 'Dan'},
            {key: 'Dominic'},
            {key: 'Jackson'},
            {key: 'James'},
            {key: 'Joel'},
            {key: 'John'},
            {key: 'Jillian'},
            {key: 'Jimmy'},
            {key: '1'},
            {key: '2'},
            {key: '3'},
            {key: '4'},
            {key: '5'},
            {key: '6'},
            {key: '7'},
            {key: '8'},
            {key: '9'},
            {key: '10'},
            {key: '11'},
            {key: '12'},
            {key: '13'},
            {key: '14'},
            {key: '15'},
            {key: '16'},
            {key: '17'},
            {key: '18'},
            {key: '19'},
            {key: '20'},
          ]}
          renderItem={({item}) => <Text style={styles.item}>{item.key}</Text>}
        />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 22,
  },
  item: {
    padding: 10,
    fontSize: 18,
    height: 44,
  },
});
