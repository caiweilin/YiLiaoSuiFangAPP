package com.example.xqm.follow_up.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.xqm.follow_up.MainActivity;
import com.example.xqm.follow_up.R;
import com.example.xqm.follow_up.bean.DoctorBean;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class SplashActivity extends Activity {

    private static final int GO_HOME = 0;//去主页
    private static final int GO_LOGIN = 1;//去登录页
    /**
     * 跳转判断
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME://去主页
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    //查询放在SharedPreferences里面的数据
                    SharedPreferences settings = getSharedPreferences("userInfo", 0);
                    String phonenumber=settings.getString("USER_NAME","111");
                    BmobQuery<DoctorBean> query=new BmobQuery<DoctorBean>();
                    query.addWhereEqualTo("d_tel",phonenumber);
                    query.findObjects(new FindListener<DoctorBean>() {
                        @Override
                        public void done(List<DoctorBean> list, BmobException e) {
                            if(e==null){
                                for (DoctorBean doctorBean : list) {
                                    //获得playerName的信息
                                    String a=doctorBean.getD_name();
                                    Toast.makeText(SplashActivity.this,"欢迎回来！"+a, Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Log.e("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                            }
                        }
                    });
                    finish();
                    break;
                case GO_LOGIN://去登录页
                    Intent intent2 = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent2);
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (UserManage.getInstance().hasUserInfo(this))//自动登录判断，SharePrefences中有数据，则跳转到主页，没数据则跳转到登录页
        {
            mHandler.sendEmptyMessageDelayed(GO_HOME, 2000);
        } else {
            mHandler.sendEmptyMessageAtTime(GO_LOGIN, 2000);
        }
    }
}
