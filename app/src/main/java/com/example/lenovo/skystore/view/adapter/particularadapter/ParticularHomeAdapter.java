package com.example.lenovo.skystore.view.adapter.particularadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.skystore.R;
import com.example.lenovo.skystore.modle.bean.particularactivity.ParticularData;
import com.example.lenovo.skystore.view.iview.classfragview.ClassHomeview;

import java.util.List;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/18 15:05
 */

public class ParticularHomeAdapter extends RecyclerView.Adapter<ParticularHomeAdapter.ViewHolder> implements View.OnClickListener{
    private Context context;
    private List<ParticularData.DatasBean.GoodsListBean> list;
    private View view;
    private ViewHolder viewHolder;
    private ClassHomeview homeview;
    public void setHomeview(ClassHomeview homeview) {
        this.homeview = homeview;
    }
    public ParticularHomeAdapter(Context context, List<ParticularData.DatasBean.GoodsListBean> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.particularadapter,null);
        viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getGoods_image_url()).into(holder.particimage);
        holder.partictextname.setText(list.get(position).getGoods_name());
        holder.partictextmaner.setText(list.get(position).getGoods_price());
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
        private ImageView particimage;
        private TextView partictextname;
        private TextView partictextmaner;
        public ViewHolder(View itemView) {
            super(itemView);
            partictextname = (TextView) itemView.findViewById(R.id.partic_textname);
            partictextmaner = (TextView) itemView.findViewById(R.id.partic_textmaner);
            particimage = (ImageView) itemView.findViewById(R.id.partic_image);
        }
    }
}
