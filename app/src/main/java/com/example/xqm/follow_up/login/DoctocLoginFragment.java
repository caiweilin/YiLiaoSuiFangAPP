package com.example.xqm.follow_up.login;

/**
 * Created by linch on 2017/11/28.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xqm.follow_up.MainActivity;
import com.example.xqm.follow_up.R;
import com.example.xqm.follow_up.bean.DoctorBean;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class DoctocLoginFragment extends Fragment implements View.OnClickListener{
    private Button login_btu;
    private EditText phone_number;
    private EditText password;
    private String user_password;
    private String a;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctor_login,null);
        phone_number=(EditText)view.findViewById(R.id.phone_num) ;
        password=(EditText)view.findViewById(R.id.password);
        login_btu=(Button)view.findViewById(R.id.login_button);
        login_btu.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        String phonenumber=phone_number.getText().toString();
        user_password=password.getText().toString();
        if (phonenumber.isEmpty() || user_password.isEmpty()) {
            Toast.makeText(getActivity(), "密码或手机号不能为空!", Toast.LENGTH_SHORT).show();
            return;
        }
        BmobQuery<DoctorBean> query=new BmobQuery<DoctorBean>();
        query.addWhereEqualTo("d_tel",phonenumber);
        query.findObjects(new FindListener<DoctorBean>() {
            @Override
            public void done(List<DoctorBean> list, BmobException e) {
                if(e==null){
                    if (list.isEmpty()){
                        Toast.makeText(getActivity(),"账号不存在", Toast.LENGTH_SHORT).show();
                    }
                    for (DoctorBean doctorBean : list) {
                        //获得playerName的信息
                        a=doctorBean.getD_password();
                        if (a.equals(password.getText().toString())){
                            Intent intent=new Intent(getActivity(),MainActivity.class);
                            startActivity(intent);
                            UserManage.getInstance().saveUserInfo(getActivity(), phone_number.getText().toString(), password.getText().toString());
                        }else {
                            Toast.makeText(getActivity(),"密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Log.e("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }
}