package com.example.testapplication;

import android.content.Context;
import android.widget.Toast;

public class Duck implements Fly{

    Context context;

    public Duck(Context context){
        this.context = context;
    }

    @Override
    public void goForward() {
        Toast.makeText(context, "Go Forward...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goDown() {
        Toast.makeText(context, "Go Down...", Toast.LENGTH_SHORT).show();
    }
}
