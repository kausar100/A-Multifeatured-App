package com.kausar.hp.intentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    EditText etName, etNumber, etID;
    Button btnSubmit, btnCancel;
    String KEY = "profile info";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        etName = findViewById(R.id.etname);
        etNumber = findViewById(R.id.etphn);
        etID = findViewById(R.id.etidn);
        btnSubmit = findViewById(R.id.btnsubmit);
        btnCancel = findViewById(R.id.btncancel);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cr, cn, cg;
                String phoneNumber = null, idNumber = null, bod = null, gender, nationality, religious, checkGender = null, checkNationality = null, checkReligious  = null;
                String name = etName.getText().toString();
                if(name.isEmpty())
                {
                    Toast.makeText(ProfileActivity.this, "Please Enter your name", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    phoneNumber = etNumber.getText().toString();
                    if(phoneNumber.isEmpty())
                    {
                        Toast.makeText(ProfileActivity.this, "Please Enter your phone number", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        idNumber = etID.getText().toString();
                        if(idNumber.isEmpty())
                        {
                            Toast.makeText(ProfileActivity.this, "Please Enter your ID number", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            bod = idNumber.substring(0,6);

                            //male, female, other(1, 2, 3)
                            gender = Character.toString(idNumber.charAt(6));

                            //bangladeshi, foreigner(1,2)
                            nationality = Character.toString(idNumber.charAt(7));

                            //islam, hindu, boddha, khristan(11,00,01,10)
                            religious = idNumber.substring(8,10);

                            cn = Integer.parseInt(nationality);
                            switch (cn)
                            {
                                case 1:
                                    checkNationality = "Bangladeshi";
                                    break;
                                case 2:
                                    checkNationality = "Foreigner";
                                    break;
                                default:
                                    checkNationality = "Don't know";
                            }

                            cg = Integer.parseInt(gender);
                            switch (cg)
                            {
                                case 1:
                                    checkGender = "Male";
                                    break;
                                case 2:
                                    checkGender = "Female";
                                    break;
                                case 3:
                                    checkGender = "Other";
                                    break;
                                default:
                                    checkGender = "Don't know";
                            }

                            cr = Integer.parseInt(religious);
                            if(cr == 11)
                            {
                                checkReligious = "Islam";
                            }
                            else if(cr == 01)
                            {
                                checkReligious = "Boddha";
                            }
                            else if(cr == 10)
                            {
                                checkReligious = "Khristan";
                            }
                            else
                            {
                                checkReligious = "Hindu";

                            }
                            String result = "Name : " + name + "\n" +
                                    "Phone No: " + phoneNumber + "\n" +
                                    "Birthday : " + bod + "\n" +
                                    "Gender : " + checkGender + "\n" +
                                    "Nationality : " + checkNationality + "\n" +
                                    "Religious : " + checkReligious;


                            Intent intent = new Intent();
                            intent.putExtra(KEY, result);
                            setResult(RESULT_OK, intent);
                            ProfileActivity.this.finish();
                        }
                    }

                }

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                ProfileActivity.this.finish();
            }
        });
    }
}
