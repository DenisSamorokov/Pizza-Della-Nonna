package com.example.myapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.model.Order;

import java.util.List;


public class MainViewModel extends AndroidViewModel {

    private OrderRequest orderRequest;

    public MainViewModel(@NonNull Application application) {
        super(application);
        orderRequest = new OrderRequest();
    }
    public LiveData<List<Order>> getOrders(){
        return orderRequest.getOrders();
    }
}
