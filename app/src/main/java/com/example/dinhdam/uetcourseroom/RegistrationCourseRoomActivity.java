package com.example.dinhdam.uetcourseroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrationCourseRoomActivity extends AppCompatActivity {


    private Button btnCancel;
    private Button btnEnroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_course_room);


        btnCancel = findViewById(R.id.rcrBtnCancel);
        btnEnroll = findViewById(R.id.rcrBtnEnroll);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnEnroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrationCourseRoomActivity.this, LectureActivity.class);
                startActivity(intent);
            }
        });
    }
}
