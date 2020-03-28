package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class edit_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
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
    public void addPic(View view){

    }
    public void removePic(View view){

    }
    public void returnProfile(View view){

    }
    public void saveChanges(View view){

    }
    public void deleteAccount(View view){
        delete_dialogue del = new delete_dialogue();
        del.show(getSupportFragmentManager(), "delete account");
    }

}
