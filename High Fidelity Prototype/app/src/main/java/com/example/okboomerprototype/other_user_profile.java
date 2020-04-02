package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class other_user_profile extends AppCompatActivity {
    Intent intent;
    String name;
    int picID;
    ImageView main;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    TextView n;
    TextView age;
    ArrayList<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_user_profile);
        intent = getIntent();
        name = intent.getStringExtra("name");
        picID = intent.getIntExtra("picID", 0);

        //initialize all variables
        main = findViewById(R.id.mainPic);
        img2 = findViewById(R.id.pic2);
        img3 = findViewById(R.id.pic3);
        img4 = findViewById(R.id.pic4);
        img5 = findViewById(R.id.pic5);

        n = findViewById(R.id.name);
        age = findViewById(R.id.age);

        n.setText(name);
        //get age and images from database/file system
        //since we don't have a lot of images saved and i don't want to make a lot of other images
        //I am just going to initialize with what I have and then placeholders.
        main.setImageResource(picID);
        img2.setImageResource(R.drawable.ic_image_black_biggerdp);
        img3.setImageResource(R.drawable.ic_image_black_biggerdp);
        img4.setImageResource(R.drawable.ic_image_black_biggerdp);
        img5.setImageResource(R.drawable.ic_image_black_biggerdp);

        getInfo();

    }
    public void chatGeneral(View view){
        finish();
    }

    public void backMain(View view){
        intent = new Intent(this, mainSelection.class);
        startActivity(intent);
    }
    public void toUser(View view){
        Intent intent = new Intent(this, profilePage.class);
        startActivity(intent);
    }

    public void toUserChat(View view){
        Intent intent = new Intent(this, specific_chat.class);
        intent.putExtra("picID", picID);
        intent.putExtra("name", name);
        intent.putExtra("fromId", 1);
        startActivity(intent);
    }
    public void unmatch(View view){
        Toast.makeText(this, "Feature not yet implemented", Toast.LENGTH_SHORT).show();
    }
    public void getInfo(){
        try{
            FileInputStream fis= openFileInput("userInfo.txt");
            InputStreamReader isr= new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
            if(data.size()<=0){

            }else{
               data.contains(name);
            }
        //counter++;
        }catch(IOException e) {
            e.printStackTrace();
        }


    }
}
