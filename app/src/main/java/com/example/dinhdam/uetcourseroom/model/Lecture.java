package com.example.dinhdam.uetcourseroom.model;

import java.util.ArrayList;

public class Lecture {
    private int id;
    private String title;
    private ArrayList<Chapter> listChapter;

    public Lecture(String title, ArrayList<Chapter> listChapter) {
        this.title = title;
        this.listChapter = listChapter;
    }

    public Lecture(int id, String title, ArrayList<Chapter> listChapter) {
        this.id = id;
        this.title = title;
        this.listChapter = listChapter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Chapter> getListChapter() {
        return listChapter;
    }

    public void setListChapter(ArrayList<Chapter> listChapter) {
        this.listChapter = listChapter;
    }
}
