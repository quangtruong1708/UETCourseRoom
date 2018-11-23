package com.example.dinhdam.uetcourseroom.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dinhdam.uetcourseroom.activity.MainActivity;
import com.example.dinhdam.uetcourseroom.R;
import com.example.dinhdam.uetcourseroom.activity.SignInSignUpActivity;
import com.example.dinhdam.uetcourseroom.model.Account;
import com.google.android.gms.common.oob.SignUp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SignInFragment extends Fragment implements View.OnClickListener, ValueEventListener {
    private static final String TAG = "SignInFragment";
    private Button btnSignIn;
    private EditText edtUserName;
    private EditText edtPassword;
    private TextView tvDangky;
    private DatabaseReference reference;
    private FirebaseDatabase database;
    private static SignInFragment sefl;
    private ArrayList<Account> arrAccount = new ArrayList<>();


    public static SignInFragment getInstance() {
        if (sefl == null) {
            sefl = new SignInFragment();
        }
        return sefl;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: created");
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        edtUserName = getActivity().findViewById(R.id.edt_user_name_sign_in);
        edtPassword = getActivity().findViewById(R.id.edt_pass_word_sign_in);
        tvDangky = getActivity().findViewById(R.id.tv_dang_ky);
        btnSignIn = getActivity().findViewById(R.id.sisuBtnSignIn);
        btnSignIn.setOnClickListener(this);
        tvDangky.setOnClickListener(this);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("account");
        reference.addValueEventListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sisuBtnSignIn:
                String userName = edtUserName.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (userName.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getActivity(),
                            "Vui lòng nhập đầy đủ thông tin. ", Toast.LENGTH_LONG).show();
                } else {
                    if (isCheckAccount(userName, password) == true) {
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    } else {
                        Toast.makeText(getActivity(),
                                "Tên đăng nhập hoặc mật khẩu không chính xác. ", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case R.id.tv_dang_ky:
                SignInSignUpActivity signInSignUpActivity = (SignInSignUpActivity) getActivity();
                signInSignUpActivity.showFragment(SignUpFragment.getInstance(), this);
                break;
        }
    }

    private boolean isCheckAccount(String userName, String password) {
        for (int i = 0; i < arrAccount.size(); i++) {
            if (arrAccount.get(i).getUserName().equals(userName) &&
                    arrAccount.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        arrAccount.clear();
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            Account account = data.getValue(Account.class);
            arrAccount.add(account);
        }
    }

    public void getAccountSignup(String name, String pass) {
        edtUserName.setText(name);
        edtPassword.setText(pass);
    }


    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
