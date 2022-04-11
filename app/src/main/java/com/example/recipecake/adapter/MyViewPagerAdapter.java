package com.example.recipecake.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.recipecake.fragment.AccountFragment;
import com.example.recipecake.fragment.FavoriteFragment;
import com.example.recipecake.fragment.HomeFragment;
import com.example.recipecake.fragment.NewRecipeFragment;
import com.example.recipecake.fragment.SearchFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new SearchFragment();
            case 2:
                return new NewRecipeFragment();
            case 3:
                return new FavoriteFragment();
            case 4:
                return new AccountFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
