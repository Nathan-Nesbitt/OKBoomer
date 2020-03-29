package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class create_account extends AppCompatActivity {
    EditText email;
    EditText pass;
    EditText confirm_pass;
    ArrayList<String> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        email = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.password);
        confirm_pass = (EditText) findViewById(R.id.age);
    }
    public void create_account(View view) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String n = email.getText().toString();
        String p = pass.getText().toString();
        String cp = confirm_pass.getText().toString();
        if (n == null || n.equals("") || !n.contains("@")) {
            Toast.makeText(getBaseContext(), "Invalid Email", Toast.LENGTH_LONG).show();
        }else if (checkUser(n)){
            Toast.makeText(getBaseContext(), "User already exists", Toast.LENGTH_LONG).show();
        } else if(p==null || p.equals("") || isValid(p)==false){
            Toast.makeText(getBaseContext(),"Invalid Password!", Toast.LENGTH_LONG).show();
        }else if(cp==null || cp.equals("") || !cp.equals(p)){
            Toast.makeText(getBaseContext(),"Passwords do not match!", Toast.LENGTH_LONG).show();
        }
        else{
            String file2 = "emails.txt";
            String file2contents = n + "\n";
            FileOutputStream outputStream;
            FileOutputStream out2;
            String filename = "users.txt";
            String fileContents= n + ","+BCrypt.hashpw(p, BCrypt.gensalt(12)) +"\n";

            //allow a file to be opened for writing
            try {
                outputStream = openFileOutput(filename, Context.MODE_APPEND);
                outputStream.write(fileContents.getBytes());
                outputStream.close();
                Intent intent = new Intent(this, create_account2.class);
                intent.putExtra("email", n);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try{
                out2 = openFileOutput(file2, Context.MODE_APPEND);
                out2.write(file2contents.getBytes());
                out2.close();
            }catch(Exception e){
                e.printStackTrace();
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
}
