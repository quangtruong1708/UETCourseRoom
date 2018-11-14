package com.example.dinhdam.uetcourseroom.model;

public class CourseRoom {
    private int id;
    private String name;
    private String authorName;
    private int avatarID;
    private String describe;
    private float reviewPoint;
    private int progressPoint;

    public CourseRoom(String name, String authorName, int avatarID, String describe) {
        this.name = name;
        this.authorName = authorName;
        this.avatarID = avatarID;
        this.describe = describe;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAvatarID() {
        return avatarID;
    }

    public void setAvatarID(int avatarID) {
        this.avatarID = avatarID;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public float getReviewPoint() {
        return reviewPoint;
    }

    public void setReviewPoint(float reviewPoint) {
        this.reviewPoint = reviewPoint;
    }

    public int getProgressPoint() {
        return progressPoint;
    }

    public void setProgressPoint(int progressPoint) {
        this.progressPoint = progressPoint;
    }
}
