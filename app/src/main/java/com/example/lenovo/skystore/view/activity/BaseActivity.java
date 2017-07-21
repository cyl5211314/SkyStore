package com.example.lenovo.skystore.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/11 18:56
 */

public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setContentView());
        initView();
        initData();
    }
    //初始化view视图
    abstract int setContentView();
    //初始化控件
    abstract void initView();
    //初始化数据
    abstract void initData();
}
