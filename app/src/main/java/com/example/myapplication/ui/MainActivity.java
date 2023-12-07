package com.example.myapplication.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.controller.CustomBaseAdapter;
import com.example.myapplication.model.MassClass;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    String[] PizzaName = {"Пепперони фреш", "Мортаделла с песто", "Сырная", "Двойной цыпленок",
            "Ветчина и сыр", "Песто", "Карбонара", "Аррива!"};

    String[] PizzaDescribe = {"Пикантная пепперони, увеличенная порция моцареллы, томаты, фирменный томатный соус",
            "Мортаделла, соус песто, моцарелла, кубики брынзы и фирменный томатный соус",
            "Моцарелла, сыры чеддер и пармезан, фирменный соус альфредо",
            "Цыпленок, моцарелла, фирменный соус альфредо",
            "Ветчина, моцарелла, фирменный соус альфредо",
            "Цыпленок, соус песто, кубики брынзы, томаты, моцарелла, фирменный соус альфредо",
            "Бекон, сыры чеддер и пармезан, моцарелла, томаты, красный лук, чеснок, фирменный соус альфредо, итальянские травы",
            "Цыпленок, острая чоризо, соус бургер, сладкий перец, красный лук, томаты, моцарелла, соус ранч, чеснок"};
    int[][] PizzaPrice = {{289, 479, 609}, {519, 819, 949}, {289, 479, 609}, {369, 529, 689}, {369, 529, 689},
            {469, 719, 799}, {519, 819, 949}, {469, 719, 799}};
    int[] PizzaImage = {R.drawable.p1p, R.drawable.p2p, R.drawable.p3p, R.drawable.p4p, R.drawable.p5p,
            R.drawable.p6p, R.drawable.p7p, R.drawable.p8p};
    ListView listView;
    FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.customListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(this, PizzaName, PizzaDescribe, PizzaPrice, PizzaImage);
        listView.setAdapter(customBaseAdapter);
        View layout = findViewById(android.R.id.content);
        layout.setBackgroundColor(getResources().getColor(android.R.color.white));

        button = findViewById(R.id.button8);
        button.setOnClickListener(view -> {
            if (MassClass.pizza.isEmpty()){
                Toast.makeText(this, "Добавьте пиццу в корзину", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(view.getContext(), SignIn.class);
                startActivity(intent);
            }
        });
    }
}