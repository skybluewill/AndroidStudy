package com.lxy.study2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.lxy.study2.CustomListView;

import java.util.List;

/**
 * Created by wy on 2015/9/21.
 */
public class CustomAdapter extends ArrayAdapter<CustomListView> {
    private int viewId;                 //用来保存视图资源的ID
    public CustomAdapter(Context context,int viewResourceId, List<CustomListView> objects){
        super(context, viewResourceId, objects);
        this.viewId = viewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        CustomListView ND = getItem(position);                      //不懂
        View view = LayoutInflater.from(getContext()).inflate(viewId, null);    //获取布局
        TextView name = (TextView) view.findViewById(R.id.name);                //获得布局里的控件
        TextView detail = (TextView) view.findViewById(R.id.detail);
        name.setText(ND.getName());
        detail.setText(ND.getDetail());
        return view;
    }
}
