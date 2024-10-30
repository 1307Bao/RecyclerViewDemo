package com.masterandroid.recyclerviewdemo;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.masterandroid.recyclerviewdemo.adapter.DishAdapter;
import com.masterandroid.recyclerviewdemo.model.DishModel;

import java.util.ArrayList;

public class DishesView extends AppCompatActivity {

    ArrayList<DishModel> dishModels;
    DishAdapter dishAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dishes_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dishModels = (ArrayList<DishModel>) getIntent().getSerializableExtra("Data");
        RecyclerView recyclerView = findViewById(R.id.recyclerViewDish);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        dishAdapter = new DishAdapter(this, dishModels);
        recyclerView.setAdapter(dishAdapter);

        toolbar = findViewById(R.id.toolbarDish);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     onBackPressed();
                 }
             }
        );
    }
}