package com.example.app1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPageAdapter extends FragmentPagerAdapter {
    public MyPageAdapter(FragmentManager fm){super(fm);}
    @Override
    public Fragment getItem(int position) {
        if (position==0)
            return  new fragment_first();
        else
            return new fragment_se();
    }

    @Override
    public int getCount() {
        return 2;
    }
}
