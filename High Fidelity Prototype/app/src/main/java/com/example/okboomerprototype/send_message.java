package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class send_message extends AppCompatActivity {
    String name;
    int picID = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        picID = intent.getIntExtra("picID", 0);

    }
    @Override
    public void onBackPressed(){
        // super.onBackPressed();
        Toast.makeText(this,"There is no back action",Toast.LENGTH_LONG).show();
        return;
    }

    public void toMessage(View view){
        Intent intent = new Intent(this, specific_chat.class);
        intent.putExtra("name", name );
        intent.putExtra("picID", picID);
        intent.putExtra("fromId", 1);
        startActivity(intent);
    }
    public void backMain(View view){
        Intent intent = new Intent(this, mainSelection.class);
        startActivity(intent);
    }
}
