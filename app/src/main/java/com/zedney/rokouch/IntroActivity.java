package com.zedney.rokouch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro2;
import com.zedney.rokouch.fragments.intro_fragments.AppIntroSliderFragment;
import com.zedney.rokouch.fragments.intro_fragments.FirstSlideFragment;

public class IntroActivity  extends AppIntro2 {

    @Override
    public void init(Bundle savedInstanceState) {
        // my_child_toolbar is defined in the layout file


        // Enable the Up button
        // ab.setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

       // overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        FirstSlideFragment slide1 = new FirstSlideFragment();
        //adding the three slides for introduction app you can ad as many you needed
        addSlide(AppIntroSliderFragment.newInstance(R.layout.fragment_first_slide));
        addSlide(AppIntroSliderFragment.newInstance(R.layout.fragment_second_slide));
        addSlide(AppIntroSliderFragment.newInstance(R.layout.fragment_third_slide));

        setIndicatorColor(R.color.black, R.color.color_text_dark);

        // Show and Hide Skip and Done buttons
        showStatusBar(true);
        showSkipButton(false);
        setProgressButtonEnabled(true);

        // Turn vibration on and set intensity
        // You will need to add VIBRATE permission in Manifest file
        // setVibrate(true);
        // setVibrateIntensity(30);

        // Add animation to the intro slider
        setDepthAnimation();

    }

    @Override
    public void onSkipPressed() {
        // Do something here when users click or tap on Skip button.
        this.finish();
    }

    @Override
    public void onNextPressed() {
        // Do something here when users click or tap on Next button.
    }

    @Override
    public void onDonePressed() {
        // Do something here when users click or tap tap on Done button.
        this.finish();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSlideChanged() {
        // Do something here when slide is changed
    }

    // on back pressed
    @Override
    public void onBackPressed() {

        // this.finish();
        //  Intent homeIntent = new Intent(this, MainActivity.class);
        //homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        super.onBackPressed();
    }
}
