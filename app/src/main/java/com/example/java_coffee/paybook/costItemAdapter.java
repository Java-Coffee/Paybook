package com.example.java_coffee.paybook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Java-Coffee on 2017/3/1.
 */
public class costItemAdapter extends BaseAdapter{
    private List<CostBean> mlist;
    private Context mcontext;
    private LayoutInflater mlayoutInflater;
    public costItemAdapter(Context context,List<CostBean> list){
        mcontext = context;
        mlist = list;
        mlayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
        viewHolder = new ViewHolder();
            convertView = mlayoutInflater.inflate(R.layout.list_item,null);
            viewHolder.mcostTitle = (TextView) convertView.findViewById(R.id.costTitle);
            viewHolder.mcostDate = (TextView) convertView.findViewById(R.id.costDate);
            viewHolder.mcostMoney = (TextView) convertView.findViewById(R.id.costMoney);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CostBean costBean = mlist.get(position);
        viewHolder.mcostTitle.setText(costBean.costTitle);
        viewHolder.mcostDate.setText(costBean.costDate);
        viewHolder.mcostMoney.setText(costBean.costMoney);
        return convertView;
    }
    private static class ViewHolder{
        private TextView mcostTitle;
        private TextView mcostDate;
        private TextView mcostMoney;
    }
}
