package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;

import java.sql.Array;
import java.util.ArrayList;

public class message_general extends AppCompatActivity {


    private RecyclerView recyclerView;
    //private CardAdapter adapter;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_general);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        ArrayList<String> usersCW = new ArrayList<>();
        usersCW.add("Bob");
        usersCW.add("Dot");
        usersCW.add("Steve");
        usersCW.add("Carl");
        usersCW.add("Lorraine");
        usersCW.add("Harry");
        usersCW.add("Beverly");
        ArrayList<String> time = new ArrayList<>();
        time.add("1 minute ago");
        time.add("5 minutes ago");
        time.add("50 minutes ago");
        time.add("3 hours ago");
        time.add("20 hours ago");
        time.add("1 day ago");
        time.add("03/16/20");
        ArrayList<String> msg = new ArrayList<>();
        msg.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        msg.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        msg.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        msg.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        msg.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        msg.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        msg.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");

        ArrayList<Integer> img = new ArrayList<>();
        img.add((R.drawable.bob));
        img.add((R.drawable.dot));
        img.add((R.drawable.steve));
        img.add((R.drawable.carl));
        img.add((R.drawable.lorrain));
        img.add((R.drawable.harry));
        img.add((R.drawable.beverly));

        myAdapter.setItems(usersCW, time, msg, img);

        }
    }
