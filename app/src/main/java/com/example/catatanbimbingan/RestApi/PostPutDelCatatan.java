package com.example.catatanbimbingan.RestApi;

import com.example.catatanbimbingan.Model.Catatan;
import com.google.gson.annotations.SerializedName;

public class PostPutDelCatatan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Catatan mKontak;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Catatan getmKontak() {
        return mKontak;
    }

    public void setmKontak(Catatan mKontak) {
        this.mKontak = mKontak;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
