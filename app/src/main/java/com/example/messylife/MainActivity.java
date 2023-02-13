package com.example.messylife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button logoutButton;
    Button Addmember;
    Button showMemberBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoutButton = findViewById(R.id.logoutButton);
        Addmember = findViewById(R.id.Addmember);
        showMemberBtn = findViewById(R.id.ActiveMonthDetails);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                sendUserToNextActivity();
            }
        });
        Addmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendUserToNextActivityaddmember();
            }
        });
        showMemberBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {sendUserToNextActivityshowMember(); }
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
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}