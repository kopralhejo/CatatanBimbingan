package com.example.catatanbimbingan.RestApi;

import com.example.catatanbimbingan.Model.Catatan;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetCatatan {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Catatan> listDataKontak;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Catatan> getListDataKontak() {
        return listDataKontak;
    }

    public void setListDataKontak(List<Catatan> listDataKontak) {
        this.listDataKontak = listDataKontak;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
