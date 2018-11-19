package com.example.dinhdam.uetcourseroom.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dinhdam.uetcourseroom.MainActivity;
import com.example.dinhdam.uetcourseroom.R;
import com.example.dinhdam.uetcourseroom.SignInSignUpActivity;

public class SignUpFragment extends Fragment {

    private static final String TAG = "SignUpFragment";

    private Button btnSignUp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: created");
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        btnSignUp = view.findViewById(R.id.sisoBtnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }
}
