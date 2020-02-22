package com.example.robofest2020;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                Call<AuthResponseLO> call = AppClient.getInstance().createService(APIServices.class).postLogout();
                call.enqueue(new Callback<AuthResponseLO>() {
                    @Override
                    public void onResponse(Call<AuthResponseLO> call, Response<AuthResponseLO> response) {
                        try {
                            if (getApplicationContext() != null) {
                                if (response.isSuccessful()) {
                                    if (response.body() != null) {
                                        AuthResponseLO authResponse = response.body();
                                        // pref.setSharedPref(LoginActivity.this, authResponse.getToken(), authResponse.getFirstName(),
                                        //       authResponse.getLastName(), loginEmail.getText().toString());
                                        //pref.setIsLoggedIn(LoginActivity.this, true);
                                        // Log.e("LoginActivity Login", response.body().getMessage());
                                        Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else
                                        Toast.makeText(LogoutActivity.this, "Couldn't log you out. Please try again.",Toast.LENGTH_SHORT).show();
                                } else if(response.code() == 400){
                                    Toast.makeText(LogoutActivity.this, "Invalid Credentials!",Toast.LENGTH_SHORT).show();
                                } else
                                    Toast.makeText(LogoutActivity.this, "Couldn't log you out. Please try again later.",Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthResponseLO> call, Throwable t) {
                        Toast.makeText(LogoutActivity.this, "An Error occurred while logging you out. Please try again in a while!",Toast.LENGTH_SHORT).show();
                    }
                });
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
