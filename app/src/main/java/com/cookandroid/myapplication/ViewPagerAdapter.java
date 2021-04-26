package com.cookandroid.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


//    public ViewPagerAdapter(@NonNull FragmentManager fm) {
//        super(fm);
//    }

    // 프래그먼트를 교체를 보여주는 처리를 구현한 곳
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return VPFragMonday.newInstance();
//            case 1:
//                return VPFragTuesday.newInstance();
//            case 2:
//                return VPFragWednesday.newInstance();
//            default:
//                return null;
//        }
//    }

//    @Override
//    public int getCount() {
//        return 3;
//    }
//
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position) {
//            case 0:
//                return "Monday";
//            case 1:
//                return "Tuesday";
//            case 2:
//                return "Wednesday";
//            default:
//                return null;
//        }
//    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return VPFragMonday.newInstance();
            case 1:
                return VPFragTuesday.newInstance();
            case 2:
                return VPFragWednesday.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
