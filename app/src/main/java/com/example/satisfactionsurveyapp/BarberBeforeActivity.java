package com.example.satisfactionsurveyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Member;
import java.util.Date;

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

////-
//    int maxid = 0;
//    DateBefore dateBefore;
////-

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

////-
//
//
//
//        dateBefore  = new DateBefore(" "," "," "," "," ");
//        dateDbRef = FirebaseDatabase.getInstance().getReference().child("BeforeBarber");
//        dateDbRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()){
//                    maxid = (int) dataSnapshot.getChildrenCount();
//                }else {
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
////-

        btnInsertData = findViewById(R.id.btnInsertData);


        dateDbRef = FirebaseDatabase.getInstance().getReference().child("BeforeBarber");  //.child("test1");




        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BarberBeforeActivity.this, MainActivity.class); //przechodzi do MainActivity i dodaje odpowiedzi do bazy danych
                startActivity(intent);
                insertData();



            }

        });
    }

    private void insertData(){
      //  String name = etName.getText().toString();
      //  String rollno = etRollno.getText().toString();
        String beforeAnswer1 = spinnerCourses.getSelectedItem().toString();
        String beforeAnswer2 = spinnerCourses2.getSelectedItem().toString();
        String beforeAnswer3 = spinnerCourses3.getSelectedItem().toString();
        String beforeAnswer4 = spinnerCourses4.getSelectedItem().toString();
        String beforeAnswer5 = spinnerCourses5.getSelectedItem().toString();

//        //-
//        dateDbRef.child(String.valueOf(maxid+1)).push().setValue(dateBefore);
//        //-


        DateBefore dateBefore = new DateBefore(beforeAnswer1,beforeAnswer2,beforeAnswer3,beforeAnswer4,beforeAnswer5); //name,rollno

        dateDbRef.push().setValue(dateBefore);
        Toast.makeText(BarberBeforeActivity.this,"Dziękujemy za OCENĘ :)",Toast.LENGTH_LONG).show();



    }


}