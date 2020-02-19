package com.example.robofest2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactUsActivity extends AppCompatActivity {

    private Button submit;
    private TextView textContact,desContact;
    private EditText input_name,input_email,input_query;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        textContact = findViewById(R.id.textContact);
        desContact = findViewById(R.id.desContact);
        input_name = findViewById(R.id.input_name);
        input_email = findViewById(R.id.input_email);
        input_query = findViewById(R.id.input_query);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ContactUsActivity.this,"Response Submitted successfully!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
