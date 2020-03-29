package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class forgot_Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);
    }
    public void submit(View view){
        fp_dialog fp = new fp_dialog();
        fp.show(getSupportFragmentManager(), "forgot password");
    }
}
