package com.example.android_lab1_noskov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.function.Consumer;

public class BackColorA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_color);

        // Get new color
        Bundle new_color_b = getIntent().getExtras();
        ConstraintLayout layout = findViewById(R.id.layout);
        String new_color_s = new_color_b.getString("new_color");
        // Paint background to new_color
        Consumer<String> NewColor = str -> layout.setBackgroundColor(Color.parseColor(str));
        NewColor.accept(new_color_s);
    }

    public void BackMainButton (View view){
        // go to MainActivity
        Intent intent2 = new Intent(this, MainActivity.class);
        startActivity(intent2);
    }
}