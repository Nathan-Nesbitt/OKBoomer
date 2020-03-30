package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class match_confirmation extends AppCompatActivity {
    String name;
    ImageView i;
    int picID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_confirmation);
        i = findViewById(R.id.imageView6);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        if(name.equals("Sophie")){
            i.setImageResource(R.drawable.sophie_main);
            picID = R.drawable.sophie_main;
        }else{
            i.setImageResource(R.drawable.chester_main);
            picID = R.drawable.chester_main;
        }
    }
    public void backMain(View view){
        Intent intent = new Intent(this, mainSelection.class);
        startActivity(intent);
    }
    public void sendMessage(View view){
        Intent intent = new Intent(this, send_message.class);
        intent.putExtra("name", name);
        intent.putExtra("picID", picID);
        startActivity(intent);
    }
}
