package com.zedney.rokouch.fragments.intro_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.zedney.rokouch.R;
import com.zedney.rokouch.adapters.PanierAdapter;
import com.zedney.rokouch.models.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PanierFragment extends Fragment {


    private ListView listView;
    private ArrayAdapter<Book> adapter;
    private ArrayList<Book> booksList;
    private TextView totalClassmates;
    private SwipeLayout swipeLayout;
    View view;
    private final static String TAG = "Panier";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_panier, container, false);
        listView = (ListView) view.findViewById(R.id.list_item);

        booksList = new ArrayList<>();
        booksList.add(new Book("غسان كنفاني","","45 ريال"));
        booksList.add(new Book("مريم لويس","","55 ريال"));
        booksList.add(new Book("مصطفى المنفلوطي","","55 ريال"));

        setListViewAdapter();
        return view;
    }





    private void setSwipeViewFeatures() {
        //set show mode.
        swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);

        //add drag edge.(If the BottomView has 'layout_gravity' attribute, this line is unnecessary)
        swipeLayout.addDrag(SwipeLayout.DragEdge.Left, view.findViewById(R.id.bottom_wrapper));

        swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {
                Log.i(TAG, "onClose");
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                Log.i(TAG, "on swiping");
            }

            @Override
            public void onStartOpen(SwipeLayout layout) {
                Log.i(TAG, "on start open");
            }

            @Override
            public void onOpen(SwipeLayout layout) {
                Log.i(TAG, "the BottomView totally show");
            }

            @Override
            public void onStartClose(SwipeLayout layout) {
                Log.i(TAG, "the BottomView totally close");
            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                //when user's hand released.
            }
        });
    }

    private void setListViewAdapter() {
        adapter = new PanierAdapter(getActivity(), R.layout.item_listview, booksList);
        listView.setAdapter(adapter);
        //setSwipeViewFeatures();

    }


}
