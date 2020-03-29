package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {
    EditText uname;
    EditText pass;
    ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uname =(EditText)findViewById(R.id.userName);
        pass = (EditText) findViewById(R.id.password);
    }

    public void login(View view){
        String name = uname.getText().toString();
        String pw = pass.getText().toString();
        //check if in database
        /*
        if not in database{
            login_dialogue login = new login_dialogue();
            login.show(getSupportFragmentManager(), "User does not exist");
        }
         */
        if(!checkUser(name)){
            login_dialogue login = new login_dialogue();
            login.show(getSupportFragmentManager(), "User does not exist");
        }
        if(TextUtils.isEmpty(name)|| name.equals("") || !name.contains("@")){
            Toast.makeText(this, "Please Enter an Email", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(pw)||pw.equals("")){
            Toast.makeText(this, "Please Enter a Password", Toast.LENGTH_SHORT).show();
        }else if(isValid(pw) == false){
            Toast.makeText(this, "Invalid Password!", Toast.LENGTH_SHORT).show();
        }else{
            if(checkValidUser(name, pw)){
                Intent intent = new Intent(this, mainSelection.class);
                intent.putExtra("email", name);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Invalid Password or Email", Toast.LENGTH_SHORT).show();
            }

        }
    }
    public boolean isValid(String password){
        final String PASSWORD_REGEX =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
        final Pattern PASSWORD_PATTERN =
                Pattern.compile(PASSWORD_REGEX);
        // Validate a password
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            return true;
        }
        else {
            return false;
        }
    }
    public void forgotPassword(View view){
        Intent intent = new Intent(this, forgot_Password.class);
        startActivity(intent);
    }
    public boolean checkUser(String email){
        try {
            FileInputStream fis= openFileInput("emails.txt");
            InputStreamReader isr= new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
            if(data.size()<=0){
                return true;
            }else{
                return data.contains(email);
            }
            //counter++;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkValidUser(String email, String pw){
        try {
            FileInputStream fis= openFileInput("users.txt");
            InputStreamReader isr= new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
            if(data.size()<=0){
                return true;
            }else{
                String [] tokens;
                for(String x: data){
                    tokens = x.split(",");
                    if(tokens[0].equals(email)&&tokens[1].equals(pw)){
                        return true;
                    }else{
                        return false;
                    }
                }
            }
            //counter++;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
