package com.example.lenovo.skystore.view.activity;

import android.view.View;

import com.example.lenovo.skystore.R;
import com.example.lenovo.skystore.view.fragment.ClassFragment;
import com.example.lenovo.skystore.view.fragment.HomeFragment;
import com.example.lenovo.skystore.view.fragment.MyFragment;
import com.example.lenovo.skystore.view.fragment.ShoppingFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends BaseActivity {
    private BottomTabBar bottomTabBar;

    @Override
    int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    void initView() {
        bottomTabBar = (BottomTabBar) findViewById(R.id.bottom_tab_bar);
    }

    @Override
    void initData() {
        bottomTabBar.init(getSupportFragmentManager())
                .addTabItem("首页", R.drawable.home, HomeFragment.class)
                .addTabItem("分类", R.drawable.fenlei, ClassFragment.class)
                .addTabItem("购物车", R.drawable.shopping, ShoppingFragment.class)
                .addTabItem("我的", R.drawable.my, MyFragment.class);
    }

    @Override
    public void onClick(View v) {

    }
}
