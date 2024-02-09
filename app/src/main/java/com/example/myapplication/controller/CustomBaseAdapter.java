package com.example.myapplication.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.MassClass;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CustomBaseAdapter extends BaseAdapter {
    Context context;
    int [][] PricePizza;
    String[] PizzaName;
    String[] PizzaDesc;
    int[] listImages;
    LayoutInflater inflater;
    String currentSize;
    String str;
    int ii = 1;
    int curentPrice;

    public CustomBaseAdapter(Context ctx, String [] pizzaname, String [] pizzaDesc, int [][] pricePizza, int [] image){
        this.context = ctx;
        this.PizzaName = pizzaname;
        this.PricePizza = pricePizza;
        this.PizzaDesc = pizzaDesc;
        this.listImages = image;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return PizzaName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.activity_custom_list_view, null);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        TextView textView1 = (TextView) view.findViewById(R.id.textView2);

        ImageView PizzaImg = view.findViewById(R.id.imageIcon);
        textView.setText(PizzaName[i]);
        textView1.setText(PizzaDesc[i]);
        PizzaImg.setImageResource(listImages[i]);

        Button button = view.findViewById(R.id.button);
        button.setText("От " + PricePizza[i][0] + "₽");
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               BottomSheetDialog dialog = new BottomSheetDialog(context);
               View view = inflater.inflate(R.layout.dialog, null);
               dialog.setContentView(view);
               dialog.show();

               Button button1 = dialog.findViewById(R.id.button2);
               Button button2 = dialog.findViewById(R.id.button3);
               Button button3 = dialog.findViewById(R.id.button4);
               TextView pricee = dialog.findViewById(R.id.textView6);
               Button button4 = dialog.findViewById(R.id.button5);

               TextView pizzatextview = (TextView) dialog.findViewById(R.id.textView7);
               pizzatextview.setText(PizzaName[i]);
               TextView textView2 = dialog.findViewById(R.id.textView5);

               button1.setOnClickListener(view1 -> {
                   button1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA200")));
                   button2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF7b00")));
                   button3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF7b00")));


                   str = String.valueOf(PricePizza[i][0] * Integer.parseInt(textView2.getText().toString()));
                   pricee.setText("Цена: " + str + "₽");
                   curentPrice = PricePizza[i][0];
                   currentSize = "Маленький";

               });
               button2.setOnClickListener(view1 -> {
                  // button2.setTextColor(R.color.orange);
                   button2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA200")));
                   button1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF7b00")));
                   button3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF7b00")));
                   curentPrice = PricePizza[i][1];

                   str = String.valueOf(PricePizza[i][1] * Integer.parseInt(textView2.getText().toString()));
                   pricee.setText("Цена: " + str  + "₽");
                   currentSize = "Средний";
               });
               button3.setOnClickListener(view1 -> {
                   button3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFA200")));
                   button2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF7b00")));
                   button1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FF7b00")));
                   str = String.valueOf(PricePizza[i][2] * Integer.parseInt(textView2.getText().toString()));
                   pricee.setText("Цена: " + str + "₽");
                   currentSize = "Большой";
                   curentPrice = PricePizza[i][2];

               });

               button4.setOnClickListener(view1 -> {
                   MassClass.countMass.add(Integer.parseInt((String) textView2.getText().toString()));
                   MassClass.pizza.add((String) pizzatextview.getText().toString());
                   MassClass.size.add(currentSize);
                   MassClass.price.add(Integer.parseInt(str));
                   dialog.dismiss();
                   ii = 1;
               });
               ImageButton imageButton1 = dialog.findViewById(R.id.imageButton);
               ImageButton imageButton2 = dialog.findViewById(R.id.imageButton2);
               textView2.setText(String.valueOf(ii));
               imageButton1.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view1) {
                       ii = ii + 1;
                       textView2.setText(String.valueOf(ii));
                       str = String.valueOf(curentPrice * Integer.parseInt(textView2.getText().toString()));
                       pricee.setText("Цена: " + str  + "₽");
                   }
               });
               imageButton2.setOnClickListener(view1 -> {
                   ii = ii - 1;
                   textView2.setText(String.valueOf(ii));
                   str = String.valueOf(curentPrice * Integer.parseInt(textView2.getText().toString()));
                   pricee.setText("Цена: " + str  + "₽");
               });

           }
       });
      return view;


    }

}
