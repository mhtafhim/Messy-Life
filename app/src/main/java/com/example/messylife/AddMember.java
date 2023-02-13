package com.example.messylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMember extends AppCompatActivity {

    private EditText FullName, Email, PhoneNumber,PermanentAddress,BloodGroup,Age,UserName;
     Button btnRegister;
     FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Members");

        FullName = findViewById(R.id.full_name);
        UserName = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        PhoneNumber = findViewById(R.id.phone_number);
        btnRegister = findViewById(R.id.btn_register);
        PermanentAddress = findViewById(R.id.parmanentAddress);
        Age = findViewById(R.id.age);
        BloodGroup = findViewById(R.id.bloodGroup);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = FullName.getText().toString();
                String email = Email.getText().toString();
                String phoneNumber = PhoneNumber.getText().toString();
                String permanentAddress = PermanentAddress.getText().toString();
                String bloodGroup = BloodGroup.getText().toString();
                String age = Age.getText().toString();
                String username = UserName.getText().toString();

                Member member = new Member(fullName, email, phoneNumber,permanentAddress,bloodGroup,age,username);
               // databaseReference.push().setValue(member);
                databaseReference.child(username).setValue(member);

                Toast.makeText(AddMember.this, "Member registered successfully", Toast.LENGTH_SHORT).show();

                FullName.setText("");
                Email.setText("");
                PhoneNumber.setText("");
                PermanentAddress.setText("");
                BloodGroup.setText("");
                Age.setText("");
                UserName.setText("");
            }
        });
    }

    @Override
    public void onBackPressed(){

        Intent intent =new Intent(AddMember.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        super.onBackPressed();
    }
}