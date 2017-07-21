package com.example.lenovo.skystore.view.adapter.classadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.skystore.R;
import com.example.lenovo.skystore.modle.bean.classfrag.ClassData;
import com.example.lenovo.skystore.view.iview.classfragview.ClassHomeview;

import java.util.List;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/18 15:05
 */

public class ClassHomeAdapter extends RecyclerView.Adapter<ClassHomeAdapter.ViewHolder> implements View.OnClickListener{
    private Context context;
    private List<ClassData.DatasBean.ClassListBean> list;
    private View view;
    private ViewHolder viewHolder;
    private ClassHomeview homeview;
    public void setHomeview(ClassHomeview homeview) {
        this.homeview = homeview;
    }
    public ClassHomeAdapter(Context context, List<ClassData.DatasBean.ClassListBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.classhome,null);
        viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImage()).into(holder.classHomeTmage);
        holder.classHomeText.setText(list.get(position).getGc_name());
        holder.itemView.setTag(position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        homeview.classHome(v, (Integer) v.getTag());
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView classHomeTmage;
        private TextView classHomeText;
        public ViewHolder(View itemView) {
            super(itemView);
            classHomeText = (TextView) itemView.findViewById(R.id.class_home_text);
            classHomeTmage = (ImageView) itemView.findViewById(R.id.class_home_image);
        }
    }
}
