import React, { Component } from 'react';
import { View } from 'react-native';
import RCTTextView from './TextView'
import PropTypes from 'prop-types';
export default class NativeTextView extends Component {
    static propTypes = {
        text: PropTypes.string,
        textSize: PropTypes.number,
        textColor: PropTypes.number,
        ...View.propTypes
    }


    render() {
        const { text, textSize, textColor, style,onPress } = this.props
        return (
            <RCTTextView
                text={text}
                style={style}
                textSize={textSize}
                textColor={textColor}
                onPress={onPress}
            >
            </RCTTextView>
        )
    }
}
