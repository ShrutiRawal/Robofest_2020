package com.example.robofest2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class EventsActivity extends AppCompatActivity {

    WebView loadEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        loadEvents = findViewById(R.id.loadEvent);
        loadEvents.loadUrl("https://www.robotix.nitrr.ac.in/events/");
    }
}
