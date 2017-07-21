package com.example.lenovo.skystore.view.fragment;

import android.view.View;

import com.example.lenovo.skystore.R;

/**
 * 类描述：购物车Fragment
 * 创建人：lenovo
 * 创建时间：2017/7/11 17:11
 */

public class ShoppingFragment extends BaseFragment{

    private View view;

    @Override
    View onCreateView() {
        view = View.inflate(getActivity(), R.layout.shoppingfragment,null);
        return view;
    }

    @Override
    void initView() {
    }

    @Override
    void initData() {

    }

    @Override
    void NetworkRequest() {

    }


}
