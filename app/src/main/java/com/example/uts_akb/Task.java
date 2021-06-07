package com.example.uts_akb;

public class Task {
    private String id;
    private String judul;
    private String kategori;
    private String date;
    private String isi;

    public Task(String id, String judul, String kategori, String date, String isi) {
        this.id = id;
        this.judul = judul;
        this.kategori = kategori;
        this.date = date;
        this.isi = isi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}

