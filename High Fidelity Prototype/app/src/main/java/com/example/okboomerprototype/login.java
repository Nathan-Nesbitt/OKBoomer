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
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class login extends AppCompatActivity {
    EditText uname;
    EditText pass;
    ArrayList<String> data = new ArrayList<>();
    ArrayList<String> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        uname =(EditText)findViewById(R.id.userName);
        pass = (EditText) findViewById(R.id.password);
    }

    public void login(View view) throws InvalidKeySpecException, NoSuchAlgorithmException {
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
        }else if(TextUtils.isEmpty(pw)||pw.equals("")) {
            Toast.makeText(this, "Please Enter a Password", Toast.LENGTH_SHORT).show();
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
    public boolean checkValidUser(String email, String pw) throws InvalidKeySpecException, NoSuchAlgorithmException {

        try {
            FileInputStream fis= openFileInput("users.txt");
            InputStreamReader isr= new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                users.add(line);
            }
            if(users.size()<=0){
                return false;
            }else{
                int match = 0;
                for(String x:users){
                    String [] tokens = x.split(",");
                    System.out.println(Arrays.toString(tokens));
                    if(tokens[0].equals(email)&& BCrypt.checkpw(pw, tokens[1])){
                        match++;
                    }
                }
                if (match !=0){
                    return true;
                }else{
                    return false;
                }
            }
            //counter++;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
