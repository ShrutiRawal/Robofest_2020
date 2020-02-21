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
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText input_name,input_email,input_password,input_cnfPassword,input_phone;
    private Button register;
    private AuthResponseR authResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        input_name = findViewById(R.id.input_name);
        input_password = findViewById(R.id.input_password);
        input_email = findViewById(R.id.input_email);
        input_cnfPassword = findViewById(R.id.input_cnfPassword);
        input_phone = findViewById(R.id.input_phone);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = input_name.getText().toString();
                String password = input_password.getText().toString();
                String cnfPassword = input_cnfPassword.getText().toString();
                String phone = input_phone.getText().toString();
                String email = input_email.getText().toString();
                if (validateRegister(email,name,phone,password,cnfPassword))
                {
                    RegisterApiCall();
                }
            }
        });

    }

    private void RegisterApiCall() {

        RegisterDetails details = new RegisterDetails(input_name.getText().toString().trim(),input_email.getText().toString().trim(),
        input_phone.getText().toString().trim(),input_password.getText().toString().trim(),
                input_cnfPassword.getText().toString());

        Call<AuthResponseR> call = AppClient.getInstance().createService(APIServices.class).postRegisterUser(details);
        call.enqueue(new Callback<AuthResponseR>() {
            @Override
            public void onResponse(Call<AuthResponseR> call, Response<AuthResponseR> response) {
                try {
                    if (getApplicationContext() != null) {
                        if (response.isSuccessful()) {
                            if (response.body() != null) {
                                authResponse = response.body();
                                Toast.makeText(RegisterActivity.this, "Please verify your email to proceed",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Sorry! Couldn't Register You. Please try again.",Toast.LENGTH_SHORT).show();
                                Log.e("LoginActivity Register", "Response Successful, Response Body NULL");
                            }
                        } else if (response.code() == 400) {
                            Toast.makeText(getApplicationContext(), "User with this email already exists.",Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(RegisterActivity.this, "Sorry! Couldn't Register You. Please try again in some time.",Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<AuthResponseR> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Registration failed!."+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean validateRegister(String email, String name, String phone, String password, String cnfPassword) {
        if(name == null || name.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0 || password.length()<6){
            Toast.makeText(this, "Password is required and it should be greater than 6 characters", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(email == null || email.trim().length() == 0){
            Toast.makeText(this, "E-mail is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(phone == null || phone.trim().length() == 0){
            Toast.makeText(this, "Contact number is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(cnfPassword == null || cnfPassword.trim().length() == 0){
            Toast.makeText(this, "Confirm password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
