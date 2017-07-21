package com.example.lenovo.skystore.modle.net;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/6 19:53
 */

public interface NetDataCallback<T> {
    void callback(T t);
    void err(int errCode, String errMsg);
}
