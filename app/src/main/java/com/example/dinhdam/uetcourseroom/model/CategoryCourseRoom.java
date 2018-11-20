package com.example.dinhdam.uetcourseroom.model;

public class CategoryCourseRoom {
    private int id;
    private String name;
    private int imageIcon;

    public CategoryCourseRoom(String name, int imageIcon) {
        this.name = name;
        this.imageIcon = imageIcon;
    }

    public CategoryCourseRoom(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(int imageIcon) {
        this.imageIcon = imageIcon;
    }
}
