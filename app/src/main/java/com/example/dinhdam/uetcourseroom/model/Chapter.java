package com.example.dinhdam.uetcourseroom.model;

public class Chapter {
    private int id;
    private String tittle;
    private String pdfUrl;

    public Chapter(String tittle, String pdfUrl) {
        this.tittle = tittle;
        this.pdfUrl = pdfUrl;
    }

    public Chapter(int id, String tittle, String pdfUrl) {
        this.id = id;
        this.tittle = tittle;
        this.pdfUrl = pdfUrl;
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

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
