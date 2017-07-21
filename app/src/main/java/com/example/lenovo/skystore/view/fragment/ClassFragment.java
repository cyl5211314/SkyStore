package com.example.lenovo.skystore.view.fragment;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.skystore.R;
import com.example.lenovo.skystore.modle.bean.classfrag.ClassData;
import com.example.lenovo.skystore.modle.bean.classfrag.ThreeClassData;
import com.example.lenovo.skystore.modle.bean.classfrag.TowClassData;
import com.example.lenovo.skystore.modle.net.Constant;
import com.example.lenovo.skystore.presenter.classpresenter.MainClassHome;
import com.example.lenovo.skystore.presenter.classpresenter.MainPresenter;
import com.example.lenovo.skystore.presenter.classpresenter.MainThreePresenter;
import com.example.lenovo.skystore.view.activity.ParticularActivity;
import com.example.lenovo.skystore.view.adapter.SpacesItemDecoration;
import com.example.lenovo.skystore.view.adapter.classadapter.ClassHomeAdapter;
import com.example.lenovo.skystore.view.adapter.classadapter.ThreeClassHomeAdapter;
import com.example.lenovo.skystore.view.adapter.classadapter.TowClassHomeAdapter;
import com.example.lenovo.skystore.view.iview.classfragview.ClassHomeview;
import com.example.lenovo.skystore.view.iview.classfragview.IMainView;
import com.example.lenovo.skystore.view.iview.classfragview.ThreeClassHomeview;
import com.example.lenovo.skystore.view.iview.classfragview.ThreeView;
import com.example.lenovo.skystore.view.iview.classfragview.TowClassHomeview;
import com.example.lenovo.skystore.view.iview.classfragview.TowView;

import java.util.ArrayList;
import java.util.List;

import static com.example.lenovo.skystore.modle.net.Constant.TAG;

/**
 * 类描述：分类Fragment
 * 创建人：lenovo
 * 创建时间：2017/7/11 17:11
 */

public class ClassFragment extends BaseFragment implements IMainView<ClassData>,TowView<TowClassData>,ThreeView<ThreeClassData>{
    private MainPresenter presenter;
    private MainClassHome mainClassHome;
    private MainThreePresenter threePresenter;
    private RecyclerView classHome;
    private RecyclerView classTowHome;
    private RecyclerView classThreeHome;
    private List<ClassData.DatasBean.ClassListBean> classDatalist;
    private List<TowClassData.DatasBean.ClassListBean> towDatalist;
    private List<ThreeClassData.DatasBean.ClassListBean> threeDatalist;
    private ClassHomeAdapter adapter;
    private TowClassHomeAdapter towClassHomeAdapter;
    private ThreeClassHomeAdapter threeClassHomeAdapter;
    int spacingInPixels = 30;
    int spacingInPixels2 = 20;
    private View view;
    private String url = Constant.LINK_MOBILE_CLASS;
    private LinearLayout linearLayout;
    private TextView threeHometext;



    @Override
    View onCreateView() {
        view = View.inflate(getActivity(), R.layout.classfragment,null);
        return view;
    }
    //初始化控件方法
    @Override
    void initView() {
        classHome = (RecyclerView) view.findViewById(R.id.class_home);
        classTowHome = (RecyclerView) view.findViewById(R.id.class_towhome);
        classThreeHome = (RecyclerView) view.findViewById(R.id.class_three);
        linearLayout = (LinearLayout) view.findViewById(R.id.class_link);
        threeHometext = (TextView) view.findViewById(R.id.class_threehome_text);
        classTowHome.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        classThreeHome.addItemDecoration(new SpacesItemDecoration(spacingInPixels2));
        threeHometext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                threeDatalist.clear();
                linearLayout.setVisibility(View.GONE);
                classTowHome.setVisibility(View.VISIBLE);
            }
        });
    }
//初始化数据
    @Override
    void initData() {
        classDatalist = new ArrayList<>();
        towDatalist = new ArrayList<>();
        threeDatalist = new ArrayList<>();
        presenter = new MainPresenter(this);
        mainClassHome = new MainClassHome(this);
        threePresenter = new MainThreePresenter(this);
        initClassHome();
    }
    //一级列表初始化数据方法
    private void initClassHome() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        classHome.setLayoutManager(manager);
        adapter = new ClassHomeAdapter(getActivity(),classDatalist);
        classHome.setAdapter(adapter);
        classHome.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        adapter.setHomeview(new ClassHomeview() {
            @Override
            public void classHome(View view, int pos) {
                threeDatalist.clear();
                classTowHome.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.GONE);
                String  gcId = classDatalist.get(pos).getGc_id();
                String url2 = url+"&gc_id="+gcId;
                Log.e("TAG", "ThreeCallback: "+url2);
                mainClassHome.loadDataFromServer(url2,TowClassData.class);
                initTowClassHome(url2);
            }
        });

    }
    //二级列表初始化数据方法
    private void initTowClassHome(final String str) {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        classTowHome.setLayoutManager(manager);
        towClassHomeAdapter = new TowClassHomeAdapter(getActivity(), towDatalist);
        classTowHome.setAdapter(towClassHomeAdapter);
        towClassHomeAdapter.setHomeview(new TowClassHomeview() {
            @Override
            public void towTlassHome(View view, int pos) {
                String gc_name = towDatalist.get(pos).getGc_name();
                String  gcId = towDatalist.get(pos).getGc_id();
                String url3 = str+"&gc_id="+gcId;
                Log.e("TAG", "ThreeCallback: "+url3 );
                threePresenter.loadDataFromServer(url3,ThreeClassData.class);
                initThreeClassHome(gc_name,gcId);
            }
        });

    }
    //三级列表添加数据的方法
    private void initThreeClassHome(String str, final String id) {
        threeHometext.setText(str);
        classTowHome.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);
        GridLayoutManager manager = new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL,false);
        classThreeHome.setLayoutManager(manager);
        threeClassHomeAdapter = new ThreeClassHomeAdapter(getActivity(),threeDatalist);
        classThreeHome.setAdapter(threeClassHomeAdapter);
        threeClassHomeAdapter.setHomeview(new ThreeClassHomeview() {
            @Override
            public void ThreeTlassHome(View view, int pos) {
                Intent intent = new Intent(getActivity(), ParticularActivity.class);
                Log.e(TAG, "ThreeTlassHome: "+threeDatalist.get(pos).getGc_id());
                   startActivity(intent);
                   getActivity(). overridePendingTransition(R.anim.activity_right_in, R.anim.activity_left_out);
            }
        });

    }
    //访问p层
    @Override
    void NetworkRequest() {
        presenter.loadDataFromServer(url,ClassData.class);
    }

    //网络请求成功回调的方法
    @Override
    public void successCallback(ClassData classData) {
        classDatalist.addAll(classData.getDatas().getClass_list());
        adapter.notifyDataSetChanged();
    }


    //一级列表网络请求失败回调的方法
    @Override
    public void errCallback(String msg, int code) {

    }


    //二级列表请求成功回调的方法
    @Override
    public void TowCallback(TowClassData towClassData) {
        towDatalist.clear();
        towDatalist.addAll(towClassData.getDatas().getClass_list());
        towClassHomeAdapter.notifyDataSetChanged();
    }

    //二级列表请求失败回调的方法
    @Override
    public void TowerrCallback(String msg, int code) {

    }

    //第三次网络请求成功的方法
    @Override
    public void ThreeCallback(ThreeClassData threeClassData) {
        Log.e("TAG", "ThreeCallback: "+threeClassData.toString() );
     threeDatalist.clear();
     threeDatalist.addAll(threeClassData.getDatas().getClass_list());
     threeClassHomeAdapter.notifyDataSetChanged();
    }

    //第三次网络请求失败回调的方法
    @Override
    public void ThreeerrCallback(String msg, int code) {

    }
}
