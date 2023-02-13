package com.example.messylife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;


public class SelectedMemberDetails extends AppCompatActivity {

    TextView fname, uname, blood, email, address, phone, deposit, expenses, mealcnt, totalcost, age;
    String s1;
    Button btn,dlt;
    double mealRate;

    DatabaseReference reference;
    FirebaseDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_member_details);

        s1 = getIntent().getStringExtra("username");
        String ss = getIntent().getStringExtra("mealrate");
        mealRate = Double.parseDouble(ss);

        fname = findViewById(R.id.fullName);
        uname = findViewById(R.id.UserName);
        blood = findViewById(R.id.bloodGroup);
        email = findViewById(R.id.Email);
        address = findViewById(R.id.PermanentAddress);
        phone = findViewById(R.id.Phone);
        deposit = findViewById(R.id.Deposit);
        expenses = findViewById(R.id.Expenses);
        mealcnt = findViewById(R.id.MealCnt);
        totalcost = findViewById(R.id.MealCost);
        age = findViewById(R.id.Age);
        btn = findViewById(R.id.refreshbtn);
        dlt = findViewById(R.id.DeleteBtn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             show();

            }});

        dlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteData();
                Toast.makeText(SelectedMemberDetails.this,"Successfully Deleted",Toast.LENGTH_SHORT).show();

            }});




        //  Member mem = new Member();
      //  show();

    }


    void show() {
        reference = FirebaseDatabase.getInstance().getReference().child("Members").child(s1);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                fname.setText("Name : " + snapshot.child("fullName").getValue().toString());
                uname.setText("UserName : " + snapshot.child("userName").getValue().toString());
                age.setText("Age : " + snapshot.child("age").getValue().toString());

                blood.setText("Blood Group : " + snapshot.child("bloodGroup").getValue().toString());
                email.setText("Email : " + snapshot.child("email").getValue().toString());
                address.setText("PermanentAddress : " + snapshot.child("permanentAddress").getValue().toString());
                phone.setText("Phone : " + snapshot.child("phoneNumber").getValue().toString());
                int depo = Integer.parseInt(snapshot.child("deposit").getValue().toString());
                int expo = Integer.parseInt(snapshot.child("expenses").getValue().toString());
               deposit.setText("Deposit : " + Integer.toString(depo));
               expenses.setText("Expenses : " + Integer.toString(expo));
                int mealCount = Integer.parseInt(snapshot.child("mealCount").getValue().toString());

                mealcnt.setText("Meal Count : " + Integer.toString(mealCount));
             //   age.setText("Name : " + snapshot.child("age").getValue().toString());
                double mealCost = mealRate*mealCount;

                int fin = (int) Math.round(mealCost);
                String sss =  Integer.toString(fin);
           //     String mealRateStr = String.format("%.2f", sss);

                totalcost.setText("Total Cost :" + sss + "tk");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SelectedMemberDetails.this, "Error", Toast.LENGTH_SHORT).show();

            }


        });

    }

    private void deleteData() {
        reference = FirebaseDatabase.getInstance().getReference("Memebers");
        reference.child(s1).removeValue();
    }

}