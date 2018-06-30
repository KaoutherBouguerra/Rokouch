package com.zedney.rokouch.fragments.intro_fragments;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rd.PageIndicatorView;
import com.zedney.rokouch.R;
import com.zedney.rokouch.adapters.ImagePagerAdapter;
import com.zedney.rokouch.utils.RoundedImage;

/**
 * A simple {@link Fragment} subclass.
 */
public class BottomNavigationFragment extends Fragment {


    View v;
    private static final int CORNER_RADIUS = 20; // dips
    private static final int MARGIN = 6; // dips
    private  int mCornerRadius;
    private  int mMargin;
    public BottomNavigationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_bottom_navigation, container, false);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) v.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_favorites:
                                showFragment(new FavoritesFragment());
                            case R.id.action_most_popular:

                            case R.id.action_new:

                        }
                        return true;
                    }
                });

        final ViewPager viewPager = (ViewPager) v.findViewById(R.id.view_pager);
        final ImagePagerAdapter adapter = new ImagePagerAdapter(getActivity());
        viewPager.setAdapter(adapter);

        final PageIndicatorView circleIndicator = (PageIndicatorView) v.findViewById(R.id.pageIndicatorView);
        circleIndicator.setViewPager(viewPager);

        final float density = getActivity().getResources().getDisplayMetrics().density;
        mCornerRadius = (int) (CORNER_RADIUS * density + 0.5f);
        mMargin = (int) (MARGIN * density + 0.5f);
        RelativeLayout frame1 = (RelativeLayout) v.findViewById(R.id.frame1);
        TextView textView1 = (TextView) v.findViewById(R.id.textView1);
        RelativeLayout frame2 = (RelativeLayout) v.findViewById(R.id.frame2);

        Bitmap mBitmap = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.librairie);

        RoundedImage d = new RoundedImage(mBitmap, mCornerRadius, mMargin);
        //   frame1.setBackground(d);
        //   frame2.setBackground(d);

        frame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new BooksCateroriesFragment());
            }
        });
        frame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        int w = mBitmap.getWidth();
        int h = mBitmap.getHeight();

        float ratio = w / (float) h;

        ViewGroup.LayoutParams lp = frame1.getLayoutParams();

        ViewGroup.LayoutParams lptextView1 = textView1.getLayoutParams();
        //  lp.width = getContext().getResources().getDisplayMetrics().widthPixels;


        // lp.height = (int) (lp.width / ratio);
        ViewGroup.LayoutParams lp2 = frame2.getLayoutParams();
        return v;
    }


    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
