package com.kausar.hp.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CallFriendActivity extends AppCompatActivity {
    EditText editText;
    Button btnSubmitCall, btnCancelCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_friend);

        editText = findViewById(R.id.etphncall);
        btnSubmitCall = findViewById(R.id.btnfriendcall);
        btnCancelCall = findViewById(R.id.btncancelcall);

        btnSubmitCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String number = editText.getText().toString().trim();
                if(number.isEmpty())
                {
                    Toast.makeText(CallFriendActivity.this, "Please Enter your friend phone number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String phoneNumber = "tel:" + number;
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));
                    startActivity(intent);
                }

            }
        });

        btnCancelCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CallFriendActivity.this, com.kausar.hp.intentapplication.MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
