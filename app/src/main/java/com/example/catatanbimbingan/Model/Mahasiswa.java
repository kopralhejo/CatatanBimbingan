package com.example.catatanbimbingan.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Mahasiswa {
    @SerializedName("id")
    private String id;
    @SerializedName("nim")
    private String nim;
    @SerializedName("nama")
    private String nama;
    @SerializedName("hp")
    private String hp;
    @SerializedName("prodi")
    private String prodi;
    @SerializedName("angkatan")
    private String angkatan;
    @SerializedName("jumlahbimbingan")
    private String jumlahbimbingan;
    @SerializedName("tanggal")
    private String tanggal;

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public String getJumlahbimbingan() {
        return jumlahbimbingan;
    }

    public void setJumlahbimbingan(String jumlahbimbingan) {
        this.jumlahbimbingan = jumlahbimbingan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
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