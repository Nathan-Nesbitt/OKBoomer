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
    Uri i1;
    Uri i2;
    Uri i3;
    Uri i4;
    Uri i5;
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

    }
    public void create_account(View view){
        image5 =  findViewById(R.id.image5);
        image1.setTag(R.drawable.stewart0);
        img1 = (Integer) image1.getTag();
        image2.setTag(R.drawable.stewart1);
        img2 = (Integer) image2.getTag();
        image3.setTag(R.drawable.stewart2);
        img3 = (Integer) image3.getTag();
        image4.setTag(R.drawable.stewart3);
        img4 = (Integer) image4.getTag();
        image5.setTag(R.drawable.stewart4);
        img5 = (Integer) image1.getTag();
        String filename = "userImageTags.txt";
        FileOutputStream outputStream;
        String fileContents = email + "," + img1+"," + img2+","+img3+","+img4+","+img5+","+i1+","+i2+","+i3+","+i4+","+i5+","+"\n";

        //allow a file to be opened for writing
        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
            Intent intent = new Intent(getApplicationContext(), create_account4.class);
            intent.putExtra("email", email);
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
                    i1 = (Uri) image1.getTag();break;
                case 2: image2.setImageURI(imageUri);image2.setTag(imageUri);
                    i2 = (Uri) image2.getTag();break;
                case 3: image3.setImageURI(imageUri);image3.setTag(imageUri);
                    i3 = (Uri) image3.getTag();break;
                case 4: image4.setImageURI(imageUri);image4.setTag(imageUri);
                    i4 = (Uri) image4.getTag(); break;
                case 5: image5.setImageURI(imageUri);image5.setTag(imageUri);
                    i5 = (Uri) image5.getTag();;
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
