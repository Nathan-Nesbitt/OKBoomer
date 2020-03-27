package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class match_confirmation extends AppCompatActivity {
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_confirmation);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
    }
    public void backMain(View view){
        Intent intent = new Intent(this, mainSelection.class);
        startActivity(intent);
    }
    public void sendMessage(View view){
        Intent intent = new Intent(this, send_message.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
