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
import com.google.firebase.database.ServerValue;

public class AddExpenses extends AppCompatActivity {


    Button addButton;
    Member member;
    EditText usern,add_deposit;
    FirebaseDatabase db;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expenses);

        addButton = (Button)findViewById(R.id.btn_add);



        usern = findViewById(R.id.username);
        add_deposit = findViewById(R.id.moneyAmount);

        reference = FirebaseDatabase.getInstance().getReference("Members");

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //       int meal = Integer.parseInt(FirebaseDatabase.getInstance().getReference("Members");
                int total = Integer.parseInt(add_deposit.getText().toString());
                String uname = usern.getText().toString();

                //   HashMap User = new HashMap();
                //    User.put("mealCount",meal+total);
                //   reference = FirebaseDatabase.getInstance().getReference("Members");
                reference.child(uname).child("expenses").setValue(ServerValue.increment(total));
                ///      reference.child(username.getText().toString()).updateChildren(User);
                Toast.makeText(AddExpenses.this,"Successfully Updated",Toast.LENGTH_SHORT).show();

            }});




    }

    @Override
    public void onBackPressed(){

        Intent intent =new Intent(AddExpenses.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        super.onBackPressed();
    }
}