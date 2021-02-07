package com.example.satisfactionsurveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BarberAfterActivity extends AppCompatActivity {


    EditText etName;
    EditText etRollno;
    Spinner spinnerCourses;
    Spinner spinnerCourses2;
    Button btnInsertData;



   DatabaseReference dateDbRef1;
//    DatabaseReference dateDbRef1 = FirebaseDatabase.getInstance().getReference("ZONE_1");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber_after);


        etName = findViewById(R.id.etName);
        etRollno = findViewById(R.id.etRollno);
        spinnerCourses = findViewById(R.id.spinnerCourse);
        spinnerCourses2 = findViewById(R.id.spinnerCourse2);
        btnInsertData = findViewById(R.id.btnInsertData);



        dateDbRef1 = FirebaseDatabase.getInstance().getReference("AfterBarber");  //.child("test2");

        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });

    }

    private void insertData(){
        String name = etName.getText().toString();
        String rollno = etRollno.getText().toString();
        String course = spinnerCourses.getSelectedItem().toString();
        String course2 = spinnerCourses2.getSelectedItem().toString();


        DateAfter date = new DateAfter(course,course2); //name,rollno,

        dateDbRef1.push().setValue(date);
        Toast.makeText(BarberAfterActivity.this,"Data inserted!",Toast.LENGTH_SHORT).show();

    }


}

