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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipecake.CakeDetailActivity;
import com.example.recipecake.R;
import com.example.recipecake.models.Cake;

import java.util.List;

public class CakePopularAdapter extends RecyclerView.Adapter<CakePopularAdapter.CakePopularViewHolder> {

    private Context context;
    private List<Cake> list;

    public CakePopularAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Cake> listCake){
        list = listCake;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CakePopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cake, parent, false);
        return new  CakePopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CakePopularViewHolder holder, int position) {
        Cake cake = list.get(position);
        if (cake == null){
            return;
        }

        holder.mImageView.setImageResource(R.drawable.cakebg);
        holder.txtName.setText("Cake name");
        holder.txtAuthor.setText("Cake author");
        holder.txtTime.setText("20 Min");
        holder.cbFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show();
            }
        });

        holder.cardViewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CakeDetailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("cakeItem", cake);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

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

    public class CakePopularViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView txtName, txtAuthor, txtTime;
        private CheckBox cbFavorite;
        private CardView cardViewItem;

        public CakePopularViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_imgCakePopular);
            txtName = itemView.findViewById(R.id.txt_cakePopularName);
            txtAuthor = itemView.findViewById(R.id.txt_cakePopularAuthor);
            txtTime = itemView.findViewById(R.id.txt_cakePopularTime);
            cbFavorite = itemView.findViewById(R.id.cb_favoritePopular);
            cardViewItem = itemView.findViewById(R.id.cv_itemCakePopular);
        }
    }
}
