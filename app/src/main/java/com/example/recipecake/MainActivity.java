package com.example.recipecake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.recipecake.adapter.MyViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager2 mViewPager2;
    private BottomNavigationView mBottomNavigationView;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();

        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(this);
        mViewPager2.setAdapter(myViewPagerAdapter);

//        mViewPager2.setPageTransformer(new DepthPageTransformer());

        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.bottom_home:
                        mViewPager2.setCurrentItem(0);
                        break;
                    case R.id.bottom_search:
                        mViewPager2.setCurrentItem(1);
                        break;
                    case R.id.bottom_new_recipe:
                        mViewPager2.setCurrentItem(2);
                        break;
                    case R.id.bottom_favorite:
                        mViewPager2.setCurrentItem(3);
                        break;
                    case R.id.bottom_account:
                        mViewPager2.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });

        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        mNavigationView.getMenu().findItem(R.id.navigation_home).setChecked(true);
                        mBottomNavigationView.getMenu().findItem(R.id.bottom_home).setChecked(true);
                        break;
                    case 1:
                        mNavigationView.getMenu().findItem(R.id.navigation_search).setChecked(true);
                        mBottomNavigationView.getMenu().findItem(R.id.bottom_search).setChecked(true);
                        break;
                    case 2:
                        mNavigationView.getMenu().findItem(R.id.navigation_new_recipe).setChecked(true);
                        mBottomNavigationView.getMenu().findItem(R.id.bottom_new_recipe).setChecked(true);
                        break;
                    case 3:
                        mNavigationView.getMenu().findItem(R.id.navigation_favorite).setChecked(true);
                        mBottomNavigationView.getMenu().findItem(R.id.bottom_favorite).setChecked(true);
                        break;
                    case 4:
                        mNavigationView.getMenu().findItem(R.id.navigation_my_profile).setChecked(true);
                        mBottomNavigationView.getMenu().findItem(R.id.bottom_account).setChecked(true);
                        break;

                }
            }
        });
        mViewPager2.setUserInputEnabled(false);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView.setNavigationItemSelectedListener(this);

    }

    private void getViews() {
        mViewPager2 = findViewById(R.id.viewPager2);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mNavigationView = findViewById(R.id.navigation_view);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.navigation_home:
                mViewPager2.setCurrentItem(0);
                break;
            case R.id.navigation_search:
                mViewPager2.setCurrentItem(1);
                break;
            case R.id.navigation_new_recipe:
                mViewPager2.setCurrentItem(2);
                break;
            case R.id.navigation_favorite:
                mViewPager2.setCurrentItem(3);
                break;
            case R.id.navigation_my_profile:
                mViewPager2.setCurrentItem(4);
                break;
            case R.id.navigation_change_password:
                Intent i = new Intent(MainActivity.this, ChangePasswordActivity.class);
                startActivity(i);
                break;
            case R.id.navigation_sign_out:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}