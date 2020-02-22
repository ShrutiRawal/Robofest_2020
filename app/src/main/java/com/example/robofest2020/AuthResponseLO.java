package com.example.robofest2020;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AuthResponseLO implements Serializable {

    @SerializedName("message")
    @Expose
    private
    String message;

    @SerializedName("detail")
    @Expose
    private
    String detail;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
