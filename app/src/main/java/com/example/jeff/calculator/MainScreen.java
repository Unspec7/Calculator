package com.example.jeff.calculator;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

import static android.app.PendingIntent.getActivity;

public class MainScreen extends AppCompatActivity {

    private double counter = 0.0;
    Stack<String> operations = new Stack<>();
    TextView numberDisplay;
    ImageView delButton;
    String holder = "";
    boolean decimal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        delButton = findViewById(R.id.delete);
        numberDisplay = findViewById(R.id.inputDisplay);
    }

    public void zero(View view){
        pushOP("0");
    }

    public void uno(View view){
        pushOP("1");
    }

    public void two(View view){
        pushOP("2");
    }

    public void three(View view){
        pushOP("3");
    }

    public void four(View view){
        pushOP("4");
    }

    public void five(View view){
        pushOP("5");
    }

    public void six(View view){
        pushOP("6");
    }

    public void seven(View view){
        pushOP("7");
    }

    public void eight(View view){
        pushOP("8");
    }

    public void nine(View view){
        pushOP("9");
    }

    public void dot(View view){
        if (!decimal) {
            pushOP(".");
            decimal = true;
        }
    }

    public void plus(View view){
        String currentOP = operations.peek();
        if (!currentOP.equals("+")) {
            if (currentOP.equals("x") || currentOP.equals("/") || currentOP.equals("-")) {
                operations.pop();
                pushOP("+");
            } else {
                pushOP("+");
            }
        }
    }

    public void mult(View view){
        String currentOP = operations.peek();
        if (!currentOP.equals("x")) {
            if (currentOP.equals("+") || currentOP.equals("/") || currentOP.equals("-")) {
                operations.pop();
                pushOP("x");
            } else {
                pushOP("x");
            }
        }
    }

    public void div(View view){
        String currentOP = operations.peek();
        if (!currentOP.equals("/")) {
            if (currentOP.equals("x") || currentOP.equals("+") || currentOP.equals("-")) {
                operations.pop();
                pushOP("/");
            } else {
                pushOP("/");
            }
        }
    }

    public void sub(View view){
        String currentOP = operations.peek();
        if (!currentOP.equals("-")) {
            if (currentOP.equals("x") || currentOP.equals("/") || currentOP.equals("+")) {
                operations.pop();
                pushOP("-");
            } else {
                pushOP("-");
            }
        }
    }

    public void equal(View view){
        /**
         * @author Unspec7
         * Final operations calculation
         */
        delButton.setImageResource(android.R.drawable.ic_menu_delete);
    }

    public void delete(View view){
        if (delButton.getDrawable().getConstantState() == ContextCompat.getDrawable(
                this, android.R.drawable.ic_input_delete).getConstantState()) {
            // Delete
            if (holder.length() > 0 && !operations.empty()) {
                holder = holder.substring(0, holder.length() - 1);
                operations.pop();
                updateText();
            }
        }
        else{
            // Clear
            if (holder.length() != 0) {
                holder = "";
                operations.clear();
                fliptoDel();
                updateText();
            }
        }
    }

    private void fliptoDel(){
        /**
         * @author Unspec7
         * Used to flip the clear icon, which shows up after an operation has been done
         * to the delete icon again
         */
        delButton.setImageResource(android.R.drawable.ic_input_delete);
    }

    private void pushOP(String item){
        operations.push(item);
        update(item);
    }

    private void update(String item){
        holder += item;
        updateText();
    }

    private void updateText(){
        numberDisplay.setText(holder);
        //printStack(); // Used for troubleshooting
    }

    private void printStack(){
        System.out.println(Arrays.toString(operations.toArray()));
    }
}
