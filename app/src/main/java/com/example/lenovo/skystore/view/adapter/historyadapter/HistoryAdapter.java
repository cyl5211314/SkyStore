package com.example.lenovo.skystore.view.adapter.historyadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.skystore.R;
import com.example.lenovo.skystore.modle.bean.History;

import java.util.List;

/**
 * 类描述：
 * 创建人：lenovo
 * 创建时间：2017/7/12 22:00
 */

public class HistoryAdapter extends BaseAdapter{

    private Context context;
    private List<History> list;

    public HistoryAdapter(Context context, List<History> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if(convertView==null){
            vh = new ViewHolder();
            convertView = convertView.inflate(context, R.layout.historylistview,null);
            vh.textBaby = (TextView) convertView.findViewById(R.id.list_textname);
            vh.textClassify = (TextView) convertView.findViewById(R.id.list_textclassify);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }
            vh.textBaby.setText(list.get(position).getName());
            vh.textClassify.setText(list.get(position).getClassify());
        return convertView;
    }
    class ViewHolder{
        TextView textBaby;
        TextView textClassify;
    }
}
