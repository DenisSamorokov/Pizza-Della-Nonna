package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Orders {

    @SerializedName("data")
    public List<Order> data;

}