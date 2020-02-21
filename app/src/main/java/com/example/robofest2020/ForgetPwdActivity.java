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
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class ForgetPwdActivity extends AppCompatActivity {

    private TextView textVerify , textChange;
    private EditText inputEmail;
    private Button go;
    private String change = "Cp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        textVerify = findViewById(R.id.textVerify);
        textChange = findViewById(R.id.textChange);
        inputEmail = findViewById(R.id.inputEmail);
        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputEmail!=null)
                {
                    resetPasswordApi();
                }
            }
        });
    }

    private void resetPasswordApi() {

        FPDetails details = new FPDetails(inputEmail.getText().toString());
        Call<AuthResponseFP> call = AppClient.getInstance().createService(APIServices.class).postForgotPass(details);
        call.enqueue(new Callback<AuthResponseFP>() {
            @Override
            public void onResponse(Call<AuthResponseFP> call, Response<AuthResponseFP> response) {
                if(response.isSuccessful()) {
                    Log.e("tag", "response successful");
                    if(response.body() != null) {
                        Log.e(change, "response body received");
                        Toast.makeText(ForgetPwdActivity.this,"Please verify your email to proceed",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ForgetPwdActivity.this, LoginActivity.class));
                    } else {
                        Log.e(change, "Response Body Null");
                    }
                } else {
                    try {
                        if (response.errorBody() != null) {
                            Log.e(change, "ErrorBodyToasted");
                            //JSONObject object = new JSONObject(response.errorBody().string());
                            //if(object.getString("message") != null)
                              //  Utils.showLongToast(getContext(), object.getString("message"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<AuthResponseFP> call, Throwable t) {
                Toast.makeText(ForgetPwdActivity.this,"something went wrong"+t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}
