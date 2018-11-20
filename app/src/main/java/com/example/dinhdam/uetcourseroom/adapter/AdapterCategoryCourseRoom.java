package com.example.dinhdam.uetcourseroom.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dinhdam.uetcourseroom.R;
import com.example.dinhdam.uetcourseroom.model.CategoryCourseRoom;

import java.util.ArrayList;

public class AdapterCategoryCourseRoom extends RecyclerView.Adapter<AdapterCategoryCourseRoom.CateViewHolder> {

    private static final String TAG = "AdapterCategoryCourseRo";

    private Context context;
    private ArrayList<CategoryCourseRoom> listCategoryCourseRoom;

    public AdapterCategoryCourseRoom(Context context, ArrayList<CategoryCourseRoom> listCategoryCourseRoom) {
        this.context = context;
        this.listCategoryCourseRoom = listCategoryCourseRoom;
    }

    @NonNull
    @Override
    public CateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_course_category_horizontal_list, parent, false);
        CateViewHolder cateViewHolder = new CateViewHolder(view);
        return cateViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CateViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");

        CategoryCourseRoom categoryCourseRoom = listCategoryCourseRoom.get(position);

        holder.imgImageIcon.setBackgroundResource(categoryCourseRoom.getImageIcon());
        holder.tvCategoryName.setText(categoryCourseRoom.getName());
    }

    @Override
    public int getItemCount() {
        return listCategoryCourseRoom.size();
    }

    class CateViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "CateViewHolder";

        TextView tvCategoryName;
        ImageView imgImageIcon;

        public CateViewHolder(View itemView) {
            super(itemView);
            Log.d(TAG, "CateViewHolder: constructor");
            tvCategoryName = itemView.findViewById(R.id.tvCategoryNameItemCourseHorVerList);
            imgImageIcon = itemView.findViewById(R.id.imgCategoryItemCourseHorVerList);
        }
    }
}
