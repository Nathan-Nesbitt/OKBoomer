package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class mainSelection extends AppCompatActivity {
    int cUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selection);
//        ImageView img = findViewById(R.id.imageView8);
//        cUser = img.getId();
    }
    public void chatGeneral(View view){
        Intent intent = new Intent(this, message_general.class);
        startActivity(intent);
    }

    public void matchScreen(View view){
        Intent intent = new Intent(this, matchScreen.class);
//        intent.putExtra("userPic", cUser);
        startActivity(intent);
    }


}
