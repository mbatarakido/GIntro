package com.example.mysqlfruitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflator;
    Map<Integer, String> map;
    List<Integer> client_id;
    List<String> client_name;
    //List<Double> prices;

    public ItemAdapter(Context c, Map m){
        mInflator = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        map = m;
        client_id = new ArrayList<Integer>(map.keySet());
        client_name = new ArrayList<String>(map.values());
    }
    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public Object getItem(int position) {
        return client_id.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflator.inflate(R.layout.item_layout, null);
        TextView clientNameTextView = (TextView) v.findViewById(R.id.clientNameTextView);
        TextView clientIdTextView = (TextView) v.findViewById(R.id.clientIdTextView);
        //TextView branchIdTextView = (TextView) v.findViewById(R.id.branchIdTextView);

        clientNameTextView.setText(client_id.get(position));
        clientIdTextView.setText("$" + client_name.get(position).toString());

        return v;
    }
}
