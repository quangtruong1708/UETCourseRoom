package com.example.dinhdam.uetcourseroom.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.dinhdam.uetcourseroom.R;
import com.example.dinhdam.uetcourseroom.activity.SignInSignUpActivity;
import com.example.dinhdam.uetcourseroom.model.Account;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class SignUpFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "SignUpFragment";
    private TextView tvDangNhap;
    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnSignUp;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private long key;
    private DatabaseReference reference;
    private FirebaseDatabase database;
    private static SignUpFragment sefl;


    public static SignUpFragment getInstance() {
        if (sefl == null) {
            sefl = new SignUpFragment();
        }
        return sefl;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: created");
        return inflater.inflate(R.layout.fragment_sign_up, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }


    private void initViews() {
        tvDangNhap = getActivity().findViewById(R.id.tv_dang_nhap);
        edtUserName = getActivity().findViewById(R.id.edt_user_name_sign_up);
        edtPassword = getActivity().findViewById(R.id.edt_pass_word_sign_up);
        btnSignUp = getActivity().findViewById(R.id.sisoBtnSignUp);
        btnSignUp.setOnClickListener(this);
        tvDangNhap.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("account");
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

//        BottomNavigationView bottom = getActivity().findViewById(R.id.btt_bottom_navigation);
//        bottom.setOnNavigationItemSelectedListener(navigationItem);
    }


//    private BottomNavigationView.OnNavigationItemSelectedListener navigationItem =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                    switch (item.getItemId()) {
//                        case R.id.nav_dang_nhap:
//                            SignInSignUpActivity signInSignUpActivity = (SignInSignUpActivity) getActivity();
//                            signInSignUpActivity.showFragment(SignInFragment.getInstance(), SignUpFragment.this);
//                            break;
//                    }
//                    return true;
//                }
//            };


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sisoBtnSignUp:
                String userName = edtUserName.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (userName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getContext(), "Vui lòng nhập đầy đủ thông tin ", Toast.LENGTH_LONG).show();
                } else {
                    key = System.currentTimeMillis();
                    reference = reference.child(key + "");
                    Account account = new Account(String.valueOf(key), userName, password);
                    reference.setValue(account);

                    SignInFragment.getInstance().getAccountSignup(userName, password);
                    SignInSignUpActivity signInSignUpActivity = (SignInSignUpActivity) getActivity();
                    signInSignUpActivity.showFragment(SignInFragment.getInstance(), SignUpFragment.getInstance());
                }
                break;

            case R.id.tv_dang_nhap:
                SignInSignUpActivity signInSignUpActivity = (SignInSignUpActivity) getActivity();
                signInSignUpActivity.showFragment(SignInFragment.getInstance(), this);
                break;
        }
    }
}
