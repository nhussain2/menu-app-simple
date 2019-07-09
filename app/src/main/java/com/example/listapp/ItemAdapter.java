package com.example.listapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] items;
    String[] prices;
    String[] descriptions;

    //constructor for class
    public ItemAdapter(Context c, String[] i, String [] p, String[] d){
        items = i;
        prices = p;
        descriptions = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.length; // returns length of the items
    }

    @Override
    public Object getItem(int i) {
        return items[i]; // returns indexed item
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //inflating view and putting values in it
        View v = mInflater.inflate(R.layout.my_listview_detail, null);

        // Inflate method takes layout and view
        TextView nameTextView = (TextView) v.findViewById(R.id.nameTextView);
        TextView descTextView = (TextView) v.findViewById(R.id.descTextView);
        TextView pricesTextView = (TextView) v.findViewById(R.id.pricetextView);

        //retrieving info
        String name = items[i];
        String desc = descriptions[i];
        String cost = prices[i];

        //displays on text views
        nameTextView.setText(name);
        descTextView.setText(desc);
        pricesTextView.setText(cost);



        return v;
        //returns v (view - the layout file)

    }
}
