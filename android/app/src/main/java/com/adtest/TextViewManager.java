package com.adtest;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class TextViewManager extends SimpleViewManager<TextView> {

    @Override
    public String getName() {
        return "TextView";
    }

    @Override
    protected TextView createViewInstance(ThemedReactContext reactContext) {
        final TextView textView = new TextView(reactContext);
//        final ThemedReactContext myContext = reactContext;
        //注册点击事件
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("gdchent","onclick");
                WritableMap event = Arguments.createMap();
                event.putString("gdchent", "MyMessage哈哈哈--自定义");
                ReactContext reactContext = (ReactContext) textView.getContext();
                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                        textView.getId(),
                        "topChange",
                        event);
            }
        });
        return textView;
    }

    @ReactProp(name = "text")
    public void setText(TextView textView, String text) {
        textView.setText(text);
    }

    @ReactProp(name = "textSize")
    public void setTextSize(TextView view, float fontSize) {
        view.setTextSize(fontSize);
    }

//    @ReactPropGroup(names =
//            {
//                    ViewProps.PADDING_LEFT,
//                    ViewProps.PADDING_TOP,
//                    ViewProps.PADDING_RIGHT,
//                    ViewProps.PADDING_RIGHT},
//            defaultFloat = )
//    public void setTextPadding(TextView view, int index,Integer color) {
//        view.setPadding();
//
//    }
}