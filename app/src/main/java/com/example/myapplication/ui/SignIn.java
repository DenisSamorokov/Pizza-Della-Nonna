package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.model.MassClass;
import com.example.myapplication.model.Order;
import com.example.myapplication.controller.OrderApi;
import com.example.myapplication.model.Orders;
import com.example.myapplication.R;
import com.example.myapplication.controller.RetrofitClient;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn extends AppCompatActivity {
   public EditText phone, adresss, name;
   TextView textView, textView1;
    int pricee;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        phone = findViewById(R.id.editTextText);
        button = findViewById(R.id.button6);
        adresss = findViewById(R.id.editTextText2);
        name = findViewById(R.id.editTextText3);

        OrderApi orderApi = RetrofitClient.getClient().create(OrderApi.class);
        View layout = findViewById(android.R.id.content);
        layout.setBackgroundColor(getResources().getColor(android.R.color.white));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (phone.getText().toString().equals("") || name.getText().toString().equals("") || adresss.getText().toString().equals("")) {
                    Toast.makeText(SignIn.this, "Введите все данные", Toast.LENGTH_SHORT).show();
                } else {
                Orders orders = new Orders();
                orders.data = new ArrayList<>();
                for (int i = 0; i < MassClass.countMass.size(); i++) {
                    Order order = new Order();
                    order.count = MassClass.countMass.get(i);
                    order.address = adresss.getText().toString();
                    order.price = MassClass.price.get(i);
                    order.size = MassClass.size.get(i);
                    order.name = name.getText().toString();
                    order.pizza = MassClass.pizza.get(i);
                    order.date_time = System.currentTimeMillis();
                    order.phone = phone.getText().toString();
                    orders.data.add(order);
                }
                Gson gson = new Gson();
                String json = gson.toJson(orders.data);
                Log.d("OrderInfo", json);

                Call<String> call1 = orderApi.setOrders("secret_key", json);
                call1.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call1, Response<String> response) {
                        String str = response.body();
                        // если удачно, то веорнется слово "success"
                    }

                    @Override
                    public void onFailure(Call<String> call1, Throwable t) {
                    }
                });
                Intent myIntent = new Intent(view.getContext(), StoriesBasket.class);
                // myIntent.putExtra("ph", phone.getText());
                MassClass.phone = String.valueOf(phone.getText());
                startActivity(myIntent);
            }
            }
        });
        Orders orders = new Orders();
        orders.data = new ArrayList<>();
        for(int i = 0; i < MassClass.countMass.size(); i++) {
            Order order = new Order();
            order.count = MassClass.countMass.get(i);
            order.price = MassClass.price.get(i);
            order.size = MassClass.size.get(i);
            order.pizza = MassClass.pizza.get(i);
            orders.data.add(order);
        }
        textView1 = findViewById(R.id.textView12);
        textView = findViewById(R.id.textView10);

        String str = "";
        for (Order order : orders.data) {
            str += order.pizza + "\n" + "Количество: " + order.count + '\n' + "Размер: "
                    + order.size + "\n" +
                    "Цена: " +  order.price  + "₽" +  "\n\n";
            pricee += order.price;
        }
        textView.setText(str);
        textView1.setText("Цена: " + pricee + "₽");
    }
}