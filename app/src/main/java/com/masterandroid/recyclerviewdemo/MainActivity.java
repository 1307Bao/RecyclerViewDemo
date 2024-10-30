package com.masterandroid.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.recyclerviewdemo.adapter.FoodAdapter;
import com.masterandroid.recyclerviewdemo.event.RecyclerViewInterface;
import com.masterandroid.recyclerviewdemo.model.DishModel;
import com.masterandroid.recyclerviewdemo.model.FoodModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private ArrayList<FoodModel> foodModelArrayList;
    private ArrayList<DishModel> listMonMan, listMonCanh, listMonXao;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initData();

        RecyclerView recyclerView = findViewById(R.id.recyclerViewFood);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        foodAdapter = new FoodAdapter(this, foodModelArrayList, this);
        recyclerView.setAdapter(foodAdapter);

    }

    private void initData() {
        listMonMan = new ArrayList<DishModel>();
        listMonMan.add(new DishModel("suonnuong", "Sườn nướng", "15000", "12000", 1));
        listMonMan.add(new DishModel("gakho", "Gà kho", "15000", "15000", 5));
        listMonMan.add(new DishModel("thitkhotrung", "Thịt kho trứng", "12000", "12000", 3));
        listMonMan.add(new DishModel("nemnuong", "Nem nướng", "12000", "17000", 3));
        listMonMan.add(new DishModel("heoquay", "Heo quay", "12000", "12000", 3));

        listMonCanh = new ArrayList<DishModel>();

        listMonCanh.add(new DishModel("canhchua", "Canh chua", "12000", "12000", 2));
        listMonCanh.add(new DishModel("canhcua", "Canh cua", "15000", "15000", 4));
        listMonCanh.add(new DishModel("canhga", "Canh gà", "13000", "13000", 3));
        listMonCanh.add(new DishModel("canhkhoqua", "Canh khổ qua", "16000", "16000", 5));
        listMonCanh.add(new DishModel("canhbacthao", "Canh bắc thảo", "14000", "14000", 1));
        listMonCanh.add(new DishModel("canhchuaot", "Canh chua ớt", "17000", "17000", 6));
        listMonCanh.add(new DishModel("canhtom", "Canh tôm", "15000", "15000", 3));
        listMonCanh.add(new DishModel("canhhaisan", "Canh hải sản", "18000", "18000", 5));
        listMonCanh.add(new DishModel("canhcuon", "Canh cuốn", "16000", "16000", 4));
        listMonCanh.add(new DishModel("canhhuong", "Canh hương", "15000", "15000", 2));

        listMonXao = new ArrayList<DishModel>();

        listMonXao.add(new DishModel("xaohaisan", "Xào hải sản", "20000", "20000", 4));
        listMonXao.add(new DishModel("xaobongcai", "Xào bông cải", "12000", "12000", 3));
        listMonXao.add(new DishModel("xaotrung", "Xào trứng", "14000", "14000", 2));
        listMonXao.add(new DishModel("xaochuoi", "Xào chuối", "13000", "13000", 1));
        listMonXao.add(new DishModel("xaotom", "Xào tôm", "22000", "22000", 5));
        listMonXao.add(new DishModel("xaothit", "Xào thịt", "16000", "16000", 3));
        listMonXao.add(new DishModel("xaokho", "Xào khổ", "15000", "15000", 4));
        listMonXao.add(new DishModel("xaobap", "Xào bắp", "11000", "11000", 2));
        listMonXao.add(new DishModel("xaolien", "Xào liên", "13000", "13000", 3));
        listMonXao.add(new DishModel("xaodau", "Xào đậu", "14000", "14000", 2));

        foodModelArrayList = new ArrayList<FoodModel>();
        foodModelArrayList.add(new FoodModel("monman", "Món mặn", listMonMan));
        foodModelArrayList.add(new FoodModel("moncanh", "Món canh", listMonCanh));
        foodModelArrayList.add(new FoodModel("monxao", "Món xào", listMonXao));
    }

    @Override
    public void click(int position) {
        Intent intent = new Intent(MainActivity.this, DishesView.class);
        intent.putExtra("Data", foodModelArrayList.get(position).getDishModels());
        startActivity(intent);
    }
}