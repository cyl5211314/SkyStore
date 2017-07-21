package com.example.lenovo.skystore.view.adapter.classadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.skystore.R;
import com.example.lenovo.skystore.modle.bean.classfrag.TowClassData;
import com.example.lenovo.skystore.view.iview.classfragview.TowClassHomeview;

import java.util.List;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/18 15:05
 */

public class TowClassHomeAdapter extends RecyclerView.Adapter<TowClassHomeAdapter.ViewHolder> implements View.OnClickListener {
    private Context context;
    private List<TowClassData.DatasBean.ClassListBean> list;
    private View view;
    private ViewHolder viewHolder;
    private TowClassHomeview homeview;

    public void setHomeview(TowClassHomeview homeview) {
        this.homeview = homeview;
    }

    public TowClassHomeAdapter(Context context, List<TowClassData.DatasBean.ClassListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = View.inflate(context, R.layout.towclasshome, null);
        viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.classHomeText.setText(list.get(position).getGc_name());
        holder.itemView.setTag(position);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        if (v!=null){
            homeview.towTlassHome(v, (Integer) v.getTag());
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView classHomeText;
        public ViewHolder(View itemView) {
            super(itemView);
            classHomeText = (TextView) itemView.findViewById(R.id.class_towhome_text);
        }
    }
}
