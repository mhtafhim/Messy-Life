package com.example.messylife;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MemberView extends AppCompatActivity {
    DatabaseReference mDatabase;
    ListView member_list;
    ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    Module module;
     Button deleteMember;
    String mealRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_view);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, arrayList);
        mDatabase = FirebaseDatabase.getInstance().getReference("Members");
        deleteMember = (Button) findViewById(R.id.deleteMember);
        module = ((Module)getApplicationContext());
        member_list = (ListView) findViewById(R.id.member_list);
        member_list.setAdapter(adapter);

        mealRate = getIntent().getStringExtra("mealRate");

        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value = snapshot.getValue(Member.class).toString();
                arrayList.add(value);
                adapter.notifyDataSetChanged();
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


        member_list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                module.setGvalue_usename(arrayList.get(position));
                final String str = module.getGvalue_usename();
                Intent intent = new Intent(MemberView.this, SelectedMemberDetails.class);
                intent.putExtra("mealrate",mealRate);
                intent.putExtra("username",str);
                startActivity(intent);

            }
        });
        /*
        deleteMember.setOnClickListener(v -> {
            final String str = module.getGvalue_usename().substring(0,8);
            if(str==""){
                Toast.makeText(MemberView.this,"please select item before delete",Toast.LENGTH_LONG).show();
            }else
            {
              mDatabase.child("members").child(str).addListenerForSingleValueEvent(new ValueEventListener() {
                  @Override
                  public void onDataChange(@NonNull DataSnapshot snapshot) {
                      mDatabase.child(str).removeValue();
                  }

                  @Override
                  public void onCancelled(@NonNull DatabaseError error) {

                  }
              });
              Toast.makeText(MemberView.this,"Student is Delected",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),MemberView.class);
                startActivity(intent);
            }
        });
        */

    }

    @Override
    public void onBackPressed(){

        Intent intent =new Intent(MemberView.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        super.onBackPressed();
    }
}