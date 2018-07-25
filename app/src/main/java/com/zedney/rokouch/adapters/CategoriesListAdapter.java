package com.zedney.rokouch.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zedney.rokouch.LoginActivity;
import com.zedney.rokouch.MainActivity;
import com.zedney.rokouch.R;
import com.zedney.rokouch.fragments.intro_fragments.SelectedBookFragment;
import com.zedney.rokouch.models.Book;
import com.zedney.rokouch.models.Category;

import java.util.List;

public class CategoriesListAdapter extends BaseAdapter {

    private Activity _mContext;
    private LayoutInflater inflater;
    private List<Category> myCategoriesModelItems;
    private String activityName;
    FragmentTransaction fragmentTransaction;

    public CategoriesListAdapter(FragmentActivity activity, List<Category> myCategoriesModelItems, FragmentTransaction fragmentTransaction) {
        this._mContext = activity;
        this.myCategoriesModelItems = myCategoriesModelItems;
        this.activityName = activityName;
        this.fragmentTransaction = fragmentTransaction;
    }



    @Override
    public int getCount() {
        return myCategoriesModelItems.size();
    }

    @Override
    public Object getItem(int location) {
        return myCategoriesModelItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) _mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item, null);

        LinearLayout _linearList = (LinearLayout) convertView.findViewById(R.id.linearList);
        TextView _title = (TextView) convertView.findViewById(R.id.title);



        final Category m = myCategoriesModelItems.get(position);
        if (!myCategoriesModelItems.isEmpty()) {

            _title.setText(m.getTitle());
            for (Book book : m.getBooks()) {
                String bookTitle = book.getTitle();
                String bookImg = book.getImg();
                String bookPrice = book.getPrice();

                addViews(_linearList, book);
            }

        }





        return convertView;
    }

    private void addViews(LinearLayout linearLayout, Book book) {


        View v = LayoutInflater.from(_mContext).inflate(R.layout.custom_item, null);
        linearLayout.addView(v);
        linearLayout.requestLayout();

        TextView _bookTitle  = (TextView) v.findViewById(R.id.bookTitle);
        TextView _bookPrice  = (TextView) v.findViewById(R.id.bookPrice);

        _bookTitle.setText(book.getTitle());
        _bookPrice.setText(book.getPrice());

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(new SelectedBookFragment());
            }
        });


    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = ((FragmentActivity) _mContext).getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void clear() {

        myCategoriesModelItems.clear();

    }
}
