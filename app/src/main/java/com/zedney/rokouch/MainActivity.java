package com.zedney.rokouch;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.zedney.rokouch.fragments.intro_fragments.AboutFragment;
import com.zedney.rokouch.fragments.intro_fragments.BottomNavigationFragment;
import com.zedney.rokouch.fragments.intro_fragments.FavoritesFragment;
import com.zedney.rokouch.fragments.intro_fragments.PanierFragment;
import com.zedney.rokouch.fragments.intro_fragments.PaymentFragment;
import com.zedney.rokouch.fragments.intro_fragments.ProfilFragment;
import com.zedney.rokouch.fragments.intro_fragments.RatingFragment;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.mipmap.menu);


        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        switch (menuItem.getItemId()) {

                            case R.id.home:
                                mDrawerLayout.openDrawer(GravityCompat.START);
                                showFragment(new BottomNavigationFragment());
                                break;
                            case R.id.action_most_popular:
                                showFragment(new FavoritesFragment());
                                break;
                            case R.id.booked:
                                showFragment(new RatingFragment());
                                break;
                            case R.id.panier:
                                showFragment(new PanierFragment());
                                break;
                            case R.id.offers:
                                showFragment(new FavoritesFragment());
                                break;
                            case R.id.notif:
                                showFragment(new FavoritesFragment());
                                break;
                            case R.id.account:
                                Log.e("Main ", "About fragment");
                                showFragment(new ProfilFragment());
                                break;
                            case R.id.contact:
                                showFragment(new AboutFragment());
                                break;
                            case R.id.logout:
                                showFragment(new AboutFragment());
                                break;
                            default:
                                return false;
                        }

                        return true;
                    }
                });




        showFragment(new BottomNavigationFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_view, menu);
        return true;
    }



    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }



   /* @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }*/
}
