package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;

public class create_account_bio extends AppCompatActivity {
    EditText bio;
    String bioContent;
    Intent intent;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_bio);
        bio = findViewById(R.id.editText5);
        bioContent = bio.getText().toString();
        intent = getIntent();
        email = intent.getStringExtra("email");
    }

    public void create_next(View view){
        bioContent = bio.getText().toString();

        String filename = "userBio.txt";
        FileOutputStream outputStream;
        String fileContents = email + "," + bioContent+"\n";
        if(bioContent.equals("")){
            Toast.makeText(this, "Please enter a Bio", Toast.LENGTH_SHORT).show();
        }else {
            //allow a file to be opened for writing
            try {
                outputStream = openFileOutput(filename, Context.MODE_APPEND);
                outputStream.write(fileContents.getBytes());
                outputStream.close();
                intent = new Intent(this, create_account4.class);
                intent.putExtra("email", email);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
