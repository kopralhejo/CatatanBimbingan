package com.example.catatanbimbingan.RestApi;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("mahasiswa_android")
    Call<GetMahasiswa> getMahasiswa();


    @GET("Catatan")
    Call<GetCatatan> getCatatan(
            @Query("nim") String parameter
    );

    @FormUrlEncoded
    @GET("mahasiswa")
    Call<GetMahasiswaId> getMahasiswaId(
            @Field("id") String id
    );

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
    @POST("Catatan")
    Call<PostPutDelCatatan> PostCatatan(
            @Field("judul") String judul,
            @Field("nim") String nim,
            @Field("bimbingan") Integer bimbingan,
            @Field("catatan") String catatan,
            @Field("tanggal") Date tanggal);

    @FormUrlEncoded
    @PUT("Catatan")
    Call<PostPutDelCatatan> PutCatatan(
            @Field("judul") String judul,
            @Field("nim") String nim,
            @Field("bimbingan") Integer bimbingan,
            @Field("catatan") String catatan,
            @Field("tanggal") Date tanggal);

    @FormUrlEncoded
    @PUT("mahasiswa")
    Call<PostPutDelMahasiswa> PutMahasiswa(
            @Field("id") String id,
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

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "Catatan", hasBody = true)
    Call<PostPutDelCatatan> deleteCatatan(
            @Field("id") String id);
}
