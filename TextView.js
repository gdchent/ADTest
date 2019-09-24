import PropTypes from 'prop-types';
import {Component} from 'react';
import { requireNativeComponent,View } from "react-native";

let tv = {
    name:'TextView',
    propTypes:{
        text:PropTypes.string,
        textSize:PropTypes.number,
        textColor:PropTypes.number,
        ...View.propTypes
    }
}
export default requireNativeComponent('TextView',tv);