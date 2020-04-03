package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class profilePage extends AppCompatActivity {
    Intent intent;
    String src;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
    }
    @Override
    public void onBackPressed(){
        // super.onBackPressed();
        Toast.makeText(this,"There is no back action",Toast.LENGTH_LONG).show();
        return;
    }
    public void chatGeneral(View view){
        intent = new Intent(this, message_general.class);
        startActivity(intent);
    }

    public void backMain(View view){
        intent = new Intent(this, mainSelection.class);
        startActivity(intent);
    }

    public void toSettings(View view){
        intent = new Intent(this, settings.class);
        startActivity(intent);
    }
    public void toHelp(View view){
        intent = new Intent(this, help_me.class);
        startActivity(intent);
    }
    public void editProfile(View view){
        intent = new Intent(this, edit_profile.class);
        startActivity(intent);
    }
    public void logout(View view){
        intent = new Intent(this, login_or_create.class);
        startActivity(intent);
    }
}
