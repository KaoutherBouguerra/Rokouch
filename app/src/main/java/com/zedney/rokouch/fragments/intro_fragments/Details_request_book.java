package com.zedney.rokouch.fragments.intro_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.zedney.rokouch.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Details_request_book extends Fragment {

    ImageView plus;
    ImageView moins;
    TextView nbTxt;
    Button buyBtn;
    int nb = 2;
    View view;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_details_request_book, container, false);
        plus = (ImageView) view.findViewById(R.id.plus);
        moins = (ImageView) view.findViewById(R.id.moins);
        nbTxt = (TextView) view.findViewById(R.id.nb);
        buyBtn = (Button) view.findViewById(R.id.shop);
        nbTxt.setText(nb+"");
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nb++;
                nbTxt.setText(nb+"");
            }
        });
        moins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nb>0) {
                    nb--;
                    nbTxt.setText(nb+"");
                    if (nb == 0)
                        moins.setEnabled(false);
                }

            }
        });
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(new MapFragment());

            }
        });
        return view;
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}
