package com.bionicapps.automactions.event;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.bionicapps.automactions.R;
import com.bionicapps.automactions.model.Address;
import com.bionicapps.automactions.model.Event;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by johan on 3/21/16.
 */
public class CreateEventFragment extends Fragment implements CreateEventFragmentInterface {

    public CreateEventFragment() {
    }

    @Bind(R.id.spinner_action)
    protected Spinner spinnerActions;
    @Bind(R.id.spinner_when)
    protected Spinner spinnerTime;
    @Bind(R.id.spinner_when_action)
    protected Spinner spinnerLocationAction;
    @Bind(R.id.spinner_addresses)
    protected Spinner spinnerAddresses;
    @Bind(R.id.edittext_description)
    protected EditText editTextDescription;
    @Bind(R.id.button_save)
    protected Button buttonSave;

    @Bind(R.id.edittext_description)
    protected EditText editTextDescription;

    protected CreateEventPresenter createEventPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createEventPresenter = new CreateEventPresenterImpl(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_event, container, false);
        ButterKnife.bind(this, view);

        ArrayAdapter<CharSequence> actionAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_actions, android.R.layout.simple_spinner_item);
        actionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerActions.setAdapter(actionAdapter);

        ArrayAdapter<CharSequence> timeAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_time, android.R.layout.simple_spinner_item);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTime.setAdapter(timeAdapter);

        ArrayAdapter<CharSequence> locationAdapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_zone_actions, android.R.layout.simple_spinner_item);
        locationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocationAction.setAdapter(locationAdapter);

        Realm realm = Realm.getDefaultInstance();

        RealmResults<Address> addresses = realm.where(Address.class)
                .findAll();

        ArrayList<Address> arrayList = new ArrayList<>(addresses.size()+1);
        arrayList.addAll(addresses);
        arrayList.add(new Address(0, 0, "Add Address"));

        AddressAdapter addressAdapter = new AddressAdapter(getActivity(), android.R.layout.simple_spinner_item, arrayList);
        addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAddresses.setAdapter(addressAdapter);

        return view;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void eventSaved(Event event) {

    }

    @Override
    public void showEvent(Event event) {

    }
}
