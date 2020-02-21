package com.example.robofest2020;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AuthResponseR implements Serializable {

    @SerializedName("email")
    @Expose
    private
    String email;

    @SerializedName("name")
    @Expose
    private
    String name;

    @SerializedName("phone_no")
    @Expose
    private
    String phone_no;

    @SerializedName("password")
    @Expose
    private
    String password;

    @SerializedName("password1")
    @Expose
    private
    String password1;

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @SerializedName("message")
    @Expose
    private
    String message;

    @SerializedName("key")
    @Expose
    private
    String key;

}
