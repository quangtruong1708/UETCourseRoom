package com.example.dinhdam.uetcourseroom.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dinhdam.uetcourseroom.R;
import com.example.dinhdam.uetcourseroom.model.CategoryCourseRoom;
import com.example.dinhdam.uetcourseroom.model.CourseRoom;

import java.util.ArrayList;

public class AdapterCategoryAndCourse extends RecyclerView.Adapter<AdapterCategoryAndCourse.CateCourseViewHolder> {

    private static final String TAG = "AdapterCategoryAndCours";

    private Context context;
    private ArrayList<CategoryCourseRoom> listCategoryCourseRoom;

    public AdapterCategoryAndCourse(Context context, ArrayList<CategoryCourseRoom> listCategoryCourseRoom) {
        this.context = context;
        this.listCategoryCourseRoom = listCategoryCourseRoom;
    }

    @NonNull
    @Override
    public CateCourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");

        View view = LayoutInflater.from(context).inflate(R.layout.item_main_category_and_course_list, parent, false);

        CateCourseViewHolder cateCourseViewHolder = new CateCourseViewHolder(view);

        return cateCourseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CateCourseViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: called");

        CategoryCourseRoom categoryCourseRoom = listCategoryCourseRoom.get(position);

        holder.tvCategoryName.setText(categoryCourseRoom.getName());

        ArrayList<CourseRoom> listCourseRoom = new ArrayList<>();
        listCourseRoom.add(new CourseRoom("Toán", "Admin", R.drawable.technology_icon, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Ngôn ngữ", "Admin", R.drawable.icons8_language_80, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Mạng", "Admin", R.drawable.icons8_internet_100, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Toán trẻ em", "Admin", R.drawable.toan_tre_em, "Toán đơn giản cho trẻ em"));
        listCourseRoom.add(new CourseRoom("Tiếng Anh cho trẻ", "Admin", R.drawable.tieng_anh_tre_em, "Toán đơn giản cho trẻ em"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        AdapterCourseRoom adapterCourseRoom = new AdapterCourseRoom(context, listCourseRoom);

        holder.recyclerViewCourseRoom.setAdapter(adapterCourseRoom);
        holder.recyclerViewCourseRoom.setLayoutManager(layoutManager);
    }

    @Override
    public int getItemCount() {
        return listCategoryCourseRoom.size();
    }

    class CateCourseViewHolder extends RecyclerView.ViewHolder {

        TextView tvCategoryName;
        RecyclerView recyclerViewCourseRoom;

        public CateCourseViewHolder(View itemView) {
            super(itemView);

            tvCategoryName = itemView.findViewById(R.id.tvItemCateAndCourseName);
            recyclerViewCourseRoom = itemView.findViewById(R.id.recyclerCourseRoom);
        }
    }

}
