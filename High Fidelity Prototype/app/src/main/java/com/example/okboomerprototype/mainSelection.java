package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mainSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selection);
    }
    public void chatGeneral(View view){
        Intent intent = new Intent(this, message_general.class);
        startActivity(intent);
    }

}
