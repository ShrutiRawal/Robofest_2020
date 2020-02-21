package com.example.robofest2020;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AuthResponseL implements Serializable {

    @SerializedName("username")
    @Expose
    private
    String username;

    @SerializedName("email")
    @Expose
    private
    String email;

    @SerializedName("password")
    @Expose
    private
    String password;

    @SerializedName("message")
    @Expose
    private
    String message;

    @SerializedName("key")
    @Expose
    private
    String key;

    public String getMessage() {
        return message;
    }

    public String getKey() {
        return key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
