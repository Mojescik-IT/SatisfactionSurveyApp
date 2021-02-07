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

public class BarberBeforeActivity extends AppCompatActivity {

   // EditText etName;
   // EditText etRollno;
    Spinner spinnerCourses;
    Spinner spinnerCourses2;
    Spinner spinnerCourses3;
    Spinner spinnerCourses4;
    Spinner spinnerCourses5;
    Button btnInsertData;


    DatabaseReference dateDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber_before);


      //  etName = findViewById(R.id.etName);
      //  etRollno = findViewById(R.id.etRollno);
        spinnerCourses = findViewById(R.id.spinnerCourse);
        spinnerCourses2 = findViewById(R.id.spinnerCourse2);
        spinnerCourses3 = findViewById(R.id.spinnerCourse3);
        spinnerCourses4 = findViewById(R.id.spinnerCourse4);
        spinnerCourses5 = findViewById(R.id.spinnerCourse5);


        btnInsertData = findViewById(R.id.btnInsertData);


        dateDbRef = FirebaseDatabase.getInstance().getReference("BeforeBarber");  //.child("test1");

        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData(){
      //  String name = etName.getText().toString();
      //  String rollno = etRollno.getText().toString();
        String course = spinnerCourses.getSelectedItem().toString();
        String course2 = spinnerCourses2.getSelectedItem().toString();
        String course3 = spinnerCourses3.getSelectedItem().toString();
        String course4 = spinnerCourses4.getSelectedItem().toString();
        String course5 = spinnerCourses5.getSelectedItem().toString();


        DateBefore dateBefore = new DateBefore(course,course2,course3,course4,course5); //name,rollno

        dateDbRef.push().setValue(dateBefore);
        Toast.makeText(BarberBeforeActivity.this,"Data inserted!",Toast.LENGTH_SHORT).show();

    }


}