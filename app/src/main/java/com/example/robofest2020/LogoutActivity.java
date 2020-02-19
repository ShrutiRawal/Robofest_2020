package com.example.robofest2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LogoutActivity extends AppCompatActivity {

    private TextView textLogout , confirmLogout;
    private Button yesLogout , noLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        textLogout = findViewById(R.id.textLogout);
        confirmLogout = findViewById(R.id.confirmLogout);
        yesLogout = findViewById(R.id.yesLogout);
        noLogout = findViewById(R.id.noLogout);
        yesLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LogoutActivity.this,"LogOut Successful",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LogoutActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        noLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogoutActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
