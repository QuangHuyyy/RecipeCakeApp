package com.example.recipecake.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.recipecake.fragment.CommentFragment;
import com.example.recipecake.fragment.DescriptionFragment;

public class ViewPager2DetailAdapter extends FragmentStateAdapter {
    public ViewPager2DetailAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new  DescriptionFragment();
            case 1:
                return new CommentFragment();
            default:
                return new DescriptionFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
