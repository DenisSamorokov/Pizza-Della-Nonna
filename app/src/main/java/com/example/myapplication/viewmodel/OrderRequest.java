package com.example.myapplication.viewmodel;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.controller.OrderApi;
import com.example.myapplication.controller.RetrofitClient;
import com.example.myapplication.model.MassClass;
import com.example.myapplication.model.Order;
import com.example.myapplication.model.Orders;
import com.example.myapplication.ui.StoriesBasket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderRequest {

    MutableLiveData<List<Order>> orders = new MutableLiveData<>();

    public LiveData<List<Order>> getOrders(){
        OrderApi orderApi = RetrofitClient.getClient().create(OrderApi.class);
        Call<Orders> call = orderApi.getOrders(MassClass.phone);
        call.enqueue(new Callback<Orders>() {
            @Override
            public void onResponse(Call<Orders> call, Response<Orders> response) {
               Log.d("OrderInfo", String.valueOf(response.body().data));
               orders.postValue(response.body().data);

            }
            @Override
            public void onFailure(Call<Orders> call, Throwable t) {

            }

        });
        return orders;
    }
}
