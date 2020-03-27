package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class help_me extends AppCompatActivity {
    Intent help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_me);
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
    public void contact(View view){
        help = new Intent(this, contact_us.class);
        startActivity(help);
    }
    public void unmatch(View view){
        help = new Intent(this, help_doc.class);
        help.putExtra("id", 0);
        startActivity(help);
    }
    public void changeRestrict(View view){
        help = new Intent(this, help_doc.class);
        help.putExtra("id", 1);
        startActivity(help);
    }
    public void delete(View view){
        help = new Intent(this, help_doc.class);
        help.putExtra("id", 2);
        startActivity(help);
    }

}
