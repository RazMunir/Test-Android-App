package com.example.testapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class FragmentTestActivity extends AppCompatActivity {

    FragmentA myA;
    FragmentB myB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);

        myA = new FragmentA();
        myB = new FragmentB();

    }

    public void fragmentA(View view) {
//        FragmentA myf = new FragmentA();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(myB);
        transaction.add(R.id.mainframe, myA);
        transaction.commit();
    }

    public void fragmentB(View view) {
//        FragmentB myf = new FragmentB();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(myA);
        transaction.add(R.id.mainframe, myB);
        transaction.commit();
    }
}