package com.example.satisfactionsurveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BarberAfterActivity extends AppCompatActivity {


    Spinner spinnerAfter;
    Spinner spinnerAfter2;
    Spinner spinnerAfter3;
    Spinner spinnerAfter4;
    Spinner spinnerAfter5;
    Button btnInsertDataAfter1;


    DatabaseReference dateDbRefAfter;

   DatabaseReference dateDbRef1;
//    DatabaseReference dateDbRef1 = FirebaseDatabase.getInstance().getReference("ZONE_1");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber_after);


//        etName = findViewById(R.id.etName);
//        etRollno = findViewById(R.id.etRollno);
        spinnerAfter = findViewById(R.id.spinnerAfter);
        spinnerAfter2 = findViewById(R.id.spinnerAfter2);
        spinnerAfter3 = findViewById(R.id.spinnerAfter3);
        spinnerAfter4 = findViewById(R.id.spinnerAfter4);
        spinnerAfter5 = findViewById(R.id.spinnerAfter5);
        btnInsertDataAfter1 = findViewById(R.id.btnInsertDataAfter1);


        dateDbRefAfter = FirebaseDatabase.getInstance().getReference("AfterBarber");  //.child("test1");

        btnInsertDataAfter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BarberAfterActivity.this, BarberAfterNCSActivity.class); //przechodzi do MainActivity i dodaje odpowiedzi do bazy danych
                startActivity(intent);
                insertData();





            }

        });
    }

    private void insertData(){
        //  String name = etName.getText().toString();
        //  String rollno = etRollno.getText().toString();
        String after = spinnerAfter.getSelectedItem().toString();
        String after2 = spinnerAfter2.getSelectedItem().toString();
        String after3 = spinnerAfter3.getSelectedItem().toString();
        String after4 = spinnerAfter4.getSelectedItem().toString();
        String after5 = spinnerAfter5.getSelectedItem().toString();


        DateAfter dateAfter = new DateAfter(after,after2,after3,after4,after5); //name,rollno

        dateDbRefAfter.push().setValue(dateAfter);
        Toast.makeText(BarberAfterActivity.this,"...jeszcze jedno pytanie :)",Toast.LENGTH_LONG).show();



    }


}