package com.kotkin.lg.r25.communalpaymentsdiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainListViewAdapter extends BaseAdapter {

    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Model> objects;

    MainListViewAdapter(Context context, ArrayList<Model> service) {
        ctx = context;
        objects = service;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return objects.size();
    }

    public Object getItem(int position) {
        return objects.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    Model getService(int position) {
        return ((Model) getItem(position));
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (convertView == null) {
            view = lInflater.inflate(R.layout.main_list, parent, false);
        }

        Model s = getService(position);

        ((TextView) view.findViewById(R.id.mainServ_textView)).setText(s.service);
        ((TextView) view.findViewById(R.id.mainSum_textView)).setText(s.sum);
        CheckBox cbPay = (CheckBox) view.findViewById(R.id.main_checkb);

        cbPay.setOnCheckedChangeListener(myCheckChangList);
        cbPay.setTag(position);
        cbPay.setChecked(s.box);
        return view;
    }

    CompoundButton.OnCheckedChangeListener myCheckChangList = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            getService((Integer) buttonView.getTag()).box = isChecked;
        }
    };
}
