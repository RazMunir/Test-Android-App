package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fly {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View view) {
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goForward() {
        Toast.makeText(this, "Go Forward", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goDown() {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}