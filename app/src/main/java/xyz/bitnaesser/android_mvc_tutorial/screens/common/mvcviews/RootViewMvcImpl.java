package xyz.bitnaesser.android_mvc_tutorial.screens.common.mvcviews;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.bitnaesser.android_mvc_tutorial.R;

/**
 * Very simple MVC view containing just single FrameLayout
 */
public class RootViewMvcImpl implements ViewMvc {

    private View mRootView;

    public RootViewMvcImpl(Context context, ViewGroup container) {
        mRootView = LayoutInflater.from(context).inflate(R.layout.mvc_view_frame_layout, container);
    }

    @Override
    public View getRootView() {
        return mRootView;
    }

    @Override
    public Bundle getViewState() {
        // This MVC view has no state that could be retrieved
        return null;
    }
}
