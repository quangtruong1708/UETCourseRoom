package com.example.dinhdam.uetcourseroom.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dinhdam.uetcourseroom.R;
import com.example.dinhdam.uetcourseroom.activity.RegistrationCourseRoomActivity;
import com.example.dinhdam.uetcourseroom.model.CourseRoom;

import java.util.ArrayList;


public class AdapterCourseRoom extends RecyclerView.Adapter<AdapterCourseRoom.MyViewHolder> {

    private static final String TAG = "AdapterCourseRoom";

    private Context context;
    private ArrayList<CourseRoom> listCourseRoom;

    public AdapterCourseRoom(Context context, ArrayList<CourseRoom> listCourseRoom) {
        Log.d(TAG, "AdapterCourseRoom: created");

        this.context = context;
        this.listCourseRoom = listCourseRoom;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d(TAG, "onCreateViewHolder: started");

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_course_room_list, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called.");

        myViewHolder.mCourseRoomName.setText(listCourseRoom.get(i).getName());
        myViewHolder.mAuthorName.setText(listCourseRoom.get(i).getAuthorName());
        myViewHolder.mAvatarIcon.setImageResource(listCourseRoom.get(i).getAvatarID());

        myViewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Clicked "+listCourseRoom.get(i).getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, RegistrationCourseRoomActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + listCourseRoom.size());
        return listCourseRoom.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mCourseRoomName;
        TextView mAuthorName;
        ImageView mAvatarIcon;
        RelativeLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mCourseRoomName = itemView.findViewById(R.id.tv_item_course_room_name);
            mAuthorName = itemView.findViewById(R.id.tv_item_course_room_author);
            mAvatarIcon = itemView.findViewById(R.id.iv_item_avatar_icon);
            parentLayout = itemView.findViewById(R.id.layout_item_view_course_room);
            Log.d(TAG, "ViewHolder: created");
        }
    }

}
