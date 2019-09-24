package com.adtest;

import android.graphics.Color;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

import javax.annotation.Nonnull;

/**
 * Created by Kevin on 2019-09-23<br/>
 * Describe:<br/>
 */
public class LinearWidget extends SimpleViewManager<BannerLinearLayout> {
    private static BannerLinearLayout mContainer;
    private static ThemedReactContext mContext;

    @Nonnull
    @Override
    public String getName() {
        return "LinearWidget";
    }

    @Nonnull
    @Override
    protected BannerLinearLayout createViewInstance(@Nonnull ThemedReactContext reactContext) {
        mContext = reactContext;
        Log.i("gdchent","createViewInstance");
        mContainer=new BannerLinearLayout(reactContext);
        TextView textView = new TextView(mContext);
        LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(200, 100);
        textView.setLayoutParams(ll);
        textView.setText("Hi-------");
        mContainer.addView(textView);
        return mContainer;
    }

    /**
     * 这个方法是原生添加子view
     */
    @ReactMethod
    public void addView() {
        mContext.getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mContainer.setOrientation(LinearLayout.VERTICAL);
                Log.i("gdchent", "执行了addView");
                TextView textView = new TextView(mContext.getCurrentActivity());
                LinearLayout.LayoutParams ll = new LinearLayout.LayoutParams(200, 100);
                textView.setLayoutParams(ll);
                textView.setText("Hello");
                textView.setTextColor(Color.GREEN);
                mContainer.addView(textView);
            }
        });
    }
}
