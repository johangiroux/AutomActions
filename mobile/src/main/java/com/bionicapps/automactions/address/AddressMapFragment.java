package com.bionicapps.automactions.address;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bionicapps.automactions.R;
import com.google.android.gms.maps.MapView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by johan on 4/10/16.
 */
public class AddressMapFragment extends Fragment {

    @Bind(R.id.map_view)
    private MapView mapView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address_map, container, false);
        ButterKnife.bind(this, view);

        return view;
    }
