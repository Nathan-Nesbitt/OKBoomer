package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class message_general extends AppCompatActivity implements MyAdapter.ContactViewHolder.OnUserListener {


    private RecyclerView recyclerView;
    private RecyclerView matchRecyclerView;
    //private CardAdapter adapter;
    private RecyclerView.Adapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<String> usersCW;
    ArrayList<Integer> img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_general);

        //set up recycler view for messages
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);

        //initialize arrayLists for values (eventually replace with values from the database)
        usersCW = new ArrayList<>();
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
        img = new ArrayList<>();
        img.add((R.drawable.bob));
        img.add((R.drawable.dot));
        img.add((R.drawable.steve));
        img.add((R.drawable.carl));
        img.add((R.drawable.lorrain));
        img.add((R.drawable.harry));
        img.add((R.drawable.beverly));
        //send to recycler
        myAdapter.setItems(usersCW, time, msg, img, this);

        //set up recycler for matches
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        matchRecyclerView = (RecyclerView) findViewById(R.id.my_matches);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        matchRecyclerView.setLayoutManager(layoutManager);
        matchesAdapter matchAdapter = new matchesAdapter();
        matchRecyclerView.setAdapter(matchAdapter);

        //initialize arrayList for values  (eventually replace with values from database)
        ArrayList<String> userMatches = new ArrayList<>();
        userMatches.add("Alice");
        userMatches.add("Dot");
        userMatches.add("Steve");
        userMatches.add("Carl");
        userMatches.add("Lorraine");
        userMatches.add("Harry");
        userMatches.add("Beverly");
        ArrayList<Integer> matchImg = new ArrayList<>();
        matchImg.add((R.drawable.alice));
        matchImg.add((R.drawable.dot));
        matchImg.add((R.drawable.steve));
        matchImg.add((R.drawable.carl));
        matchImg.add((R.drawable.lorrain));
        matchImg.add((R.drawable.harry));
        matchImg.add((R.drawable.beverly));

        matchAdapter.setItems(userMatches, matchImg);

    }


    @Override
    public void onUserClick(int position) {
        String user = usersCW.get(position);
        int id = img.get(position);
        Intent intent = new Intent(this, specific_chat.class);
        intent.putExtra("name", user);
        intent.putExtra("picID", id);
        startActivity(intent);
    }
}
