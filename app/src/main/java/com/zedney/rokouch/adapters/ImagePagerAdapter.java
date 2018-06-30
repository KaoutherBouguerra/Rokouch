package com.zedney.rokouch.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zedney.rokouch.R;

public  class ImagePagerAdapter extends PagerAdapter {
    private final int[] mImages = new int[] {
            R.drawable.book0,
            R.drawable.book2,
            R.drawable.book1,
            R.drawable.book2
    };

    Context context;
    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }

    public ImagePagerAdapter(Context cnx) {
        context = cnx;
    }

    @Override
    public int getCount() {
        return this.mImages.length;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {

        final ImageView imageView = new ImageView(context);
        final int padding = context.getResources().getDimensionPixelSize(
                R.dimen.padding_medium);
        //imageView.setPadding(padding, padding, padding, padding);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(this.mImages[position]);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;
    }

    @Override
    public boolean isViewFromObject(final View view, final Object object) {
        return view == ((ImageView) object);
    }
}