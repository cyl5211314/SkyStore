package com.example.lenovo.skystore.view.iview.classfragview;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/10 16:59
 */

public interface IMainView<T> {
    void successCallback(T t);
    void errCallback(String msg, int code);

}
