package com.example.robofest2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ExpoActivity extends AppCompatActivity {

    private TextView textRobo , desRobo;
    private Button applyRobo;

    private static final int ActivityNum = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expo);
        setUpBottomNavigationView();
        textRobo = findViewById(R.id.textRobo);
        desRobo = findViewById(R.id.desRobo);
        applyRobo = findViewById(R.id.applyrobo);
        applyRobo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpoActivity.this,EventsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setUpBottomNavigationView(){
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.enableNavigation(ExpoActivity.this,bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(ActivityNum);
        menuItem.setChecked(true);
    }

}
