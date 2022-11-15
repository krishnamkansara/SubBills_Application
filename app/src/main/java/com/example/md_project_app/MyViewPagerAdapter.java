package com.example.md_project_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.md_project_app.fragments.Bills_fragment1;
import com.example.md_project_app.fragments.Sub_fragment1;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
         switch (position){
             case 0:
                 return new Bills_fragment1();
             case 1:
                 return new Sub_fragment1();
             default:
                 return new Bills_fragment1();
         }
    }
    @Override
    public int getItemCount() {
        return 2;
    }
}
