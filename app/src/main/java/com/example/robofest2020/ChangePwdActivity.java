package com.example.robofest2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePwdActivity extends AppCompatActivity {

    private TextView textChangePwd , desChangePwd;
    private EditText inputOldPwd , inputNewPwd , inputConfirmPwd;
    private Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        textChangePwd = findViewById(R.id.textChangePwd);
        desChangePwd = findViewById(R.id.desChangePwd);
        inputOldPwd = findViewById(R.id.inputOldPwd);
        inputConfirmPwd = findViewById(R.id.confirmNewPwd);
        inputNewPwd = findViewById(R.id.inputNewPwd);
        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ChangePwdActivity.this,"Password Changed Successfully ",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
