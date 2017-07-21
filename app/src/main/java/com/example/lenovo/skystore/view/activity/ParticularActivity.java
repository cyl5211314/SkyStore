package com.example.lenovo.skystore.view.activity;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.skystore.R;
import com.example.lenovo.skystore.modle.bean.particularactivity.ParticularData;
import com.example.lenovo.skystore.presenter.classpresenter.MainPresenter;
import com.example.lenovo.skystore.view.adapter.particularadapter.ParticularHomeAdapter;
import com.example.lenovo.skystore.view.adapter.particularadapter.ParticularHomeAdapter2;
import com.example.lenovo.skystore.view.iview.classfragview.ClassHomeview;
import com.example.lenovo.skystore.view.iview.classfragview.IMainView;

import java.util.ArrayList;
import java.util.List;

import static com.example.lenovo.skystore.R.id.pratlicular_cheerkbox_yangshi;

public class ParticularActivity extends BaseActivity implements IMainView<ParticularData>{
    private RecyclerView particularrec;
    private MainPresenter presenter;
    private TextView textPaixu;
    private TextView textShaixuan;
    private TextView textYouxian;
    private CheckBox chYangshi;
    private List<ParticularData.DatasBean.GoodsListBean> particularList;
    private ParticularHomeAdapter particularHomeAdapter;
    private ParticularHomeAdapter2 particularHomeAdapter2;

    @Override
    int setContentView() {
        return R.layout.activity_particular;
    }

    @Override
    void initView() {
        //初始化控件
        particularrec = (RecyclerView) findViewById(R.id.particular_rec);
        textPaixu = (TextView) findViewById(R.id.pratlicular_textpaixu);
        textYouxian = (TextView) findViewById(R.id.pratlicular_textyouxian);
        textShaixuan = (TextView) findViewById(R.id.pratlicular_textshaixuan);
        chYangshi = (CheckBox) findViewById(pratlicular_cheerkbox_yangshi);

        //点击事件
        textShaixuan.setOnClickListener(this);
        textPaixu.setOnClickListener(this);
        textYouxian.setOnClickListener(this);
        chYangshi.setOnClickListener(this);
    }

    @Override
    void initData() {
        particularList = new ArrayList<>();
        presenter = new MainPresenter(this);
        presenter.loadDataFromServer("http://169.254.159.247/mobile/index.php?act=goods&op=goods_list&page=100",ParticularData.class);
        initDataParticularrec(chYangshi.isChecked());
    }

    private void initDataParticularrec(Boolean falg) {
        if (!falg){
            LinearLayoutManager manager = new LinearLayoutManager(this);
            particularrec.setLayoutManager(manager);
            particularrec.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
            particularHomeAdapter = new ParticularHomeAdapter(this, particularList);
            particularrec.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
            particularrec.setAdapter(particularHomeAdapter);
        }else{
            GridLayoutManager manager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);

            //LinearLayoutManager manager = new LinearLayoutManager(this);
            particularrec.setLayoutManager(manager);
            particularHomeAdapter2 = new ParticularHomeAdapter2(this, particularList);
            particularrec.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
            particularrec.setAdapter(particularHomeAdapter2);
        }

        //点击回调方法得到item的position
        particularHomeAdapter.setHomeview(new ClassHomeview() {
            @Override
            public void classHome(View view, int pos) {
                Intent intent = new Intent(ParticularActivity.this,DetailsActivity.class);
                intent.putExtra("pos",pos);
                startActivity(intent);
            }
        });
    }
    //网络请求成功回调的方法
    @Override
    public void successCallback(ParticularData particularData) {
        particularList.clear();
        Log.i("TAG", "successCallback: "+particularData.toString());
        if(particularData!=null){
            if (!chYangshi.isChecked()){
                particularList.addAll(particularData.getDatas().getGoods_list());
                Log.i("TAG", "successCallback: "+particularList.toString());
                particularHomeAdapter.notifyDataSetChanged();
            }else{
                particularList.addAll(particularData.getDatas().getGoods_list());
                Log.i("TAG", "successCallback: "+particularList.toString());
                particularHomeAdapter2.notifyDataSetChanged();
            }

        }else{
            Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
        }

    }

    //网络请求失败回调的方法
    @Override
    public void errCallback(String msg, int code) {
     Toast.makeText(this,"暂无数据",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
    switch(v.getId()){//View点击事件选择使用
        case R.id.pratlicular_textpaixu:

        break;
        case R.id.pratlicular_textyouxian:

        break;
        case R.id.pratlicular_textshaixuan:

        break;
        case R.id.pratlicular_cheerkbox_yangshi:
            initDataParticularrec(chYangshi.isChecked());
        break;
        default :
        break;
    }
    }
}
