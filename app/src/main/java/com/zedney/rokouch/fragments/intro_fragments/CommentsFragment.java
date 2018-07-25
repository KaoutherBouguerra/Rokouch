package com.zedney.rokouch.fragments.intro_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zedney.rokouch.R;
import com.zedney.rokouch.adapters.CommentsAdapter;
import com.zedney.rokouch.models.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommentsFragment extends Fragment {

    View view;
    private List<Comment> commentsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CommentsAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_comments, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.commentsList);

        mAdapter = new CommentsAdapter(commentsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();

        return view;
    }

    private void prepareMovieData() {
        Comment comment = new Comment("Mad Max: Fury Road", "Action & Adventure", "2015", "Salwa", "24");
        commentsList.add(comment);

        comment = new Comment("Mad Max: Fury Road", "Action & Adventure", "2015", "Salwa", "24");
        commentsList.add(comment);

        comment = new Comment("Mad Max: Fury Road", "Action & Adventure", "2015", "Salwa", "24");
        commentsList.add(comment);

        comment = new Comment("Mad Max: Fury Road", "Action & Adventure", "2015", "Salwa", "24");
        commentsList.add(comment);

        comment = new Comment("Mad Max: Fury Road", "Action & Adventure", "2015", "Salwa", "24");
        commentsList.add(comment);


        mAdapter.notifyDataSetChanged();
    }

}
