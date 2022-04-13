package com.example.recipecake.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.recipecake.CakeListActivity;
import com.example.recipecake.R;
import com.example.recipecake.adapter.CakeCategoryAdapter;
import com.example.recipecake.adapter.CakeFeatureAdapter;
import com.example.recipecake.adapter.CakePopularAdapter;
import com.example.recipecake.models.Cake;
import com.example.recipecake.models.Category;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private View mView;
    private ImageSlider mImagesSlider;

    private TextView btnSeeAll;

    private RecyclerView mRCVCakeFeature;
    private RecyclerView mRCVCakeCategory;
    private RecyclerView mRCVCakePopular;

    private CakeFeatureAdapter cakeFeatureAdapter;
    private CakeCategoryAdapter cakeCategoryAdapter;
    private CakePopularAdapter cakePopularAdapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_home, container, false);

        getViews();

        initSlider();

        initCakeFeature();

        initCakeCategory();

        initCakePopular();

        onClickSeeAll();
        return mView;
    }

    private void onClickSeeAll(){
        btnSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), CakeListActivity.class);
                startActivity(i);
            }
        });
    }

    private void initCakePopular() {
        cakePopularAdapter = new CakePopularAdapter(getContext());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        mRCVCakePopular.setLayoutManager(gridLayoutManager);

        List<Cake> listCake = new ArrayList<>();
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        cakePopularAdapter.setData(listCake);

        mRCVCakePopular.setAdapter(cakePopularAdapter);
    }

    private void initCakeCategory() {
        cakeCategoryAdapter = new CakeCategoryAdapter(getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        mRCVCakeCategory.setLayoutManager(linearLayoutManager);

        List<Category> listCategory = new ArrayList<>();
        listCategory.add(new Category());
        listCategory.add(new Category());
        listCategory.add(new Category());
        listCategory.add(new Category());
        listCategory.add(new Category());
        listCategory.add(new Category());
        cakeCategoryAdapter.setData(listCategory);

        mRCVCakeCategory.setAdapter(cakeCategoryAdapter);
    }

    private void initCakeFeature() {
        cakeFeatureAdapter = new CakeFeatureAdapter(getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        mRCVCakeFeature.setLayoutManager(linearLayoutManager);

        List<Cake> listCake = new ArrayList<>();
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        listCake.add(new Cake());
        cakeFeatureAdapter.setData(listCake);

        mRCVCakeFeature.setAdapter(cakeFeatureAdapter);
    }

    private void getViews(){
        mImagesSlider = mView.findViewById(R.id.image_slider);
        mRCVCakeFeature = mView.findViewById(R.id.rcv_cakeFeature);
        mRCVCakeCategory = mView.findViewById(R.id.rcv_cakeCategory);
        mRCVCakePopular = mView.findViewById(R.id.rcv_cakePopular);

        btnSeeAll = mView.findViewById(R.id.btn_seeAllPopular);
    }

    private void initSlider(){
        List<SlideModel> list = new ArrayList<>();
        list.add(new SlideModel(R.drawable.cakebg,"Find your favorite cake", ScaleTypes.CENTER_CROP));
        list.add(new SlideModel(R.drawable.cakebg, "Better experience with mobile app", ScaleTypes.CENTER_CROP));

        mImagesSlider.setImageList(list);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (cakeFeatureAdapter != null){
            cakeFeatureAdapter.release();
        }
        if (cakeCategoryAdapter != null){
            cakeCategoryAdapter.release();
        }
        if (cakePopularAdapter != null){
            cakePopularAdapter.release();
        }
    }
}
