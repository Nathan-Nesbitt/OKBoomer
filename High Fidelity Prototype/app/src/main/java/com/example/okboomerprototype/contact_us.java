package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class contact_us extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
    }
    public void toProfile(View view){
        intent = new Intent(this, profilePage.class);
        startActivity(intent);
    }
    public void backMain(View view){
        intent = new Intent(this, mainSelection.class);
        startActivity(intent);
    }
    public void chatGeneral(View view){
        intent = new Intent(this, message_general.class);
        startActivity(intent);
    }
}
