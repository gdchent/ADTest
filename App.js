/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View,NativeModules,Button} from 'react-native';
import LinearView from './linearView'
import NativeTextView from './NativeTextView'

const instructions = Platform.select({
  ios: 'Press Cmd+R to reload,\n' + 'Cmd+D or shake for dev menu',
  android:
    'Double tap R on your keyboard to reload,\n' +
    'Shake or press menu button for dev menu',
});

export default class App extends Component {
  render() {
    return (
      <View>
        <Button title='Hello' style={{backgroundColor:'green'}}
        onPress={()=>{
          NativeModules.LinearWidget.addView()
        }}/>
        <NativeTextView
       text="TextView widget from native"
       textSize={18}
       style={{width:200,height:200}}
       bgColor={{}}
       onClick={(msg)=>Alert.alert('js press',msg)}
       /> 
       <LinearView style={{width:200,height:300,backgroundColor:'red'}}/>
      </View>

    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
