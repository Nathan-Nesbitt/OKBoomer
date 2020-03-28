package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class settings extends AppCompatActivity {
    EditText radius;
    int rad = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        radius = (EditText) findViewById(R.id.editText7);
        String rad = radius.getText().toString();
        this.rad = Integer.parseInt(rad);
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
    public void saveChanges(View view){
        save_dialogue save = new save_dialogue();
        save.show(getSupportFragmentManager(), "save changes");
    }
    public void toMap (View view){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("radius", rad);
        startActivity(intent);
    }
}
