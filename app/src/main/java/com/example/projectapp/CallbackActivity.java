package com.example.projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.sawolabs.androidsdk.ConstantsKt;

public class CallbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        Intent intent = getIntent();
        String message = intent.getStringExtra(ConstantsKt.LOGIN_SUCCESS_MESSAGE);
    }
}