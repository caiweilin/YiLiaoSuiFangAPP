package com.example.xqm.follow_up;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.xqm.follow_up.address.AddressFragment;
import com.example.xqm.follow_up.message.MessageFragment;
import com.example.xqm.follow_up.mine.MineFragment;
import com.example.xqm.follow_up.workbench.WorkbenchFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private ViewPager viewpager;
    private FragmentPagerAdapter mAdapter;//Fragment适配器，viewpager的适配器
    private List<Fragment> mFragments;//适配器的数据源

    private LinearLayout mTabWeixin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabAddress;
    private LinearLayout mTabSetting;

    private ImageButton mImgWeixin;
    private ImageButton mImgFrd;
    private ImageButton mImgAddress;
    private ImageButton mImgSetting;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        setSelect(0);
    }

    private void initEvent() {
        mTabWeixin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabAddress.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.id_viewpager);
        mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);
        mImgWeixin = (ImageButton)findViewById(R.id.id_tab_weixin_img);
        mImgFrd = (ImageButton)findViewById(R.id.id_tab_frd_img);
        mImgAddress = (ImageButton)findViewById(R.id.id_tab_address_img);
        mImgSetting = (ImageButton)findViewById(R.id.id_tab_setting_img);

        mFragments = new ArrayList<Fragment>();//初始化数据源
        mTab01 = new MessageFragment();
        mTab02 = new WorkbenchFragment();
        mTab03 = new AddressFragment();
        mTab04 = new MineFragment();
        //将4个fragment添加到数据源中
        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);
        mFragments.add(mTab04);
        //初始化适配器
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                // TODO Auto-generated method stub
                return mFragments.get(arg0);//通过位置返回不同的fragment
            }
        };
		/*
		 * Android中可变的控件，比如ViewPager，listview,gridview，一个控件对应一个适配器，一个适配器对应一系列的数据源
		 * 数据源一般都是一个list
		 *
		 * */
        viewpager.setAdapter(mAdapter);//为viewpager设置一个适配器
        //实现当viewpager滑动时（滑动页面改变）底部的导航按钮同步改变
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                int currentItem = viewpager.getCurrentItem();
                setTab(currentItem);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.id_tab_weixin:
                setSelect(0);
                break;
            case R.id.id_tab_frd:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;
            case R.id.id_tab_setting:
                setSelect(3);
                break;

            default:
                break;
        }

    }
    /*
     * 将图片设置为亮色的；切换显示内容的fragment
     * */
    private void setSelect(int i) {
        setTab(i);//alt + shift + m可以提取选择的代码为方法
        viewpager.setCurrentItem(i);
    }

    private void setTab(int i) {
        resetImg();
        switch (i) {
            case 0:
                mImgWeixin.setImageResource(R.mipmap.xiaoxi);
                break;
            case 1:
                mImgFrd.setImageResource(R.mipmap.txl);
                break;
            case 2:
                mImgAddress.setImageResource(R.mipmap.gzt);
                break;
            case 3:
                mImgSetting.setImageResource(R.mipmap.mine);
                break;

            default:
                break;
        }
    }

    private void resetImg() {
        mImgWeixin.setImageResource(R.mipmap.xiaoxi1);
        mImgFrd.setImageResource(R.mipmap.txl1);
        mImgAddress.setImageResource(R.mipmap.gzt1);
        mImgSetting.setImageResource(R.mipmap.mine1);
    }
}
