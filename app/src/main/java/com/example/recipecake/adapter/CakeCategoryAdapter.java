package com.example.recipecake.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipecake.CakeListActivity;
import com.example.recipecake.R;
import com.example.recipecake.models.Cake;
import com.example.recipecake.models.Category;

import java.util.List;

public class CakeCategoryAdapter extends RecyclerView.Adapter<CakeCategoryAdapter.CakeCategoryViewHolder> {

    private Context context;
    private List<Category> list;

    public CakeCategoryAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Category> listCategory){
        list = listCategory;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CakeCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cake_category, parent, false);

        return new CakeCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CakeCategoryViewHolder holder, int position) {
        Category category = list.get(position);
        if(category == null)
            return;

        holder.txtCategoryName.setText("Category " + position);
        holder.cardViewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CakeListActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("cakeCategory", category);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list != null){
            return list.size();
        }
        return 0;
    }

    public void release(){
        context = null;
    }

    public class CakeCategoryViewHolder extends RecyclerView.ViewHolder{
        private CardView cardViewCategory;
        private TextView txtCategoryName;

        public CakeCategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCategoryName = itemView.findViewById(R.id.txt_cakeCategory);
            cardViewCategory = itemView.findViewById(R.id.cv_itemCakeCategory);
        }
    }
}
