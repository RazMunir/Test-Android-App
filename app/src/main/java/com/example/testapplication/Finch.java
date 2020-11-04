package com.example.testapplication;

import android.content.Context;

public class Finch {

    Context context;
    Fly listener;

    public Finch(Context context, Fly listener){
        this.context = context;
        this.listener = listener;
    }

    public void finchGoForward(){
        listener.goForward();
    }

    public void finchGoDown(){
        listener.goDown();
    }
}
