package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class specific_chat extends AppCompatActivity {
    Intent intent;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter recyclerAdapter;
    ArrayList<String> name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_chat);
        intent = getIntent();
        String userName = intent.getStringExtra("name");
        //int picID = Integer.parseInt(intent.getStringExtra("picID"));
        //set up recycler view for messages
        recyclerView = (RecyclerView) findViewById(R.id.reyclerview_message_list);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        messageAdapter mA = new messageAdapter();
        recyclerView.setAdapter(mA);

        //initialize arrayLists for values (eventually replace with values from the database)
        name = new ArrayList<>();
        name.add(userName);
        name.add("");
        name.add(userName);
        name.add("");
        name.add(userName);
        name.add("");
        name.add(userName);
        ArrayList<String> time = new ArrayList<>();
        time.add("7:45");
        time.add("");
        time.add("11:30");
        time.add("");
        time.add("1:00");
        time.add("");
        time.add("5:22");
        ArrayList<String> msg = new ArrayList<>();
        msg.add("Hey there ;)");
        msg.add("Hello hello");
        msg.add("How's your day been?");
        msg.add("Fairly good, just doing some housework. How has yours been?");
        msg.add("Pretty good, I have been baking.");
        msg.add("Oh nice! What is your favourite thing to bake?");
        msg.add("I have been baking a lot of bread recently, working with yeast is fun :)");
        ArrayList<Integer> img = new ArrayList<>();
        int picID = 0;
        switch(userName){
            case "Bob": picID = R.drawable.bob;
            case "Dot": picID = R.drawable.dot;
            case "Steve": picID = R.drawable.steve;
            case "Carl": picID = R.drawable.carl;
            case "Lorraine": picID = R.drawable.lorrain;
            case "Harry": picID = R.drawable.harry;
            case "Beverly": picID = R.drawable.beverly;
        }
        img.add((picID));
        img.add((0));
        img.add((picID));
        img.add((0));
        img.add(picID);
        img.add(0);
        img.add(picID);
        //send to recycler
        mA.setItems(name, time, msg, img);

    }
}
