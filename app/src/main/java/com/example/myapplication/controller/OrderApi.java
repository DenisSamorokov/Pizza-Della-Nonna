package com.example.myapplication.controller;

import com.example.myapplication.model.Orders;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OrderApi {
    @GET("get")
    Call<Orders> getOrders(@Query("phone") String phone);
    @GET("set")
    Call<String> setOrders(@Query("secret_key") String secret_key, @Query("json") String orders);
    // в поле secret_key заносишь значение "secret_key"
}