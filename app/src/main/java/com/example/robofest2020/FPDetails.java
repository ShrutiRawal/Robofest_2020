package com.example.robofest2020;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FPDetails implements Serializable {

    @SerializedName("email")
    @Expose
    String email;

    public String getEmail() {
        return email;
    }

    public FPDetails(String email) {
        this.email = email;
    }
}
