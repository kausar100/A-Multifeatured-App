package com.kausar.hp.intentapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnProfile, btnCallFriend, btnMap, btnWeb;
    TextView showProfile;
    final int PROFILE_ACTIVITY = 100;
    String KEY = "profile info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfile = findViewById(R.id.btnprofile);
        btnCallFriend = findViewById(R.id.btncall);
        btnMap = findViewById(R.id.btnmap);
        showProfile = findViewById(R.id.tvID);
        btnWeb = findViewById(R.id.btnweb);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.kausar.hp.intentapplication.ProfileActivity.class);
                startActivityForResult(intent,PROFILE_ACTIVITY);
            }
        });

        btnCallFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, com.kausar.hp.intentapplication.CallFriendActivity.class);
                startActivity(intent);

            }
        });

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.kausar.hp.intentapplication.MapActivity.class);
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, com.kausar.hp.intentapplication.WebActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PROFILE_ACTIVITY)
        {
            if(resultCode == RESULT_OK)
            {
                showProfile.setText(data.getStringExtra(KEY));
                showProfile.setVisibility(View.VISIBLE);
            }
            if(resultCode == RESULT_CANCELED)
            {
                showProfile.setText("No Data Found for Profile");
                showProfile.setVisibility(View.VISIBLE);
            }
        }
    }
}
