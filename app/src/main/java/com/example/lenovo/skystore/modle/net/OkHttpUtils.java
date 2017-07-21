package com.example.lenovo.skystore.modle.net;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/18 11:22
 */

public class OkHttpUtils {
    private NetDataCallback netDataCallback;
    private String string;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    netDataCallback.callback(msg.obj);
                    break;
            }
        }
    };
    public <T>void initData(String url, final NetDataCallback netDataCallback,final Class<T> clazz) {
        this.netDataCallback = netDataCallback;
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            //失败调用
            @Override
            public void onFailure(Call call, IOException e) {
                netDataCallback.err(500, e.getMessage());
            }

            //成功调用
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = handler.obtainMessage();
                message.what = 0;
                Gson gson = new Gson();
                T t = gson.fromJson(response.body().string(), clazz);
                message.obj = t;
                handler.sendMessage(message);
            }
        });
    }
}
