package com.example.saket.bottomsheetsamp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

/**
 * Created by saket on 03-Sep-16.
 */
public class BottomSheetAdapter extends ArrayAdapter<Integer> {

    private Activity activity;

    public BottomSheetAdapter(Activity context, int resource, Integer[] objects) {
        super(context, resource, objects);
        this.activity = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            row = inflater.inflate(R.layout.item_grid, parent, false);

            holder = new ViewHolder();
            holder.image = (ImageView) row.findViewById(R.id.image);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }

        holder.image.setImageResource(getItem(position));

        return row;
    }

    private static class ViewHolder {
        ImageView image;
    }
}