package com.kausar.hp.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebActivity extends AppCompatActivity {
    EditText etWebAddress;
    Button btnExplore, btnCancelWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        etWebAddress = findViewById(R.id.etweb);
        btnExplore = findViewById(R.id.btnexploreweb);
        btnCancelWeb = findViewById(R.id.btncancelweb);

        btnExplore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etWebAddress.getText().toString().trim();
                if(text.isEmpty())
                {
                    Toast.makeText(WebActivity.this, "Please Provide web address", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String webLink = "https://" + text;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(webLink));
                    startActivity(intent);
                }


            }
        });

        btnCancelWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WebActivity.this, com.kausar.hp.intentapplication.MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
