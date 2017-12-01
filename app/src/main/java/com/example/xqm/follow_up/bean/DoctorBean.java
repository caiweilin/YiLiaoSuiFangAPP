package com.example.xqm.follow_up.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by ipbase on 2017/11/25.
 */

public class DoctorBean extends BmobObject {
    private String d_name;
    private String d_password;
    private int d_age;
    private String d_sex;
    private String d_address;
    private String d_tel;

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_password() {
        return d_password;
    }

    public void setD_password(String d_password) {
        this.d_password = d_password;
    }

    public int getD_age() {
        return d_age;
    }

    public void setD_age(int d_age) {
        this.d_age = d_age;
    }

    public String getD_sex() {
        return d_sex;
    }

    public void setD_sex(String d_sex) {
        this.d_sex = d_sex;
    }


    public String getD_address() {
        return d_address;
    }

    public void setD_address(String d_address) {
        this.d_address = d_address;
    }

    public String getD_tel() {
        return d_tel;
    }

    public void setD_tel(String d_tel) {
        this.d_tel = d_tel;
    }
}
