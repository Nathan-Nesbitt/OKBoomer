package com.example.okboomerprototype;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.FileOutputStream;

public class create_account3 extends AppCompatActivity {
    Intent intent;
    String email;
    ImageButton image1;
    ImageButton image2;
    ImageButton image3;
    ImageButton image4;
    ImageButton image5;
    int img1;
    int img2;
    int img3;
    int img4;
    int img5;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    int changePic = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account3);
        intent = getIntent();
        email = intent.getStringExtra("email");
        image1 = (ImageButton) findViewById(R.id.image1);
        image2 = (ImageButton) findViewById(R.id.image2);
        image3 = (ImageButton) findViewById(R.id.image3);
        image4 = (ImageButton) findViewById(R.id.image4);
        image5 =  findViewById(R.id.image5);
        image1.setImageResource(R.drawable.stewart0);
        image1.setTag(R.drawable.stewart0);
        img1 = (Integer) image1.getTag();
        image2.setImageResource(R.drawable.stewart1);
        image2.setTag(R.drawable.stewart1);
        img2 = (Integer) image2.getTag();
        image3.setImageResource(R.drawable.stewart2);
        image3.setTag(R.drawable.stewart2);
        img3 = (Integer) image3.getTag();
        image4.setImageResource(R.drawable.stewart3);
        image4.setTag(R.drawable.stewart3);
        img4 = (Integer) image4.getTag();
        image5.setImageResource(R.drawable.stewart4);
        image5.setTag(R.drawable.stewart4);
        img5 = (Integer) image1.getTag();
    }
    public void create_account(View view){
        String filename = "userInfo.txt";
        FileOutputStream outputStream;
        String fileContents = email + "," + img1+"," + img2+","+img3+","+img4+","+img5+","+"\n";

        //allow a file to be opened for writing
        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
            Intent intent = new Intent(getApplicationContext(), create_account3.class);
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            switch(changePic){
                case 1: image1.setImageURI(imageUri);image1.setTag(imageUri);
                    img1 = (Integer) image1.getTag();break;
                case 2: image2.setImageURI(imageUri);image2.setTag(imageUri);
                    img2 = (Integer) image2.getTag();break;
                case 3: image3.setImageURI(imageUri);image3.setTag(imageUri);
                    img3 = (Integer) image3.getTag();break;
                case 4: image4.setImageURI(imageUri);image4.setTag(imageUri);
                    img4 = (Integer) image4.getTag(); break;
                case 5: image5.setImageURI(imageUri);image5.setTag(imageUri);
                    img5 = (Integer) image5.getTag();;
            }
        }
    }
    public void changePhoto1(View view){
        changePic = 1;
        openGallery();
    }
    public void changePhoto2(View view){
        changePic = 2;
        openGallery();
    }
    public void changePhoto3(View view){
        changePic = 3;
        openGallery();
    }
    public void changePhoto4(View view){
        changePic = 4;
        openGallery();
    }
    public void changePhoto5(View view){
        changePic = 5;
        openGallery();
    }
}
