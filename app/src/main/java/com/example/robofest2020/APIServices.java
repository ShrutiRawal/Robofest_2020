package com.example.robofest2020;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIServices {

    @POST("rest-auth/login/")
    Call<AuthResponseL> postLoginUser(@Body LoginDetails loginDetails);

    @POST("rest-auth/registration/")
    Call<AuthResponseR> postRegisterUser(@Body RegisterDetails registerDetails);

    @POST("rest-auth/password/reset/")
    Call<AuthResponseFP> postForgotPass(@Body FPDetails cfDetails);

    @POST("rest-auth/password/change/")
    Call<AuthResponseCP> postChangePass(@Body CPDetails cpdetails);

    @POST("rest-auth/logout/")
    Call<AuthResponseLO> postLogout();

}
