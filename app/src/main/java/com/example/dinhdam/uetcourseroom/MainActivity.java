package com.example.dinhdam.uetcourseroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dinhdam.uetcourseroom.adapter.AdapterCourseRoom;
import com.example.dinhdam.uetcourseroom.model.CourseRoom;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView recyclerViewCourseRoom;
    private ArrayList<CourseRoom> listCourseRoom;
    private AdapterCourseRoom adapterCourseRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");

        recyclerViewCourseRoom = findViewById(R.id.recyclerCourseRoom);
        initArrayListCourseRoom();
        initRecyclerViewCourseRoom();
    }

    private void initArrayListCourseRoom(){
        Log.d(TAG, "initArrayListCourseRoom: started");
        listCourseRoom = new ArrayList<>();
        listCourseRoom.add(new CourseRoom("Toán", "Admin", R.drawable.icons8_math_96, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Ngôn ngữ", "Admin", R.drawable.icons8_language_80, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Mạng", "Admin", R.drawable.icons8_internet_100, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Toán trẻ em", "Admin", R.drawable.toan_tre_em, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Tiếng Anh cho trẻ", "Admin", R.drawable.tieng_anh_tre_em, "Toán đơn giản cho trẻ em"));


    }

    private void initRecyclerViewCourseRoom(){
        Log.d(TAG, "initRecyclerViewCourseRoom: started");

        adapterCourseRoom = new AdapterCourseRoom(this, listCourseRoom);
        recyclerViewCourseRoom.setAdapter(adapterCourseRoom);
        recyclerViewCourseRoom.setLayoutManager(new LinearLayoutManager(this));
    }


}
