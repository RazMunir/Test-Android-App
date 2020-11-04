package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Duck duck;
    Finch finch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for duck: interface implemented in class
        duck = new Duck(MainActivity.this);

        //for finch: interface implemented in main activity file
        finch = new Finch(MainActivity.this, new Fly() {
            @Override
            public void goForward() {
                Toast.makeText(MainActivity.this, "Finch go forward", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void goDown() {
                Toast.makeText(MainActivity.this, "Finch go Down", Toast.LENGTH_SHORT).show();
            }
        });
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

    public void finchGoForward(View view) {
        finch.finchGoForward();
    }

    public void finchGoDown(View view) {
        finch.finchGoDown();
    }
}