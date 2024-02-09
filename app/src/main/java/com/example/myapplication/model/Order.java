package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Order {
    @SerializedName("phone")
    public String phone;
    @SerializedName("name")
    public String name;
    @SerializedName("address")
    public String address;
    @SerializedName("pizza")
    public String pizza;
    @SerializedName("size")
    public String size;
    @SerializedName("price")
    public Integer price;
    @SerializedName("count")
    public Integer count;
    @SerializedName("date_time")
    public Long date_time;

    @Override
    public String toString() {
        return "{" +
                "address='" + address + '\'' +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pizza='" + pizza + '\'' +
                ", size='" + size + '\'' +
                ", date_time=" + date_time +
                ", phone='" + phone + '\'' +
                '}';
    }
}