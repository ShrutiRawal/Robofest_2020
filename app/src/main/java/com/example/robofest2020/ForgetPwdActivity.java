package com.example.robofest2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPwdActivity extends AppCompatActivity {

    private TextView textVerify , textChange;
    private EditText inputEmail;
    private Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        textVerify = findViewById(R.id.textVerify);
        textChange = findViewById(R.id.textChange);
        inputEmail = findViewById(R.id.inputEmail);
        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ForgetPwdActivity.this,"Please open your mail to proceed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
