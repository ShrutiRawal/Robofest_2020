package com.example.robofest2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class SponsorsActivity extends AppCompatActivity {

    WebView achievements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        achievements = (WebView)findViewById(R.id.achievements);
        achievements.loadUrl("https://www.robotix.nitrr.ac.in/achievements/");
    }
}
