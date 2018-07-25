package com.zedney.rokouch.fragments.intro_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.zedney.rokouch.R;
import com.zedney.rokouch.adapters.ExpandableListAdapter;
import com.zedney.rokouch.models.Info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectedBookFragment extends Fragment {

    Button shopBtn;
    LinearLayout commentsLayout;
    View view;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Info>> listDataChild;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_selected_book, container, false);
        shopBtn = (Button) view.findViewById(R.id.shop);
        commentsLayout = (LinearLayout) view.findViewById(R.id.commentsLayout);
        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this.getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        shopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new Details_request_book());
            }
        });
        commentsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new CommentsFragment());
            }
        });
        return view;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Info>>();

        // Adding child data
        listDataHeader.add("معلومات الكتاب");


        // Adding child data
        List<Info> top250 = new ArrayList<Info>();
        top250.add(new Info("السعر", "55 ريال"));
        top250.add(new Info("المؤلف", "نجيب محفوظ"));
        top250.add(new Info("المحقق", "محفوظ"));
        top250.add(new Info("دار النشر", "دار السلام"));
        top250.add(new Info("الصنف", "علمي"));
        top250.add(new Info("تاريخ الاصدار", "1999"));
        top250.add(new Info("وصف الكتاب", ""));


        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data

    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}
