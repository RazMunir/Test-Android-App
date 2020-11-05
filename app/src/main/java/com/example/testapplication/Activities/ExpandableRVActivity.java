package com.example.testapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testapplication.Category;
import com.example.testapplication.CategoryAdapter;
import com.example.testapplication.R;

import java.util.ArrayList;

public class ExpandableRVActivity extends AppCompatActivity {

    RecyclerView categoryRecyclerView;
    ArrayList<Category> categoryArrayList;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_r_v);

        categoryArrayList = new ArrayList<>();
        categoryArrayList.add(new Category("Device"));
        categoryArrayList.add(new Category("Toys"));
        categoryArrayList.add(new Category("Home"));

        categoryAdapter = new CategoryAdapter();
        categoryRecyclerView = findViewById(R.id.rv_category);
        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryAdapter = new CategoryAdapter(categoryArrayList, this);
        categoryRecyclerView.setAdapter(categoryAdapter);


    }
}