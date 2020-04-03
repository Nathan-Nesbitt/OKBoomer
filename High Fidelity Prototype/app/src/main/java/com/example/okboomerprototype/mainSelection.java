package com.example.okboomerprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class mainSelection extends AppCompatActivity {
    int cUser;
    String name;
    String email;
    Intent user;
    ImageView pic1;
    ImageView pic2;
    ImageView pic3;
    ImageView pic4;
    TextView n;
    TextView d;
    TextView age;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_selection);
//        ImageView img = findViewById(R.id.imageView8);
//        cUser = img.getId();
        text = (TextView) findViewById(R.id.textView3);
        name = (String) text.getText();
        user = getIntent();
        email = user.getStringExtra("email");
        pic1 = findViewById(R.id.imageView8);
        pic2 = findViewById(R.id.imageView9);
        pic3 = findViewById(R.id.imageView10);
        pic4 = findViewById(R.id.imageView11);
        d = findViewById(R.id.textView5);
        age = findViewById(R.id.textView6);
        age.setText("74");
    }
    public void chatGeneral(View view){
        Intent intent = new Intent(this, message_general.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }
    public void toUser(View view){
        Intent intent = new Intent(this, profilePage.class);
        intent.putExtra("email", email);
        startActivity(intent);
    }

    public void matchScreen(View view){
        Intent intent = new Intent(this, matchScreen.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        // super.onBackPressed();
        Toast.makeText(this,"There is no back action",Toast.LENGTH_LONG).show();
        return;
    }

    public void dislike(View view){
        if(text.getText().toString() == "Sophie"){
            text.setText("Chester");
            name = (String) text.getText();
            d.setText("15km");
            age.setText("68");
            pic1.setImageResource(R.drawable.chester1);
            pic2.setImageResource(R.drawable.chester2);
            pic3.setImageResource(R.drawable.chester3);
            pic4.setImageResource(R.drawable.chester4);
        }else{
            text.setText("Sophie");
            name = (String) text.getText();
            d.setText("45km");
            age.setText("74");
            pic1.setImageResource(R.drawable.sophie2);
            pic2.setImageResource(R.drawable.sophie3);
            pic3.setImageResource(R.drawable.sophie4);
            pic4.setImageResource(R.drawable.sophie5);
        }
    }

}
