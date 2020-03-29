package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class specific_chat extends AppCompatActivity {
    Intent intent;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    ArrayList<Message> msg;
    ImageView pic;
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_chat);
        intent = getIntent();
        String userName = intent.getStringExtra("name");
        int picID = intent.getIntExtra("picID", 0);
        pic = findViewById(R.id.mainPic);
        name = findViewById(R.id.nameUser);
        pic.setImageResource(picID);
        name.setText(userName);
        int id = intent.getIntExtra("fromId", 0);

        if(id == 0) {
            //initialize arrayLists for values (eventually replace with values from the database)
            msg = new ArrayList<>();
            Message m = new Message();
            m.setUserName(userName);
            // b.setText(m.getUserName());
            m.setImg(picID);
            // System.out.println(m.getImg());
            m.setTime("7:45");
            m.setMsg("Hey there ;)");
            msg.add(m);
            m = new Message();
            m.setMsg("Hello hello");
            m.setTime("8:01");
            msg.add(m);
        }else{
            msg = new ArrayList<>();
            Message m = new Message();
            m.setUserName(userName);
            // b.setText(m.getUserName());
            m.setImg(picID);
            // System.out.println(m.getImg());
        }

        //set up recycler view for messages
        recyclerView = (RecyclerView) findViewById(R.id.reyclerview_message_list);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        messageAdapter mA = new messageAdapter(this, msg);
        recyclerView.setAdapter(mA);


        //send to recycler
//        mA.setItems(msg);

    }
    public void chatGeneral(View view){
        finish();
    }

    public void backMain(View view){
        Intent intent = new Intent(this, mainSelection.class);
        startActivity(intent);
    }

}
