package com.example.dinhdam.uetcourseroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dinhdam.uetcourseroom.model.Chapter;
import com.example.dinhdam.uetcourseroom.model.Lecture;

import java.util.ArrayList;

public class LectureActivity extends AppCompatActivity {

    private static final String TAG = "LectureActivity";

    private Lecture lecture;
    private ArrayList<Chapter> listChapter;

    private TextView tvLectureTitle;
    private TextView tvChapterBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        tvLectureTitle = findViewById(R.id.tvLectureTitle);
        tvChapterBody = findViewById(R.id.tvChapterBody);

        initListChapter();
        initLecture();

        tvLectureTitle.setText(lecture.getTitle());
        for(int i = 0; i < lecture.getListChapter().size(); i++){
            Chapter chapter = lecture.getListChapter().get(i);
            tvChapterBody.append(chapter.getTittle()+"\n");
            tvChapterBody.append(chapter.getBody()+"\n");
        }
    }

    private void initListChapter(){
        listChapter = new ArrayList<>();
        listChapter.add(new Chapter("Title chapter 1", "Body chapter 1"));
        listChapter.add(new Chapter("Title chapter 2", "Body chapter 2 Body chapter 2 Body chapter 2 Body chapter 2 Body chapter 2 Body chapter 2"));
        listChapter.add(new Chapter("Title chapter 3", "Body chapter 3 Body chapter 3 Body chapter 3 Body chapter 3 Body chapter 3 Body chapter 3 Body chapter 3 Body chapter 3 Body chapter 3 Body chapter 3 Body chapter 3 Body chapter 3 "));
        listChapter.add(new Chapter("Title chapter 4", "Body chapter 4 Body chapter 4 Body chapter 4 Body chapter 4 Body chapter 4 "));
        listChapter.add(new Chapter("Title chapter 5 Title chapter 5 Title chapter 5 Title chapter 5 Title chapter 5", "Body chapter 5"));
    }

    private void initLecture(){
        lecture = new Lecture("Title lecture 1", listChapter);
    }
}
