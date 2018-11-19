package com.example.dinhdam.uetcourseroom;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.dinhdam.uetcourseroom.adapter.SignInSignUpPagerAdapter;

public class SignInSignUpActivity extends AppCompatActivity {

    private static final String TAG = "SignInSignUpActivity";

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FragmentStatePagerAdapter viewPagerAdapter;
    private final int FRAGMENT_COUNT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_sign_up);


        tabLayout = findViewById(R.id.signInSignUpTabLayout);
        viewPager = findViewById(R.id.signInSignUpViewPager);
        viewPagerAdapter = new SignInSignUpPagerAdapter(getSupportFragmentManager(), FRAGMENT_COUNT);
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tabLayout.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.d(TAG, "onTabSelected: "+tab.getPosition());
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
