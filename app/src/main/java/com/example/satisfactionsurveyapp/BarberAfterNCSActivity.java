package com.example.satisfactionsurveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BarberAfterNCSActivity extends AppCompatActivity {

    Spinner spinnerAfterNCS;
//    Spinner spinnerAfter2;
//    Spinner spinnerAfter3;
//    Spinner spinnerAfter4;
//    Spinner spinnerAfter5;
    Button btnInsertDataAfterNCS;


    DatabaseReference dateDbRefAfterNCS;

    DatabaseReference dateDbRef1;
//    DatabaseReference dateDbRef1 = FirebaseDatabase.getInstance().getReference("ZONE_1");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber_after_ncs);


//        etName = findViewById(R.id.etName);
//        etRollno = findViewById(R.id.etRollno);
        spinnerAfterNCS = findViewById(R.id.spinnerAfterNCS);
//        spinnerAfter2 = findViewById(R.id.spinnerAfter2);
//        spinnerAfter3 = findViewById(R.id.spinnerAfter3);
//        spinnerAfter4 = findViewById(R.id.spinnerAfter4);
//        spinnerAfter5 = findViewById(R.id.spinnerAfter5);
        btnInsertDataAfterNCS = findViewById(R.id.btnInsertDataAfterNCS);


        dateDbRefAfterNCS = FirebaseDatabase.getInstance().getReference("AfterNCSBarber");  //.child("test1");

        btnInsertDataAfterNCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BarberAfterNCSActivity.this, MainActivity.class); //przechodzi do MainActivity i dodaje odpowiedzi do bazy danych
                startActivity(intent);
                insertData();


            }

        });
    }

    private void insertData() {
        //  String name = etName.getText().toString();
        //  String rollno = etRollno.getText().toString();
        String afterNCS = spinnerAfterNCS.getSelectedItem().toString();
//        String after2 = spinnerAfter2.getSelectedItem().toString();
//        String after3 = spinnerAfter3.getSelectedItem().toString();
//        String after4 = spinnerAfter4.getSelectedItem().toString();
//        String after5 = spinnerAfter5.getSelectedItem().toString();


        DateAfterNCS dateAfterNCS = new DateAfterNCS(afterNCS); //name,rollno

        dateDbRefAfterNCS.push().setValue(dateAfterNCS);
        Toast.makeText(BarberAfterNCSActivity.this, "Dziękujemy za OCENE! :)", Toast.LENGTH_LONG).show();


    }

}