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

public class ChangePwdActivity extends AppCompatActivity {

    private TextView textChangePwd , desChangePwd;
    private EditText inputOldPwd , inputNewPwd , inputConfirmPwd;
    private Button go;
    private String change = "Cp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pwd);
        textChangePwd = findViewById(R.id.textChangePwd);
        desChangePwd = findViewById(R.id.desChangePwd);
        inputOldPwd = findViewById(R.id.inputOldPwd);
        inputConfirmPwd = findViewById(R.id.confirmNewPwd);
        inputNewPwd = findViewById(R.id.inputNewPwd);
        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldPass = inputOldPwd.getText().toString();
                String newPass1 = inputNewPwd.getText().toString();
                String newPass2 = inputConfirmPwd.getText().toString();
                if (validate(oldPass,newPass1,newPass2));
                {
                    changePassApi();
                }
            }
        });
    }

    private void changePassApi() {
        CPDetails details = new CPDetails(inputOldPwd.getText().toString().trim(),inputNewPwd.getText().toString().trim(),inputConfirmPwd.getText().toString());
        Call<AuthResponseCP> call = AppClient.getInstance().createService(APIServices.class).postChangePass(details);
        call.enqueue(new Callback<AuthResponseCP>() {
            @Override
            public void onResponse(Call<AuthResponseCP> call, Response<AuthResponseCP> response) {
                if(response.isSuccessful()) {
                    Log.e(change, "response successful");
                    if(response.body() != null) {
                        Log.e(change, "response body received");
                        //Utils.showShortToast(getContext(), response.body().getMessage());
                        Toast.makeText(ChangePwdActivity.this,"Password change successfully!",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ChangePwdActivity.this, LoginActivity.class));
                    } else {
                        Log.e(change, "Response Body Null");
                        Toast.makeText(ChangePwdActivity.this,"Response body null",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    try {
                        if (response.errorBody() != null) {
                            Log.e(change, "ErrorBodyToasted");
                            Toast.makeText(ChangePwdActivity.this,"Error  body",Toast.LENGTH_SHORT).show();
                           // JSONObject object = new JSONObject(response.errorBody().string());
                            //if(object.getString("message") != null)
                              //  Utils.showLongToast(getContext(), object.getString("message"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<AuthResponseCP> call, Throwable t) {
                Toast.makeText(ChangePwdActivity.this,"something went wrong"+t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private boolean validate(String oldPass, String newPass1, String newPass2) {

        if(oldPass == null || oldPass.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(newPass1 == null || newPass1.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(newPass2 == null || newPass2.trim().length() == 0){
            Toast.makeText(this, "E-mail is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!(newPass1.equals(newPass2)))
        {
            Toast.makeText(this, "passwords do not match", Toast.LENGTH_SHORT).show();
            return  false;
        }
        return true;

    }
}
