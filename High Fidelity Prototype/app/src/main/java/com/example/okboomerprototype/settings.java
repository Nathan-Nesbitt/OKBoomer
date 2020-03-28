package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    public void toProfile(View view){
        Intent intent = new Intent(this, profilePage.class);
        startActivity(intent);
    }
    public void backMain(View view){
        Intent intent = new Intent(this, mainSelection.class);
        startActivity(intent);
    }
    public void chatGeneral(View view){
        Intent intent = new Intent(this, message_general.class);
        startActivity(intent);
    }
}
