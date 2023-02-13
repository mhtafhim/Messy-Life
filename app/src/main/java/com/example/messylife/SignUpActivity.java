package com.example.messylife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    EditText name,email,password,ConfirmPassword;
    Button SignUpButton,LogInButton;
    String emailPattern ="[a-zA-Z0-9]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password=findViewById(R.id.password);
        ConfirmPassword= findViewById(R.id.ConfirmPassword);
        SignUpButton =findViewById(R.id.SignUpButton);
        progressDialog = new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        LogInButton=findViewById(R.id.LogInButton);
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendUserToNextActivity();
            }
        });
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerForAuth();
            }
        });
    }
    private void PerForAuth(){
        String name1 = name.getText().toString();
        String email1 = email.getText().toString();
        String password1 = password.getText().toString();
        String ConfirmPassword1 = ConfirmPassword.getText().toString();


        if(!email1.matches(emailPattern)){
          email.setError("ENTER COREECT EMAIL");
        }
        else if(password1.isEmpty()||password1.length()<6){
            password.setError("Enter proper password");
        }
        else if(!password1.equals(ConfirmPassword1)){
            ConfirmPassword.setError("Not match to the passsword");
        }
        else{
            progressDialog.setMessage("Please wait while Sign Up");
            progressDialog.setTitle("Sign Up");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       progressDialog.dismiss();
                       sendUserToNextActivity();
                       Toast.makeText(SignUpActivity.this, "Sign Up Successfull", Toast.LENGTH_SHORT).show();
                   }
                   else
                   {
                       progressDialog.dismiss();
                       Toast.makeText(SignUpActivity.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                   }
                }
            });
        }

    }

    private void sendUserToNextActivity() {
        Intent intent =new Intent(SignUpActivity.this,logInPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
