package com.vodrex.starwarsdemo.adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vodrex.starwarsdemo.R;
import com.vodrex.starwarsdemo.rest.plates.Character;
import com.vodrex.starwarsdemo.view.DetailsActivity;

import java.util.List;


/**
 * Created by vodrex on 10/9/16.
 */
public class CharactersListAdapter extends BaseAdapter {

    private List<Character> characters;
    LayoutInflater inflater;


    public CharactersListAdapter(List<Character> characters) {
        this.characters = characters;
    }

    @Override
    public int getCount() {
        return characters.size();
    }

    @Override
    public Character getItem(int position) {
        return characters.get(position);
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
            convertView = mInflater.inflate(R.layout.item_character_list, viewGroup, false);
        }

        Character character = getItem(position);
        TextView tvName = (TextView) convertView.findViewById(R.id.character_name);
        tvName.setText(character.getName());
        tvName.setTypeface(null, Typeface.BOLD);

        return convertView;
    }


}