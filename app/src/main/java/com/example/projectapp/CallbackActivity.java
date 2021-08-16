package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sawolabs.androidsdk.ConstantsKt;

public class CallbackActivity extends AppCompatActivity {
    private ImageView carryImg, twitterImg, insta, linkedin, twitch, tiktok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        carryImg = findViewById(R.id.carryImg);
        twitterImg = findViewById(R.id.twitter);
        insta = findViewById(R.id.insta);
        linkedin = findViewById(R.id.linkedin);
        twitch = findViewById(R.id.twitch);
        tiktok = findViewById(R.id.tiktok);
        Intent intent = getIntent();
        String message = intent.getStringExtra(ConstantsKt.LOGIN_SUCCESS_MESSAGE);
        clickYoutube();
        clickTwitter();
        clickInsta();
        clickLinkedin();
        clickTwitch();
        clickTiktok();
    }

    private void clickYoutube(){
        carryImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CallbackActivity.this, YoutubeActivity.class));
                finish();
            }
        });
    }

    private void clickTwitter(){
        twitterImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CallbackActivity.this, YoutubeActivity.class));
                finish();
            }
        });
    }

    private void clickInsta(){
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CallbackActivity.this, YoutubeActivity.class));
                finish();
            }
        });
    }

    private void clickLinkedin(){
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CallbackActivity.this, YoutubeActivity.class));
                finish();
            }
        });
    }

    private void clickTwitch(){
        twitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CallbackActivity.this, YoutubeActivity.class));
                finish();
            }
        });
    }

    private void clickTiktok(){
        tiktok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CallbackActivity.this, YoutubeActivity.class));
                finish();
            }
        });
    }
}