package com.kotkin.lg.r25.communalpaymentsdiary;

import static com.kotkin.lg.r25.communalpaymentsdiary.Constants.SERVICES_COLUMN;
import static com.kotkin.lg.r25.communalpaymentsdiary.Constants.PREVIOUS_COLUMN;
import static com.kotkin.lg.r25.communalpaymentsdiary.Constants.COMMON_COLUMN;
import static com.kotkin.lg.r25.communalpaymentsdiary.Constants.VOLUME_COLUMN;
import static com.kotkin.lg.r25.communalpaymentsdiary.Constants.SUM_COLUMN;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewHistoryAdapter extends BaseAdapter {
    Activity activity;
    public ArrayList<HashMap> list;

    public ListViewHistoryAdapter(Activity activity, ArrayList<HashMap> list) {
        this.activity = activity;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.column_row, null);
            holder = new ViewHolder();
            holder.txtFirst = (TextView) convertView.findViewById(R.id.service1_textView);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.previous1_textView);
            holder.txtThird = (TextView) convertView.findViewById(R.id.common1_textView);
            holder.txtFourth = (TextView) convertView.findViewById(R.id.volume1_textView);
            holder.txtFifth = (TextView) convertView.findViewById(R.id.sum1_textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        HashMap map = list.get(position);
        holder.txtFirst.setText(map.get(SERVICES_COLUMN).toString());
        holder.txtSecond.setText(map.get(PREVIOUS_COLUMN).toString());
        holder.txtThird.setText(map.get(COMMON_COLUMN).toString());
        holder.txtFourth.setText(map.get(VOLUME_COLUMN).toString());
        holder.txtFifth.setText(map.get(SUM_COLUMN).toString());

        return convertView;
    }

    private class ViewHolder {
        TextView txtFirst;
        TextView txtSecond;
        TextView txtThird;
        TextView txtFourth;
        TextView txtFifth;
    }
}
