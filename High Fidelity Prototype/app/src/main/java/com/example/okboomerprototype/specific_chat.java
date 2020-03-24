package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class specific_chat extends AppCompatActivity {
    Intent intent;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_chat);
        t = findViewById(R.id.textView4);
        intent = getIntent();
        String userName = intent.getStringExtra("name");
        t.setText(userName);

    }
}
