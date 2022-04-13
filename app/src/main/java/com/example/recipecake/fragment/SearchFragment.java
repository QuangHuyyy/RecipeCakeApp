package com.example.recipecake.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipecake.R;
import com.example.recipecake.adapter.CakePopularAdapter;
import com.example.recipecake.adapter.CakeRowAdapter;
import com.example.recipecake.models.Cake;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private View mView;

    private RecyclerView mRCVCakeRow;
    private EditText edtSearchName;
    private CakeRowAdapter cakeRowAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_search, container, false);

        getViews();

        initCakeRow();

        edtSearchName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                searchRecipe(edtSearchName.getText().toString());
            }
        });


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
        edtSearchName = mView.findViewById(R.id.edt_searchCake);
        mRCVCakeRow = mView.findViewById(R.id.rcv_cakeSearch);

    }

    private void searchRecipe(String txt) {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(cakeRowAdapter != null)
            cakeRowAdapter.release();
    }
}
