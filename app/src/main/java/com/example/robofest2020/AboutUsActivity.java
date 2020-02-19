package com.example.robofest2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUsActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView whoAreWe , whoAreWeText , vision , visionText , whatDoWeDo , whatDoWeDoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        logo = findViewById(R.id.logo);
        whoAreWe = findViewById(R.id.whoAreWe);
        whoAreWeText = findViewById(R.id.whoAreWeText);
        vision = findViewById(R.id.vision);
        visionText = findViewById(R.id.visionText);
        whatDoWeDo = findViewById(R.id.whatDoWeDo);
        whatDoWeDoText = findViewById(R.id.whatDoWeDoText);
    }
}
