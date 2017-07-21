package com.example.lenovo.skystore.presenter.classpresenter;


import com.example.lenovo.skystore.modle.net.NetDataCallback;
import com.example.lenovo.skystore.modle.net.OkHttpUtils;
import com.example.lenovo.skystore.view.iview.classfragview.ThreeView;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/10 16:30
 */

public class MainThreePresenter<T>{
    private  OkHttpUtils httpUtils;
    private ThreeView threeView;

    public MainThreePresenter(ThreeView threeView) {
        this.threeView = threeView;
        httpUtils = new OkHttpUtils();
    }

    public void loadDataFromServer(String url,Class<T> t) {
    httpUtils.initData(url, new NetDataCallback<T>(){
            @Override
            public void callback(T o) {
                threeView.ThreeCallback(o);
            }
            @Override
        public void err(int errCode, String errMsg) {
            threeView.ThreeerrCallback(errMsg,500);
        }
    },t);
    }
}
