package com.example.okboomerprototype;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class edit_profile extends AppCompatActivity {
    Button remove1;
    Button remove2;
    Button remove3;
    Button remove4;
    //17,20,19,18
    static ImageView image1;
    static ImageView image2;
    static ImageView image3;
    static ImageView image4;
    static int picRemove = 0;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        image1 = (ImageView) findViewById(R.id.imageView17);
        image2 = (ImageView) findViewById(R.id.imageView20);
        image3 = (ImageView) findViewById(R.id.imageView19);
        image4 = (ImageView) findViewById(R.id.imageView18);
        remove1 = (Button) findViewById(R.id.remove1);
        remove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picRemove = 1;
                removePicDialog();
            }
        });
        remove2 = (Button) findViewById(R.id.remove2);
        remove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picRemove = 2;
                removePicDialog();
            }
        });
        remove3 = (Button) findViewById(R.id.remove3);
        remove3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picRemove = 3;
                removePicDialog();
            }
        });
        remove4 = (Button) findViewById(R.id.remove4);
        remove4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                picRemove = 4;
                removePicDialog();
            }
        });
    }
    public void toProfile(View view){
        finish();
    }
    public void backMain(View view){
        Intent intent = new Intent(this, mainSelection.class);
        startActivity(intent);
    }
    public void chatGeneral(View view){
        Intent intent = new Intent(this, message_general.class);
        startActivity(intent);
    }
    public void addPic(View view){
        openGallery();
    }
    public void removePicDialog(){

        remove_pic_dialog removePic = new remove_pic_dialog();
        removePic.show(getSupportFragmentManager(), "remove pic");

    }
    public void returnProfile(View view){
//        image1.setImageResource(R.drawable.stewart1);
//        image2.setImageResource(R.drawable.stewart2);
//        image3.setImageResource(R.drawable.stewart3);
//        image1.setImageResource(R.drawable.stewart4);
        Intent intent = new Intent(this, profilePage.class);
        startActivity(intent);
    }
    public void saveChanges(View view){
        save_dialogue save = new save_dialogue();
        save.show(getSupportFragmentManager(), "save changes");
    }
    public void deleteAccount(View view){
        delete_dialogue del = new delete_dialogue();
        del.show(getSupportFragmentManager(), "delete account");
    }

    public static void returnVal(int i){
        if(i == 1){
            switch(picRemove){
                case 1: image1.setImageResource(R.drawable.ic_image_black_biggerdp);break;
                case 2: image2.setImageResource(R.drawable.ic_image_black_biggerdp);break;
                case 3: image3.setImageResource(R.drawable.ic_image_black_biggerdp);break;
                case 4: image4.setImageResource(R.drawable.ic_image_black_biggerdp);
            }
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
            image4.setImageURI(imageUri);
        }
    }
}
