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
    @GET("mahasiswa")
    Call<GetMahasiswa> getMahasiswa();


    @GET("catatan")
    Call<GetCatatan> getCatatan(
            @Query("nim") String nim
    );

    @GET("mahasiswa")
    Call<GetMahasiswaId> getMahasiswaId(
           @Query("nim") String nim
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
    @POST("catatan")
    Call<PostPutDelCatatan> PostCatatan(
            @Field("judul") String judul,
            @Field("bimbingan") Integer bimbingan,
            @Field("catatan") String catatan,
            @Field("tanggal") String tanggal,
            @Field("nim") String nim);

    @FormUrlEncoded
    @PUT("catatan")
    Call<PostPutDelCatatan> PutCatatan(
            @Field("id") String id,
            @Field("judul") String judul,
            @Field("nim") String nim,
            @Field("bimbingan") String bimbingan,
            @Field("catatan") String catatan,
            @Field("tanggal") String tanggal);

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
