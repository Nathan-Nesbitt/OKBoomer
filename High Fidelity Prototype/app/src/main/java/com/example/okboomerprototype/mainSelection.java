package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class mainSelection extends AppCompatActivity {
    int cUser;
    String name;
    String email;
    Intent user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selection);
//        ImageView img = findViewById(R.id.imageView8);
//        cUser = img.getId();
        TextView text = (TextView) findViewById(R.id.textView3);
        name = (String) text.getText();
        user = getIntent();
        email = user.getStringExtra("email");
    }
    public void chatGeneral(View view){
        Intent intent = new Intent(this, message_general.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
    public void toUser(View view){
        Intent intent = new Intent(this, profilePage.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    public void matchScreen(View view){
        Intent intent = new Intent(this, matchScreen.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }


}
