package com.example.catatanbimbingan.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Catatan {
    @SerializedName("id")
    private String id;
    @SerializedName("judul")
    private String judul;
    @SerializedName("nim")
    private String nim;
    @SerializedName("bimbingan")
    private Integer bimbingan;
    @SerializedName("catatan")
    private String catatan;
    @SerializedName("tanggal")
    private Date tanggal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public Integer getBimbingan() {
        return bimbingan;
    }

    public void setBimbingan(Integer bimbingan) {
        this.bimbingan = bimbingan;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }
}

//
//    public String nama, nim, hp, jurusan, angkatan;
//    public Integer jmlbimbingan;
//    public String tanggal;
//
//    public Mahasiswa(String nama, String nim, String hp, String jurusan, String angkatan, Integer jmlbimbingan, String tanggal) {
//        this.nama = nama;
//        this.nim = nim;
//        this.hp = hp;
//        this.jurusan = jurusan;
//        this.angkatan = angkatan;
//        this.jmlbimbingan = jmlbimbingan;
//        this.tanggal = tanggal;
//    }
//}