package com.example.catatanbimbingan.RestApi;

import com.example.catatanbimbingan.Model.Mahasiswa;
import com.google.gson.annotations.SerializedName;

public class PostPutDelMahasiswa {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Mahasiswa mKontak;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Mahasiswa getmKontak() {
        return mKontak;
    }

    public void setmKontak(Mahasiswa mKontak) {
        this.mKontak = mKontak;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
