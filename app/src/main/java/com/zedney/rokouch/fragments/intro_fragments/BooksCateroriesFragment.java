package com.zedney.rokouch.fragments.intro_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListView;

import com.zedney.rokouch.R;
import com.zedney.rokouch.adapters.CategoriesListAdapter;
import com.zedney.rokouch.models.Book;
import com.zedney.rokouch.models.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BooksCateroriesFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener,ViewTreeObserver.OnScrollChangedListener {



    View v;
    private ListView listView;
    private CategoriesListAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private static final String TAG = BooksCateroriesFragment.class.getSimpleName();
    private List<Category> myOrdersList = new ArrayList<Category>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_books_caterories, container, false);


        listView = (ListView) v.findViewById(R.id.list);
        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);

        FragmentTransaction fragmentTransaction =  getActivity().getSupportFragmentManager().beginTransaction();
        adapter = new CategoriesListAdapter(getActivity(), myOrdersList, fragmentTransaction);
        listView.setAdapter(adapter);


        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {

                swipeRefreshLayout.setRefreshing(true);
                fetchCategories();
            }
        } );

        return v;
    }

    private void fetchCategories() {
        swipeRefreshLayout.setRefreshing(true);
        ArrayList<Book> books0 = new ArrayList<>();
        books0.add(new Book("غسان كنفاني","","45 ريال"));
        books0.add(new Book("مريم لويس","","55 ريال"));
        books0.add(new Book("مصطفى المنفلوطي","","55 ريال"));
        books0.add(new Book("غسان كنفاني","","55 ريال"));
        myOrdersList.add(new Category("الأدب والخيال",books0));
        myOrdersList.add(new Category("التاريخ والجغرافيا",books0));
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);


    }

    @Override
    public void onRefresh() {
        myOrdersList.clear();
        adapter.clear();

        Log.e(TAG,"list onRefresh ");
        fetchCategories();
    }
    @Override
    public void onStart() {
        super.onStart();
        listView.getViewTreeObserver().addOnScrollChangedListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        listView.getViewTreeObserver().removeOnScrollChangedListener(this);
    }
    @Override
    public void onScrollChanged() {
        if (listView.getFirstVisiblePosition() == 0) {
            swipeRefreshLayout.setEnabled(true);
        } else {
            swipeRefreshLayout.setEnabled(false);
        }
    }

}
