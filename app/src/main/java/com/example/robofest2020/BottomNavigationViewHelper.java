package com.example.robofest2020;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;

public class BottomNavigationViewHelper {
    public static void enableNavigation(final Context context , BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.home:
                        Intent intent1 = new Intent(context,HomeActivity.class);
                        context.startActivity(intent1);
                        break;

                    case R.id.roboexpo:
                        Intent intent2 = new Intent(context,ExpoActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.robothon:
                        Intent intent3 = new Intent(context,HackathonActivity.class);
                        context.startActivity(intent3);
                        break;

                    case R.id.settings:
                        Intent intent4 = new Intent(context,SettingsActivity.class);
                        context.startActivity(intent4);
                        break;

                }

                return false;
            }
        });
    }
}
