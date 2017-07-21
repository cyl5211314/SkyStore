package com.example.lenovo.skystore.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.skystore.R;
import com.example.lenovo.skystore.modle.bean.History;
import com.example.lenovo.skystore.view.adapter.historyadapter.HistoryAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.lenovo.skystore.R.id.seek_linear;
import static com.example.lenovo.skystore.R.id.text_baby;
import static com.example.lenovo.skystore.R.id.text_seekdelete;
import static com.example.lenovo.skystore.R.id.text_store;

public class SeekActivity extends BaseActivity {
    //分类按钮小三角
    private ImageView rightImageView;
    //返回按钮
    private ImageView leftImageView;
    //宝贝店铺分类
    private TextView classify;
    //搜索输入框
    private EditText keywordEditText;
    //放大镜搜索按钮
    private ImageView classimageView;
    //历史搜索
    private ListView historyseek;
    //分类选项布局
    private LinearLayout seeklinear;
    //宝贝Text
    private TextView textbaby;
    //店铺Text
    private TextView textstore;
    //历史搜索记录集合
    private List<History> list;
    //历史搜索记录适配器
    private HistoryAdapter historyAdapter;
    private TextView textseekdelete;

    @Override
    int setContentView() {
        return R.layout.activity_seek;
    }

    @Override
    void initView() {
        list = new ArrayList<>();
        //历史搜索
        historyseek = (ListView) findViewById(R.id.historyseek);
        //搜索页面返回箭头
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        //分类搜索选项文字
        classify = (TextView) findViewById(R.id.classify);
        //分类搜索选项文字小三角
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        //搜索一下
        keywordEditText = (EditText) findViewById(R.id.keywordEditText);
        //放大镜搜索按钮
        classimageView = (ImageView) findViewById(R.id.classimageView);
        //分类选项布局
        seeklinear = (LinearLayout) findViewById(seek_linear);
        //宝贝TextView
        textbaby = (TextView) findViewById(text_baby);
        //店铺Text
        textstore = (TextView) findViewById(text_store);
        textseekdelete = (TextView) findViewById(text_seekdelete);

    }

    @Override
    void initData() {
        historyAdapter = new HistoryAdapter(this, list);
        historyseek.setAdapter(historyAdapter);
        //点击事件
        textbaby.setOnClickListener(this);
        textstore.setOnClickListener(this);
        rightImageView.setOnClickListener(this);
        leftImageView.setOnClickListener(this);
        classimageView.setOnClickListener(this);
        classify.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {//View点击事件选择使用
            case R.id.leftImageView:
                finish();
                overridePendingTransition(R.anim.activity_left_in, R.anim.activity_right_out);
                break;
            case R.id.rightImageView:
               //放大镜搜索按钮不能为空
                if (keywordEditText.getText().toString().trim().equals("")){
                    Toast.makeText(SeekActivity.this,"搜索不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    History history = new History();
                    history.setName(keywordEditText.getText().toString().trim());
                    history.setClassify(classify.getText().toString().trim());
                    list.add(history);
                    historyAdapter.notifyDataSetChanged();
                    textseekdelete.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(SeekActivity.this, ParticularActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.activity_right_in, R.anim.activity_left_out);
                }
                break;
            case R.id.classify:
                seeklinear.setVisibility(View.VISIBLE);
                break;
            case R.id.classimageView:
                seeklinear.setVisibility(View.VISIBLE);
                break;
            case R.id.text_baby:
                classify.setText(textbaby.getText().toString().trim());
                seeklinear.setVisibility(View.GONE);
                break;
            case R.id.text_store:
                classify.setText(textstore.getText().toString().trim());
                seeklinear.setVisibility(View.GONE);
                break;
            case R.id.text_seekdelete:
                textseekdelete.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

}
