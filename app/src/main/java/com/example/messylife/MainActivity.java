package com.example.messylife;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {
    Button logoutButton;
    Button AddmemberBtn,addMeal,addMember,addExp;
    Button showMemberBtn,refreshBtn;
    TextView showMealCount, showDeposit,showExpenses,showMessBalance,showMealRate;
    Button AddMealButton,AddExpensesButton,AddDepositButton;


    DatabaseReference mDatabase;

    ArrayList<String> arrayList = new ArrayList<>();
    Button deleteMember;
    int totalMealCount=0;
    int totaldeposit = 0;
    int totalExpenses = 0;
    double mealRate = 0;
    int messBalance = 0;
    Formatter fm=new Formatter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoutButton = findViewById(R.id.logoutButton);
        AddmemberBtn = findViewById(R.id.Addmember);
        showMemberBtn = findViewById(R.id.ActiveMonthDetails);
        showMealCount = findViewById(R.id.total_meals);
        refreshBtn = findViewById(R.id.Refresh);
        showDeposit = findViewById(R.id.show_total_deposit);
        showExpenses = findViewById(R.id.show_total_expenses);
        showMessBalance = findViewById(R.id.show_mess_balance);
        showMealRate = findViewById(R.id.show_meal_rate);
        AddMealButton = findViewById(R.id.AddMeal);
        AddExpensesButton = findViewById(R.id.AddExpenses);
        AddDepositButton = findViewById(R.id.AddMembersMoney);

        mDatabase = FirebaseDatabase.getInstance().getReference("Members");

        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Member mem = snapshot.getValue(Member.class);
                int value = mem.getMealCount();
                totalMealCount+= value;
                totaldeposit+=mem.getDeposit();
                totalExpenses +=mem.getExpenses();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        String MC = Integer.toString(totalMealCount);

        showMealCount.setText(MC);

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String MC = Integer.toString(totalMealCount);
                showMealCount.setText(MC);
                showDeposit.setText(Integer.toString(totaldeposit)+ "tk");
                showExpenses.setText(Integer.toString(totalExpenses)+ "tk");
                showMessBalance.setText(Integer.toString(totaldeposit-totalExpenses)+ "tk");
                mealRate = (double)totalExpenses/totalMealCount;
                String mealRateStr = String.format("%.2f", mealRate);
                showMealRate.setText(mealRateStr+ "tk");


                Toast.makeText(MainActivity.this,"Successfully Updated  "+ MC + "  " + totaldeposit,Toast.LENGTH_SHORT).show();
            }
        });


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                sendUserToNextActivity();
            }
        });
        AddmemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendUserToNextActivityaddmember();
            }
        });
        showMemberBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {sendUserToNextActivityshowMember(); }
        });

        AddExpensesButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { Intent intent =new Intent(MainActivity.this,AddExpenses.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent); }
        });

        AddMealButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { Intent intent =new Intent(MainActivity.this,AddMeal.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent); }
        });

        AddDepositButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { Intent intent =new Intent(MainActivity.this,AddDeposit.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent); }
        });



    }
    private void sendUserToNextActivity() {
        Intent intent =new Intent(MainActivity.this,logInPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private void sendUserToNextActivityaddmember() {
        Intent intent =new Intent(MainActivity.this,AddMember.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void sendUserToNextActivityshowMember() {
        Intent intent =new Intent(MainActivity.this,MemberView.class);
        intent.putExtra("mealRate",Double.toString(mealRate));
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}