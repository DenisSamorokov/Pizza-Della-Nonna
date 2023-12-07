package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

public class Order {
    @SerializedName("phone")
    public String phone;
    @SerializedName("name")
    public String name;
    @SerializedName("address")
    public String address;
    @SerializedName("product")
    public String product;
    @SerializedName("size")
    public String size;
    @SerializedName("price")
    public Integer price;
    @SerializedName("count")
    public Integer count;
    @SerializedName("time")
    public Long time;

    @Override
    public String toString() {
        return "{" +
                "address='" + address + '\'' +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", product='" + product + '\'' +
                ", size='" + size + '\'' +
                ", time=" + time +
                ", phone='" + phone + '\'' +
                '}';
    }
}