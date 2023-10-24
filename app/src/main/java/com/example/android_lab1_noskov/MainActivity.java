package com.example.android_lab1_noskov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Consumer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Is color in colors
    private boolean existA(String a) {
        String[] colors = {"red", "orange", "yellow", "green","blue", "purple", };
        for (String s : colors) {
            if (a.equals(s)) {
                return true;
            }
        }
        return false;
    }
    // if button
    public void PaintBackgroundButton(View view){
        ConstraintLayout layout = findViewById(R.id.layout);
        // read color and make string in lover case
        EditText EditColor = findViewById(R.id.my_color);
        String MyColor = EditColor.getText().toString().toLowerCase();
        // If color is correct
        if (existA(MyColor)){
            // paint background of main activity
            Consumer<String> NewColor = str -> {layout.setBackgroundColor(Color.parseColor(str));};
            NewColor.accept(MyColor);
            // make intent and send color to BackColorA
            Intent intent1 = new Intent(this, BackColorA.class);
            intent1.putExtra("new_color", MyColor);
            startActivity(intent1);
        }
        // else write about wrong color
        else {
            Toast.makeText(getApplicationContext(), "Enter correct color", Toast.LENGTH_LONG).show();
        }
    }

}