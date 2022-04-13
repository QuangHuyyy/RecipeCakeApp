package com.example.recipecake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.recipecake.adapter.ViewPager2DetailAdapter;
import com.example.recipecake.models.Cake;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CakeDetailActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private Toolbar toolbar;
    private ViewPager2DetailAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cake_detail);

        getViews();

        mViewPagerAdapter = new ViewPager2DetailAdapter(this);

        mViewPager2.setAdapter(mViewPagerAdapter);
        new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Description");
                        break;
                    case 1:
                        tab.setText("Comments");
                        break;
                }
            }
        }).attach();

        Bundle bundle = getIntent().getExtras();

        if (bundle == null)
            return;
        Cake cake = (Cake) bundle.get("cakeItem");


        onClickBack();

    }

    private void onClickBack(){
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CakeDetailActivity.this, "huhu", Toast.LENGTH_SHORT).show();
                CakeDetailActivity.this.finish();
            }
        });
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void getViews() {
        toolbar = findViewById(R.id.toolbarDetail);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager2 = findViewById(R.id.viewPager2Detail);
    }
}