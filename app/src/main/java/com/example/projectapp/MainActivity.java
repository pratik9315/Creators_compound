package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sawolabs.androidsdk.Sawo;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ImageView infoBtn;
    TextView admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnLogin);
        infoBtn = findViewById(R.id.infoBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Sawo(
                        MainActivity.this,
                        "c269d2ce-d47e-4ebe-82d3-df376c2abcc1", // your api key,
                        "61175e8224db1bf9f718231ezCUXbfFWHGFmmJMmdw9XedgR" // your api key secret
                ).login(
                        "email", // can be one of 'email' or 'phone_number_sms'
                        CallbackActivity.class.getName()  // Callback class name
                );
            }

        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://fest.devsoc.club/";
                openWebPage(url);
            }
        });
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}