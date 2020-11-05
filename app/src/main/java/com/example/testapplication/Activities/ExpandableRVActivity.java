package com.example.testapplication.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.Category;
import com.example.testapplication.Adapters.CategoryAdapter;
import com.example.testapplication.R;
import com.example.testapplication.Type;
import com.example.testapplication.Adapters.TypeAdapter;

import java.util.ArrayList;

public class ExpandableRVActivity extends AppCompatActivity {

    RecyclerView categoryRecyclerView, typeRecyclerView;
    ArrayList<Category> categoryArrayList;
    CategoryAdapter categoryAdapter;

    ArrayList<Type> typeArrayList;
    TypeAdapter typeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_r_v);

        //category
        categoryArrayList = new ArrayList<>();
        categoryArrayList.add(new Category("Device"));
        categoryArrayList.add(new Category("Toys"));
        categoryArrayList.add(new Category("Home"));

        categoryRecyclerView = findViewById(R.id.rv_category);
        categoryAdapter = new CategoryAdapter();
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        categoryAdapter = new CategoryAdapter(categoryArrayList, this);
//        categoryRecyclerView.setAdapter(categoryAdapter);

        //type
        typeArrayList = new ArrayList<>();
        typeArrayList.add(new Type("Mobile"));
        typeArrayList.add(new Type("Laptop"));
        typeArrayList.add(new Type("Radio"));

        typeRecyclerView = findViewById(R.id.rv_type);
        typeAdapter = new TypeAdapter();
        typeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        typeAdapter = new TypeAdapter(typeArrayList, this);
        typeRecyclerView.setAdapter(typeAdapter);

        categoryAdapter = new CategoryAdapter(categoryArrayList, this, typeRecyclerView);
        categoryRecyclerView.setAdapter(categoryAdapter);

        //product
    }
}