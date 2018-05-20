package com.example.jeff.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.*;

public class MainScreen extends AppCompatActivity {

    private double counter = 0.0;
    Stack<String> operations = new Stack<>();
    TextView numberDisplay;
    String holder = "";
    boolean decimal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        numberDisplay = findViewById(R.id.inputDisplay);
    }

    public void zero(View view){
        operations.push("0");
        update("0");
    }

    public void uno(View view){
        operations.push("1");
        update("1");
    }

    public void two(View view){
        operations.push("2");
        update("2");
    }

    public void three(View view){
        operations.push("3");
        update("3");
    }

    public void four(View view){
        operations.push("4");
        update("4");
    }

    public void five(View view){
        operations.push("5");
        update("5");
    }

    public void six(View view){
        operations.push("6");
        update("6");
    }

    public void seven(View view){
        operations.push("7");
        update("7");
    }

    public void eight(View view){
        operations.push("8");
        update("8");
    }

    public void nine(View view){
        operations.push("9");
        update("9");
    }

    public void dot(View view){
        if (!decimal) {
            operations.push(".");
            update(".");
            decimal = true;
        }
    }

    private void delete(View view){

    }

    private void clear(View view){

    }

    private void update(String item){
        holder += item;
        numberDisplay.setText(holder);
    }
}
