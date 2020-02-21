package com.example.robofest2020;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RegisterDetails implements Serializable {

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

    public RegisterDetails(String name, String email, String phone_no, String password, String password1) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.password = password;
        this.password1 = password1;
    }

    public String getname() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword1() {
        return password1;
    }
}
