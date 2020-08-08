package com.example.catatanbimbingan.RestApi;

import com.example.catatanbimbingan.Model.Mahasiswa;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMahasiswa {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Mahasiswa> listDataKontak;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Mahasiswa> getListDataKontak() {
        return listDataKontak;
    }

    public void setListDataKontak(List<Mahasiswa> listDataKontak) {
        this.listDataKontak = listDataKontak;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
