package com.example.lenovo.skystore.view.fragment;

import android.view.View;

import com.example.lenovo.skystore.R;

/**
 * 类描述：首页Fragment
 * 创建人：lenovo
 * 创建时间：2017/7/11 17:11
 */

public class HomeFragment extends BaseFragment {
  private View view;
    @Override
    View onCreateView() {
        view = View.inflate(getActivity(), R.layout.homefragment, null);
        return view;
    }

    //初始化控件方法
    @Override
    void initView() {
    }

    //初始化数据方法
    @Override
    void initData() {

    }

    //网络请求方法
    @Override
    void NetworkRequest() {

    }


}
