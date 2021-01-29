package com.example.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name;
    Button save,data_view;
    DatabaseReference reff;
    reg_name r1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();

        name = findViewById(R.id.name);
        save = findViewById(R.id.save);
        data_view = findViewById(R.id.data_view);

        r1 = new reg_name();
        reff = FirebaseDatabase.getInstance().getReference().child("reg_name");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r1.setName(name.getText().toString().trim());

                reff.push().setValue(r1);

                Toast.makeText(MainActivity.this, "Data Inserted Success", Toast.LENGTH_SHORT).show();

            }
        });

        data_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Display_Data.class);
                startActivity(intent);

            }
        });

    }
}