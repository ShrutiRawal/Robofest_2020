package com.example.robofest2020;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIServices {

    @POST("rest-auth/login/")
    Call<AuthResponseL> postLoginUser(@Body LoginDetails loginDetails);

    @POST("rest-auth/registration/")
    Call<AuthResponseR> postRegisterUser(@Body RegisterDetails registerDetails);

}
