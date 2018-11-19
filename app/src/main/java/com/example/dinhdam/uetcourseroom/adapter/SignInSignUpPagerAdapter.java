package com.example.dinhdam.uetcourseroom.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.dinhdam.uetcourseroom.fragment.SignInFragment;
import com.example.dinhdam.uetcourseroom.fragment.SignUpFragment;

public class SignInSignUpPagerAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = "SignInSignUpPagerAdapte";

    private int count;

    public SignInSignUpPagerAdapter(FragmentManager fm, int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "Fragment getItem: "+position);
        switch (position){
            case 0:{
                return new SignInFragment();
            }
            case 1:{
                return new SignUpFragment();
            }
            default:{
                return new SignUpFragment();
            }
        }
    }



    @Override
    public int getCount() {
        return count;
    }
}
