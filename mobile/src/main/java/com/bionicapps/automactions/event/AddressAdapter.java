package com.bionicapps.automactions.event;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bionicapps.automactions.model.Address;

import java.util.List;

/**
 * Created by johan on 4/3/16.
 */
public class AddressAdapter extends ArrayAdapter<Address> {

    private Context context;
    private LayoutInflater layoutInflater;

    public AddressAdapter(Context context, int resource, List<Address> objects) {
        super(context, resource, objects);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textview;

        if (convertView == null) {
            textview = (TextView) layoutInflater.inflate(android.R.layout.simple_spinner_item, parent, false);
        } else {
            textview = (TextView) convertView;
        }

        textview.setText(getItem(position).getAddressName());

        return textview;
    }
}
