package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.model.MassClass;
import com.example.myapplication.model.Order;
import com.example.myapplication.controller.OrderApi;
import com.example.myapplication.model.Orders;
import com.example.myapplication.R;
import com.example.myapplication.controller.RetrofitClient;
import com.example.myapplication.viewmodel.MainViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoriesBasket extends AppCompatActivity {

    TextView textView;
    Button button;

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_basket);
        textView = findViewById(R.id.textView9);
        button = findViewById(R.id.back);
        View layout = findViewById(android.R.id.content);
        layout.setBackgroundColor(getResources().getColor(android.R.color.white));

        mainViewModel = new ViewModelProvider( this).get(MainViewModel.class);
        mainViewModel.getOrders().observe(StoriesBasket.this, new Observer<List<Order>>() {
            @Override
            public void onChanged(List<Order> orders) {
                String str = "";

                for (Order order : orders) {
                        Date date = new Date(order.date_time);
                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yy", Locale.getDefault());
                        String formattedDate = sdf.format(date);

                        str += order.pizza + "\n" + "Количество: " + order.count + '\n' + "Размер: "
                                + order.size + "\n" +
                                "Адрес: " + order.address + "\n" +
                                "Дата: " + formattedDate + "\n" +
                                "Цена: " +  order.price +  "₽" + "\n\n";

                    }
                    textView.setText(str);

            }
        });
        button.setOnClickListener(view ->{
           Intent intent = new Intent(this, MainActivity.class);
           startActivity(intent);
        });


    }

}