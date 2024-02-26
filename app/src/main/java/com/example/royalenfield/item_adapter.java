package com.example.royalenfield;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// ********************************************This class is for setting images for spinner in book bike section**************************
public class item_adapter extends BaseAdapter {
    Context c;
    String[] bike_names;
    int[] bike_icons;

    public item_adapter(Context c, String[] bike_names, int[] bike_icons) {
        this.c = c;
        this.bike_names = bike_names;
        this.bike_icons = bike_icons;
    }

    @Override
    public int getCount() {
        return bike_names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(c).inflate(R.layout.spinner_image_layout,viewGroup,false);
        ImageView iv= view.findViewById(R.id.img_icon);
        TextView tv= view.findViewById(R.id.tv);

        iv.setImageResource(bike_icons[i]);
        tv.setText(bike_names[i]);

        return view;

    }
}
