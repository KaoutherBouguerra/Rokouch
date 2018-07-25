package com.zedney.rokouch.adapters;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zedney.rokouch.R;
import com.zedney.rokouch.models.Comment;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.MyViewHolder> {

    private List<Comment> commentsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView user_name, date, comment_desc;

        public MyViewHolder(View view) {
            super(view);
            user_name = (TextView) view.findViewById(R.id.user_name);
            date = (TextView) view.findViewById(R.id.date);
            comment_desc = (TextView) view.findViewById(R.id.comment_desc);
        }
    }


    public CommentsAdapter(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comment_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Comment comment = commentsList.get(position);
        holder.user_name.setText(comment.getUserName());
        holder.date.setText(comment.getDate());
        holder.comment_desc.setText(comment.getDesc());
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

}
