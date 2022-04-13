package com.example.recipecake.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipecake.CakeDetailActivity;
import com.example.recipecake.R;
import com.example.recipecake.models.Cake;

import java.util.List;

public class CakeFeatureAdapter extends RecyclerView.Adapter<CakeFeatureAdapter.CakeFeatureViewHolder> {

    private Context context;
    private List<Cake> list;

    public CakeFeatureAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Cake> listCake){
        list = listCake;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CakeFeatureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cake_feature, parent, false);
        return new  CakeFeatureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CakeFeatureViewHolder holder, int position) {
        Cake cake = list.get(position);
        if (cake == null){
            return;
        }

        holder.mImageView.setImageResource(R.drawable.cakebg);
        holder.txtName.setText("Cake name");
        holder.txtAuthor.setText("Cake author");
        holder.txtTime.setText("20 Min");

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

    public class CakeFeatureViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView txtName, txtAuthor, txtTime;
        private CardView cardViewItem;

        public CakeFeatureViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imv_imageCake);
            txtName = itemView.findViewById(R.id.txt_cakeFeatureName);
            txtAuthor = itemView.findViewById(R.id.txt_cakeFeatureAuthor);
            txtTime = itemView.findViewById(R.id.txt_cakeFeatureTime);
            cardViewItem = itemView.findViewById(R.id.cv_itemCakeFeature);
        }
    }
}
