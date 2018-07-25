package com.zedney.rokouch.fragments.intro_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zedney.rokouch.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Details_request_book extends Fragment {


    public Details_request_book() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_request_book, container, false);
    }

}
