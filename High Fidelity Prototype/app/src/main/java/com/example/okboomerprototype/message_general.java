package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class message_general extends AppCompatActivity {

    
    private RecyclerView chatsList;

    private DatabaseReference ChatsRef, UsersRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_general);

        //chatsList = (RecyclerView) findViewById(R.id.chats_list);
        //chatsList.setLayoutManager(new LinearLayoutManager());
    }



}
