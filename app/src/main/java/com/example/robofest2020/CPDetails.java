package com.example.robofest2020;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CPDetails implements Serializable {

    @SerializedName("old_password")
    @Expose
    private
    String old_password;
    @SerializedName("new_password1")
    @Expose
    private
    String new_password1;
    @SerializedName("new_password2")
    @Expose
    private
    String new_password2;

    public CPDetails(String old_password, String new_password1, String new_password2) {
        this.old_password = old_password;
        this.new_password1 = new_password1;
        this.new_password2 = new_password2;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public String getNew_password1() {
        return new_password1;
    }

    public void setNew_password1(String new_password1) {
        this.new_password1 = new_password1;
    }

    public String getNew_password2() {
        return new_password2;
    }

    public void setNew_password2(String new_password2) {
        this.new_password2 = new_password2;
    }
}
