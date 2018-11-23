package com.example.dinhdam.uetcourseroom.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dinhdam.uetcourseroom.R;
import com.example.dinhdam.uetcourseroom.adapter.AdapterCategoryAndCourse;
import com.example.dinhdam.uetcourseroom.adapter.AdapterCategoryCourseRoom;
import com.example.dinhdam.uetcourseroom.adapter.AdapterCourseRoom;
import com.example.dinhdam.uetcourseroom.model.CategoryCourseRoom;
import com.example.dinhdam.uetcourseroom.model.CourseRoom;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView recyclerViewCourseRoom;
    private ArrayList<CourseRoom> listCourseRoom;
    private AdapterCourseRoom adapterCourseRoom;

    private ArrayList<CategoryCourseRoom> listCategoryCourseRoomArray;
    private RecyclerView recViewCourseRoomCategory;
    private AdapterCategoryCourseRoom adapterCategoryCourseRoom;

    private AdapterCategoryAndCourse adapterCategoryAndCourse;
    private RecyclerView recyclerViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");

        //recyclerViewCourseRoom = findViewById(R.id.recyclerCourseRoom);
        recViewCourseRoomCategory = findViewById(R.id.recViewCategoryMain);
        recyclerViewMain = findViewById(R.id.recyclerViewMain);

//        initArrayListCourseRoom();
//        initRecyclerViewCourseRoom();

        initArrayListCourseRoomCategory();
        initRecylerViewCourseRoomCategory();

        initRecyclerViewMain();
    }

    private void initArrayListCourseRoom(){
        Log.d(TAG, "initArrayListCourseRoom: started");
        listCourseRoom = new ArrayList<>();
        listCourseRoom.add(new CourseRoom("Toán", "Admin", R.drawable.technology_icon, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Ngôn ngữ", "Admin", R.drawable.icons8_language_80, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Mạng", "Admin", R.drawable.icons8_internet_100, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Toán trẻ em", "Admin", R.drawable.toan_tre_em, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Tiếng Anh cho trẻ", "Admin", R.drawable.tieng_anh_tre_em, "Toán đơn giản cho trẻ em"));


    }

    private void initRecyclerViewCourseRoom(){
        Log.d(TAG, "initRecyclerViewCourseRoom: started");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        adapterCourseRoom = new AdapterCourseRoom(this, listCourseRoom);
        recyclerViewCourseRoom.setAdapter(adapterCourseRoom);

        recyclerViewCourseRoom.setLayoutManager(layoutManager);
    }

    private void initArrayListCourseRoomCategory(){
        Log.d(TAG, "initArrayListCourseRoomCategory: started");

        listCategoryCourseRoomArray = new ArrayList<>();
        listCategoryCourseRoomArray.add(new CategoryCourseRoom("Trí tuệ nhân tạo", R.drawable.ai_icon));
        listCategoryCourseRoomArray.add(new CategoryCourseRoom("Công nghệ phần mềm", R.drawable.soft_engineering_icon));
        listCategoryCourseRoomArray.add(new CategoryCourseRoom("Toán học", R.drawable.mathematics_icon));
        listCategoryCourseRoomArray.add(new CategoryCourseRoom("Ngôn ngữ", R.drawable.language_icon));
        listCategoryCourseRoomArray.add(new CategoryCourseRoom("Kỹ thuật", R.drawable.engineering_icon));
        listCategoryCourseRoomArray.add(new CategoryCourseRoom("Y tế", R.drawable.medicine_icon));
        listCategoryCourseRoomArray.add(new CategoryCourseRoom("Thiết kế", R.drawable.design_icon));
        listCategoryCourseRoomArray.add(new CategoryCourseRoom("Kinh doanh", R.drawable.business_icon));
    }

    private void initRecylerViewCourseRoomCategory(){
        Log.d(TAG, "initRecylerViewCourseRoomCategory: started");

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);

        adapterCategoryCourseRoom = new AdapterCategoryCourseRoom(this, listCategoryCourseRoomArray);
        recViewCourseRoomCategory.setAdapter(adapterCategoryCourseRoom);
        recViewCourseRoomCategory.setLayoutManager(layoutManager);
    }


    private void initRecyclerViewMain(){
        Log.d(TAG, "initRecyclerViewCourseRoom: started");

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);

        adapterCategoryAndCourse = new AdapterCategoryAndCourse(this, listCategoryCourseRoomArray);
        recyclerViewMain.setAdapter(adapterCategoryAndCourse);
        recyclerViewMain.setLayoutManager(layoutManager);
    }
}

