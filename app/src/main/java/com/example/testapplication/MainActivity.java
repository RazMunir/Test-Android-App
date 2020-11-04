package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Duck duck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        duck = new Duck(MainActivity.this);
    }

    public void showToast(View view) {
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();
    }

    public void goForward(View view) {
        duck.goForward();
    }

    public void goDown(View view) {
        duck.goDown();
    }
}