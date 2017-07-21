package com.example.lenovo.skystore.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.skystore.R;
import com.example.lenovo.skystore.view.activity.RqccodeActivity;
import com.example.lenovo.skystore.view.activity.SeekActivity;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/11 17:13
 */

public abstract class BaseFragment extends Fragment {

    private ImageView rqccode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = onCreateView();
        initView();
        initData();
        NetworkRequest();
        incOnc(view);
        return view;
    }

    //初始化视图抽象方法
    abstract View onCreateView();

    //初始化控件抽象方法
    abstract void initView();

    //初始化数据抽象方法
    abstract void initData();

    //网络请求抽象方法
    abstract void NetworkRequest();

    private void incOnc(View view) {
        //跳转到二维码扫描页面
        view.findViewById(R.id.inc).findViewById(R.id.rqccode)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), RqccodeActivity.class);
                        startActivity(intent);
                        getActivity().overridePendingTransition(R.anim.activity_right_in, R.anim.activity_left_out);
                    }
                });
        //跳转到搜索页面
        view.findViewById(R.id.inc).findViewById(R.id.seek)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(getActivity(), SeekActivity.class);
                        startActivity(intent2);
                        getActivity().overridePendingTransition(R.anim.activity_right_in, R.anim.activity_left_out);

                    }
                });
    }
}
