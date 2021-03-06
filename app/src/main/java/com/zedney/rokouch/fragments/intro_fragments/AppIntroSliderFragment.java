//Android App Intro Slider
package com.zedney.rokouch.fragments.intro_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HP on 10/23/2016.
 */
public class AppIntroSliderFragment extends Fragment {
    //Layout id
    private static final String ARG_LAYOUT_RES_ID = "layoutResId";
    private int layoutResId;

    public AppIntroSliderFragment() {
    }

    public static AppIntroSliderFragment newInstance(int layoutResId) {
        AppIntroSliderFragment sampleSlide = new AppIntroSliderFragment();

        Bundle bundleArgs = new Bundle();
        bundleArgs.putInt(ARG_LAYOUT_RES_ID, layoutResId);
        sampleSlide.setArguments(bundleArgs);

        return sampleSlide;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(ARG_LAYOUT_RES_ID))
            layoutResId = getArguments().getInt(ARG_LAYOUT_RES_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutResId, container, false);
    }

}
