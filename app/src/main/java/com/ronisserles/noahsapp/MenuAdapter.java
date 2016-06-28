package com.ronisserles.noahsapp;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Tardis on 5/14/16.
 */
public class MenuAdapter extends ArrayAdapter<String> {

    private Activity context;
    private String[] itemTxt;
    private TypedArray itemImg;

    public MenuAdapter(Activity context, String[] itemTxt, TypedArray itemImg) {
        super(context, R.layout.menu_item, itemTxt);
        this.context = context;
        this.itemTxt = itemTxt;
        this.itemImg = itemImg;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(R.layout.menu_item,null,true);

        ImageView img = (ImageView) row.findViewById(R.id.miImg);
        TextView tv = (TextView) row.findViewById(R.id.miTxt);

        Drawable image = itemImg.getDrawable(position);
        //img.setImageResource(itemImg[position]);
        img.setImageDrawable(image);
        tv.setText(itemTxt[position]);

        return row;
    }
}
