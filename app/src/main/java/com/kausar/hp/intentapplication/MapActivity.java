package com.kausar.hp.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MapActivity extends AppCompatActivity {
    EditText etFindMap;
    Button btnSubmitMap, btnCancelMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        etFindMap = findViewById(R.id.etmap);
        btnSubmitMap = findViewById(R.id.btnfindmap);
        btnCancelMap = findViewById(R.id.btncancelmap);

        btnSubmitMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = etFindMap.getText().toString();
                if(text.isEmpty())
                {
                    Toast.makeText(MapActivity.this, "Please Enter location", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String mapLocation = "geo:0,0?q=" + text;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapLocation));
                    startActivity(intent);
                }


            }
        });

        btnCancelMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapActivity.this, com.kausar.hp.intentapplication.MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
