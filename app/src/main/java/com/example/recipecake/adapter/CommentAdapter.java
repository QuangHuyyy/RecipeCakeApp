package com.example.recipecake.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipecake.R;
import com.example.recipecake.models.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private Context context;
    private List<Comment> list;

    public CommentAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Comment> listComment){
        list = listComment;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new CommentAdapter.CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentViewHolder holder, int position) {
        Comment cake = list.get(position);
        if (cake == null){
            return;
        }

        holder.mImageView.setImageResource(R.drawable.cakebg);
        holder.txtName.setText("Comment name");
        holder.txtContent.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");

    }

    public void release(){
        context = null;
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView txtName, txtContent;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_imgUserComment);
            txtName = itemView.findViewById(R.id.txt_nameComment);
            txtContent = itemView.findViewById(R.id.txt_contentComment);
        }
    }
}

