package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Pattern;

public class login extends AppCompatActivity {
    EditText uname;
    EditText pass;

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
        if(TextUtils.isEmpty(name)|| name.equals("")){
            Toast.makeText(this, "Please Enter a Username", Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(pw)||pw.equals("")){
            Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show();
        }else if(isValid(pw) == false){
            Toast.makeText(this, "Invalid Password!", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, mainSelection.class);
            intent.putExtra("user", name);
            startActivity(intent);
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
}
