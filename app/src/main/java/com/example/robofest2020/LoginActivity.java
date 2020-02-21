package com.example.robofest2020;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText input_email,input_password,input_username;
    private Button login;
    private ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        input_password = findViewById(R.id.input_password);
        input_username = findViewById(R.id.input_username);
        input_email = findViewById(R.id.input_email);
        logo = findViewById(R.id.logo);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = input_username.getText().toString();
                String email = input_email.getText().toString();
                String password = input_password.getText().toString();
                if (validateLogin(username,email,password))
                {
                    LoginApiCall();
                }
            }
        });


    }

    private void LoginApiCall() {

        LoginDetails details = new LoginDetails(input_username.getText().toString(),input_email.getText().toString(),input_password.getText().toString());
        Call<AuthResponseL> call = AppClient.getInstance().createService(APIServices.class).postLoginUser(details);
        call.enqueue(new Callback<AuthResponseL>() {
            @Override
            public void onResponse(Call<AuthResponseL> call, Response<AuthResponseL> response) {
                try {
                    if (getApplicationContext() != null) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                AuthResponseL authResponse = response.body();
                                // pref.setSharedPref(LoginActivity.this, authResponse.getToken(), authResponse.getFirstName(),
                                //       authResponse.getLastName(), loginEmail.getText().toString());
                                //pref.setIsLoggedIn(LoginActivity.this, true);
                                // Log.e("LoginActivity Login", response.body().getMessage());
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } else
                                Toast.makeText(LoginActivity.this, "Couldn't log you in. Please try again.",Toast.LENGTH_SHORT).show();
                        } else if(response.code() == 400){
                            Toast.makeText(LoginActivity.this, "Invalid Credentials!",Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(LoginActivity.this, "Couldn't log you in. Please try again later.",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<AuthResponseL> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "An Error occurred while logging you in. Please try again in a while!",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void LinkClicked(View view) {
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    public void ForgotClicked(View view) {
        Intent intent = new Intent(LoginActivity.this,ForgetPwdActivity.class);
        startActivity(intent);
    }

    private boolean validateLogin(String name,String email, String password){
        if(name == null || name.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(email == null || email.trim().length() == 0){
            Toast.makeText(this, "E-mail is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
