package com.example.recipecake.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipecake.R;
import com.example.recipecake.adapter.CakeRowAdapter;
import com.example.recipecake.models.Cake;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {
    private View mView;

    private RecyclerView mRCVCakeRow;
    private CakeRowAdapter cakeRowAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_favorite, container, false);

        getViews();

        initCakeRow();

        return mView;
    }


    private void initCakeRow() {
        cakeRowAdapter = new CakeRowAdapter(getContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        mRCVCakeRow.setLayoutManager(gridLayoutManager);

        List<Cake> listCake = new ArrayList<>();
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        cakeRowAdapter.setData(listCake);

        mRCVCakeRow.setAdapter(cakeRowAdapter);
    }

    private void getViews() {
        mRCVCakeRow = mView.findViewById(R.id.rcv_cakeFavorite);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(cakeRowAdapter != null)
            cakeRowAdapter.release();
    }
}
