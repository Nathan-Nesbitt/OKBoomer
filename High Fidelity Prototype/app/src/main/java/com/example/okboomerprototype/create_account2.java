package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
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
    Intent intent;
    String email;
    String fn = "";
    int a = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account2);
        intent = getIntent();
        email = intent.getStringExtra("email");
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

        name = findViewById(R.id.nameInput);
        age = findViewById(R.id.ageInput);

    }
    public void create_next(View view){
        fn = name.getText().toString();
        System.out.println(fn);
        String change = age.getText().toString();
        if (change.equals("")){ // detect an empty string and set it to "0" instead
            change = "0";
        }
        a = Integer.parseInt(change);
        System.out.println(a);
        if(checkValues(a)){
            String filename = "userInfo.txt";
            FileOutputStream outputStream;
            String fileContents = email + "," + fn + "," + a + "\n";

            //allow a file to be opened for writing
            try {
                outputStream = openFileOutput(filename, Context.MODE_APPEND);
                outputStream.write(fileContents.getBytes());
                outputStream.close();
                Intent intent = new Intent(this, create_account3.class);
                intent.putExtra("email", email);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public boolean checkValues(int a){
        if(a < 18){
            Toast.makeText(getBaseContext(),"Please enter a valid age (must be over 18)", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
