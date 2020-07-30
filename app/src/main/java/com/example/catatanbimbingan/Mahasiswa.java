package com.example.catatanbimbingan;

import java.util.Date;

public class Mahasiswa {
    public String nama, nim, hp, jurusan, angkatan;
    public Integer jmlbimbingan;
    public String tanggal;

    public Mahasiswa(String nama, String nim, String hp, String jurusan, String angkatan, Integer jmlbimbingan, String tanggal) {
        this.nama = nama;
        this.nim = nim;
        this.hp = hp;
        this.jurusan = jurusan;
        this.angkatan = angkatan;
        this.jmlbimbingan = jmlbimbingan;
        this.tanggal = tanggal;
    }
}