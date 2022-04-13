package com.example.recipecake.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.recipecake.R;

import java.util.ArrayList;
import java.util.List;

public class DescriptionFragment extends Fragment {
    private View mView;

    private ListView mListViewIngredient, mListViewDirection;
    private List<String> listIngredients = new ArrayList<>();
    private List<String> listDirection = new ArrayList<>();

    private ArrayAdapter<String> adapterIngredients;
    private ArrayAdapter<String> adapterDirection;
    public DescriptionFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_description, container, false);

        getViews();

        getList();

        adapterIngredients = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, listIngredients);
        adapterDirection = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, listDirection);

        mListViewIngredient.setAdapter(adapterIngredients);
        mListViewDirection.setAdapter(adapterDirection);


        return mView;
    }

    private void getList() {
        listIngredients.add("Ingredients 1");
        listIngredients.add("Ingredients 2");
        listIngredients.add("Ingredients 3");
        listIngredients.add("Ingredients 4");
        listIngredients.add("Ingredients 5");

        listDirection.add("Direction 1");
        listDirection.add("Direction 2");
        listDirection.add("Direction 3");
        listDirection.add("Direction 4");
        listDirection.add("Direction 5");
        listDirection.add("Direction 6");
    }

    private void getViews() {
        mListViewIngredient = mView.findViewById(R.id.lv_ingredients);
        mListViewDirection = mView.findViewById(R.id.lv_directions);
    }

}