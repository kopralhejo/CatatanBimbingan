package com.example.catatanbimbingan;

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
    private Integer hp;
    @SerializedName("prodi")
    private String prodi;
    @SerializedName("angkatan")
    private Integer angkatan;
    @SerializedName("jumlahbimbingan")
    private Integer jumlahbimbingan;
    @SerializedName("tanggal")
    private Date tanggal;

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
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

    public Integer getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(Integer angkatan) {
        this.angkatan = angkatan;
    }

    public Integer getJumlahbimbingan() {
        return jumlahbimbingan;
    }

    public void setJumlahbimbingan(Integer jumlahbimbingan) {
        this.jumlahbimbingan = jumlahbimbingan;
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