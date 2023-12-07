package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoriesBasket extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_basket);
        textView = findViewById(R.id.textView9);
        button = findViewById(R.id.back);
        View layout = findViewById(android.R.id.content);
        layout.setBackgroundColor(getResources().getColor(android.R.color.white));
        button.setOnClickListener(view ->{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            //this.finish();
        });
       // Intent intent = getIntent();
       // String phone = intent.getStringExtra("ph");

        OrderApi orderApi = RetrofitClient.getClient().create(OrderApi.class);
        Call<Orders> call = orderApi.getOrders(MassClass.phone);
        call.enqueue(new Callback<Orders>() {
            @Override
            public void onResponse(Call<Orders> call, Response<Orders> response) {

                String str = "";
                for (Order order : response.body().data) {
                    str += order.product + "\n" + "Количество: " + order.count + '\n' + "Размер: "
                            + order.size + "\n" +
                            "Адресс: " + order.address + "\n" +
                            "Цена: " +  order.price +  "₽" + "\n\n";

                }
                textView.setText(str);
            }
            @Override
            public void onFailure(Call<Orders> call, Throwable t) {

            }

        });

    }

}