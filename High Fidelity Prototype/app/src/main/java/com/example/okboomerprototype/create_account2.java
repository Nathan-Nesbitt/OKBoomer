package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.FileOutputStream;

public class create_account2 extends AppCompatActivity {
    private FusedLocationProviderClient fusedLocationClient;
    EditText name;
    EditText age;
    Button submit;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account2);
        intent = getIntent();
        final String email = intent.getStringExtra("email");
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                        }
                    }
                });

        name = (EditText) findViewById(R.id.name);
        final String fn = name.getText().toString();
        age = (EditText) findViewById(R.id.age);
        final String a = age.getText().toString();
        if(checkValues(fn, a )) {
            submit = (Button) findViewById(R.id.createBtn);
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String filename = "userInfo.txt";
                    FileOutputStream outputStream;
                    String fileContents = email + "," + fn + "," + a + "," + "\n";

                    //allow a file to be opened for writing
                    try {
                        outputStream = openFileOutput(filename, Context.MODE_APPEND);
                        outputStream.write(fileContents.getBytes());
                        outputStream.close();
                        Intent intent = new Intent(getApplicationContext(), create_account3.class);
                        intent.putExtra("email", email);
                        startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    public boolean checkValues(String fn, String a){
        if (fn == null || fn.equals("")) {
            Toast.makeText(getBaseContext(), "Invalid Email", Toast.LENGTH_LONG).show();
            return false;
        } else if(a==null || a.equals("") || checkNum(a) == false){
            Toast.makeText(getBaseContext(),"Passwords do not match!", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    public boolean checkNum(String a){
        for(int i = 0; i<a.length();i++){
            if(a.charAt(i) > '0' && a.charAt(i) <'9'){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}
