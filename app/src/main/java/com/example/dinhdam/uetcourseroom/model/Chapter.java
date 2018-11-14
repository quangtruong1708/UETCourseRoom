package com.example.dinhdam.uetcourseroom.model;

public class Chapter {
    private int id;
    private String tittle;
    private String body;

    public Chapter(String tittle, String body) {
        this.tittle = tittle;
        this.body = body;
    }

    public Chapter(int id, String tittle, String body) {
        this.id = id;
        this.tittle = tittle;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
