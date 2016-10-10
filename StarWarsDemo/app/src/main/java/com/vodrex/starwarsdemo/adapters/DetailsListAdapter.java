package com.vodrex.starwarsdemo.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vodrex.starwarsdemo.R;
import com.vodrex.starwarsdemo.model.Detail;
import com.vodrex.starwarsdemo.rest.plates.Character;

import java.util.List;


/**
 * Created by vodrex on 10/9/16.
 */
public class DetailsListAdapter extends BaseAdapter {

    private List<Detail> details;


    public DetailsListAdapter(List<Detail> details) {
        this.details = details;
    }

    @Override
    public int getCount() {
        return details.size();
    }

    @Override
    public Detail getItem(int position) {
        return details.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater mInflater = (LayoutInflater) viewGroup.getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_details_list, viewGroup, false);
        }

        Detail detail = getItem(position);
        TextView tvParameter = (TextView) convertView.findViewById(R.id.tv_parameter);
        TextView tvValue = (TextView) convertView.findViewById(R.id.tv_value);

        tvParameter.setText(detail.getParameter() + ":");
        tvValue.setText(detail.getValue());


        return convertView;
    }


}