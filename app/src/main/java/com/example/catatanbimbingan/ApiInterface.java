package com.example.catatanbimbingan;

import com.example.catatanbimbingan.GetMahasiswa;
import com.example.catatanbimbingan.PostPutDelMahasiswa;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("mahasiswa_android")
    Call<GetMahasiswa> getMahasiswa();
    @FormUrlEncoded
    @POST("mahasiswa")
    Call<PostPutDelMahasiswa> PostMahasiswa(
            @Field("nim") String nim,
            @Field("nama") String nama,
            @Field("hp") String hp,
            @Field("prodi") String prodi,
            @Field("angkatan") String angkatan,
            @Field("jumlahbimbingan") String jumlahbimbingan,
            @Field("tanggal") String tanggal);
    @FormUrlEncoded
    @PUT("mahasiswa")
    Call<PostPutDelMahasiswa> PutMahasiswa(
            @Field("nim") String nim,
            @Field("nama") String nama,
            @Field("hp") String hp,
            @Field("prodi") String prodi,
            @Field("angkatan") String angkatan,
            @Field("jumlahbimbingan") String jumlahbimbingan,
            @Field("tanggal") String tanggal);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "mahasiswa", hasBody = true)
    Call<PostPutDelMahasiswa> deleteMahasiswa(
            @Field("id") String id);
}
