package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class matchScreen extends AppCompatActivity {
    Intent intent;
    Button b;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_screen);
//        intent = getIntent();
//        int img = Integer.parseInt(intent.getStringExtra("userPic"));
        ImageView i = findViewById(R.id.matchee);
        i.setImageResource(R.drawable.sophie);
    }

    public void sendSelfie(View view){
        intent = new Intent(this, takeSelfie.class);
        startActivity(intent);
    }

}
