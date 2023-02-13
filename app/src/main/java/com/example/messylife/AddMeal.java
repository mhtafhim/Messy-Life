package com.example.messylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class AddMeal extends AppCompatActivity {

    Button addButton;
    Member member;
    EditText usern,add_meal;
    FirebaseDatabase db;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meal);
        addButton = (Button)findViewById(R.id.btn_add);



        usern = findViewById(R.id.username);
        add_meal = findViewById(R.id.mealNumber);

        reference = FirebaseDatabase.getInstance().getReference("Members");

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //       int meal = Integer.parseInt(FirebaseDatabase.getInstance().getReference("Members");
                int total = Integer.parseInt(add_meal.getText().toString());
                String uname = usern.getText().toString();

                //   HashMap User = new HashMap();
                //    User.put("mealCount",meal+total);
                //   reference = FirebaseDatabase.getInstance().getReference("Members");
                reference.child(uname).child("mealCount").setValue(ServerValue.increment(total));
                ///      reference.child(username.getText().toString()).updateChildren(User);
                Toast.makeText(AddMeal.this,"Successfully Updated",Toast.LENGTH_SHORT).show();

            }});

    }

    @Override
    public void onBackPressed(){

        Intent intent =new Intent(AddMeal.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        super.onBackPressed();
    }


}
