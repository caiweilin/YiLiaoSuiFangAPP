package com.example.xqm.follow_up.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by ipbase on 2017/11/25.
 */

public class CaseHistoryBean extends BmobObject {
    //姓名、性别、地址、年龄、联系电话、入院时间、记录日期、病历申述人、主述、现病史、既往史、辅助检查（尿常规、血糖）、入院诊断
    private String u_name;
    private int u_sex;
    private String u_address;
    private int u_age;
    private String u_tel;
    private String u_admission_time;
    private String u_record_time;
    private String u_medical_record;
    private String u_main_above;
    private String u_hpi;
    private String u_past_history;
    private String u_auxiliary_inspection;
    private String u_hospital_diagnosis;

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public int getU_sex() {
        return u_sex;
    }

    public void setU_sex(int u_sex) {
        this.u_sex = u_sex;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    public int getU_age() {
        return u_age;
    }

    public void setU_age(int u_age) {
        this.u_age = u_age;
    }

    public String getU_tel() {
        return u_tel;
    }

    public void setU_tel(String u_tel) {
        this.u_tel = u_tel;
    }

    public String getU_admission_time() {
        return u_admission_time;
    }

    public void setU_admission_time(String u_admission_time) {
        this.u_admission_time = u_admission_time;
    }

    public String getU_record_time() {
        return u_record_time;
    }

    public void setU_record_time(String u_record_time) {
        this.u_record_time = u_record_time;
    }

    public String getU_medical_record() {
        return u_medical_record;
    }

    public void setU_medical_record(String u_medical_record) {
        this.u_medical_record = u_medical_record;
    }

    public String getU_main_above() {
        return u_main_above;
    }

    public void setU_main_above(String u_main_above) {
        this.u_main_above = u_main_above;
    }

    public String getU_hpi() {
        return u_hpi;
    }

    public void setU_hpi(String u_hpi) {
        this.u_hpi = u_hpi;
    }

    public String getU_past_history() {
        return u_past_history;
    }

    public void setU_past_history(String u_past_history) {
        this.u_past_history = u_past_history;
    }

    public String getU_auxiliary_inspection() {
        return u_auxiliary_inspection;
    }

    public void setU_auxiliary_inspection(String u_auxiliary_inspection) {
        this.u_auxiliary_inspection = u_auxiliary_inspection;
    }

    public String getU_hospital_diagnosis() {
        return u_hospital_diagnosis;
    }

    public void setU_hospital_diagnosis(String u_hospital_diagnosis) {
        this.u_hospital_diagnosis = u_hospital_diagnosis;
    }
}
