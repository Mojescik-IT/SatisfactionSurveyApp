package com.example.satisfactionsurveyapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private TextView title2;
    private Button start;
    private Button startAfter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.main_title);
        title2 = findViewById(R.id.main_title2);
        start = findViewById(R.id.ma_startB);
        startAfter = findViewById(R.id.ma_startC);

        Typeface typeface = ResourcesCompat.getFont(this, R.font.blacklist);
        title.setTypeface(typeface);
        title2.setTypeface(typeface);


        //Przechodzi do BarberBeforeActivity
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarberBeforeActivity.class);
                startActivity(intent);

            }

        });

        //Przechodzi do BarberAfterActivity
        startAfter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarberAfterActivity.class);
                startActivity(intent);

            }
        });
    }
}