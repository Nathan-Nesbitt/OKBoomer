package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class help_doc extends AppCompatActivity {
    Intent help;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_doc);
        TextView title = (TextView) findViewById(R.id.textView25);
        TextView answer = (TextView) findViewById(R.id.textView26);
        help = getIntent();
        int id = help.getIntExtra("id", 0);
        switch(id){
            case 0: title.setText("How do I unmatch?"); answer.setText(R.string.unmatch); break;
            case 1: title.setText("How do I change my match restrictions?"); answer.setText(R.string.restrict);break;
            case 2: title.setText("How do I delete my account?"); answer.setText(R.string.delete);
        }
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
    public void contact(View view){
        help = new Intent(this, contact_us.class);
        startActivity(help);
    }
}
