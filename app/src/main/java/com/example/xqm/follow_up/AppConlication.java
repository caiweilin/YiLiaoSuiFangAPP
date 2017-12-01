package com.example.xqm.follow_up;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by ipbase on 2017/11/25.
 */

public class AppConlication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this,AppConfig.APPLICATION_ID);
    }
}
