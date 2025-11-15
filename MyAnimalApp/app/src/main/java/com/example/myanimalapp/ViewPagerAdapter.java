package com.example.myanimalapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return AnimalFragment.newInstance("VERTICAL"); // Tab 0
            case 1:
                return AnimalFragment.newInstance("HORIZONTAL"); // Tab 1
            case 2:
                return AnimalFragment.newInstance("GRID"); // Tab 2
            default:
                return AnimalFragment.newInstance("VERTICAL");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
