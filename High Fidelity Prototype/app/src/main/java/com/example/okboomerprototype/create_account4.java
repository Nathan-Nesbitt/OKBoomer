package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import java.io.FileOutputStream;

public class create_account4 extends AppCompatActivity {
    EditText radius;
    int rad = 0;
    EditText lowAge;
    int low = 0;
    EditText highAge;
    int high = 0;
    CheckBox men;
    boolean m;
    CheckBox women;
    boolean w;
    CheckBox everyone;
    boolean e;
    Switch notification;
    boolean nt = false;
    String email;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account4);
        intent = getIntent();
        email = intent.getStringExtra("email");
        radius = (EditText) findViewById(R.id.editText7);
        String rad = radius.getText().toString();
        this.rad = Integer.parseInt(rad);
        lowAge = (EditText) findViewById(R.id.lowAge);
        low = Integer.parseInt(lowAge.getText().toString());
        highAge = (EditText) findViewById(R.id.highAge);
        high = Integer.parseInt(highAge.getText().toString());
        men = (CheckBox)findViewById(R.id.checkBox);
        women = (CheckBox)findViewById(R.id.checkBox2);
        everyone = (CheckBox)findViewById(R.id.checkBox3);
        if(men.isChecked()) { m = true; }
        if(women.isChecked()) { w = true; }
        if(everyone.isChecked()) { e = true; }
        notification = (Switch) findViewById(R.id.switch1);
        if(notification.isChecked()){
            nt = true;
        }
    }
    public void saveChanges(View view){
        if(men.isChecked()) { m = true; }
        if(women.isChecked()) { w = true; }
        if(everyone.isChecked()) { e = true; }
        if(notification.isChecked()){
            nt = true;
        }
        String rad = radius.getText().toString();
        this.rad = Integer.parseInt(rad);
        low = Integer.parseInt(lowAge.getText().toString());
        high = Integer.parseInt(highAge.getText().toString());
        String filename = "userSettings.txt";
        FileOutputStream outputStream;
        String fileContents = email + "," + rad+"," + low+","+high+","+m+","+w+","+e+","+nt+","+"\n";

        //allow a file to be opened for writing
        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
            Intent intent = new Intent(this, mainSelection.class);
            intent.putExtra("email", email);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void toMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("radius", rad);
        startActivity(intent);
    }
}
