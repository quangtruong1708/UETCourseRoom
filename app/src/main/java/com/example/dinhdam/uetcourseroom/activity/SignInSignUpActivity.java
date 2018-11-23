package com.example.dinhdam.uetcourseroom.activity;

import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.dinhdam.uetcourseroom.R;
import com.example.dinhdam.uetcourseroom.fragment.SignInFragment;
import com.example.dinhdam.uetcourseroom.fragment.SignUpFragment;

public class SignInSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_sign_up);


//        BottomNavigationView bottom = findViewById(R.id.btt_bottom_navigation);
//        bottom.setOnNavigationItemSelectedListener(navigationItem);


        initFragment();
    }


//    private BottomNavigationView.OnNavigationItemSelectedListener navigationItem =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    Fragment select = new SignInFragment();
//
//                    switch (item.getItemId()) {
//                        case R.id.nav_dang_nhap:
//                            select = new SignInFragment();
//                            break;
//                        case R.id.nav_dang_ky:
//                            select = new SignUpFragment();
//                            break;
//                    }
//
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.frm_pannel, select).commit();
//
//
//                    return true;
//                }
//            };

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frm_pannel, SignInFragment.getInstance());
        transaction.add(R.id.frm_pannel, SignUpFragment.getInstance());
        transaction.hide(SignUpFragment.getInstance());
        transaction.commit();
    }

    public void showFragment(Fragment frShow, Fragment frHide) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        transaction.show(frShow);
        transaction.hide(frHide);
        transaction.commit();
    }
}

