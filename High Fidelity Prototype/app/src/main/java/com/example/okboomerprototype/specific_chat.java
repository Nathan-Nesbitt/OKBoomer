package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class specific_chat extends AppCompatActivity {
    Intent intent;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    ArrayList<Message> msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_chat);
        intent = getIntent();
        String userName = intent.getStringExtra("name");
        int picID = intent.getIntExtra("picID", 0);
        //Button b = findViewById(R.id.button_chatbox_send);

        //int picID = 0;
//        switch(userName){
//            case "Bob": picID = R.drawable.bob; break;
//            case "Dot": picID = R.drawable.dot; break;
//            case "Steve": picID = R.drawable.steve; break;
//            case "Carl": picID = R.drawable.carl; break;
//            case "Lorraine": picID = R.drawable.lorrain; break;
//            case "Harry": picID = R.drawable.harry; break;
//            case "Beverly": picID = R.drawable.beverly;
//        }
        //initialize arrayLists for values (eventually replace with values from the database)
        msg = new ArrayList<>();
        Message m = new Message();
        m.setUserName(userName);
       // b.setText(m.getUserName());
        m.setImg(picID);
        m.setTime("7:45");
        m.setMsg("Hey there ;)");
        msg.add(m);
        m = new Message();
        m.setMsg("Hello hello");
        m.setTime("8:01");
        msg.add(m);

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
        Intent intent = new Intent(this, message_general.class);
        startActivity(intent);
    }

    public void backMain(View view){
        Intent intent = new Intent(this, mainSelection.class);
        startActivity(intent);
    }

}
