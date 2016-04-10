package com.bionicapps.automactions.event;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.bionicapps.automactions.R;
import com.bionicapps.automactions.address.AddressMapActivity;
import com.bionicapps.automactions.model.Action;
import com.bionicapps.automactions.model.ActionIntentType;
import com.bionicapps.automactions.model.Address;
import com.bionicapps.automactions.model.Event;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    @Bind(R.id.action_choosed)
    protected View actionChoosed;
    @Bind(R.id.action_choosed_value)
    protected TextView actionIntent;
    @Bind(R.id.action_types)
    protected View actionButtons;

    protected CreateEventPresenter createEventPresenter;

    protected Event event;
    protected Action action;

    private int selectedPositionAddress;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createEventPresenter = new CreateEventPresenterImpl(this);
        event = new Event();
        action = new Action();
        event.setAction(action);
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

        final ArrayList<Address> arrayList = new ArrayList<>(addresses.size() + 1);
        arrayList.addAll(addresses);
        if (addresses.size() == 0) {
            arrayList.add(new Address(0, 0, getString(R.string.empty)));
        }
        arrayList.add(new Address(0, 0, getString(R.string.add_address)));

        AddressAdapter addressAdapter = new AddressAdapter(getActivity(), android.R.layout.simple_spinner_item, arrayList);
        addressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAddresses.setAdapter(addressAdapter);
        spinnerAddresses.setSelection(0, false);
        spinnerAddresses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == arrayList.size() - 1) {
                    startActivity(new Intent(getActivity(), AddressMapActivity.class));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @OnClick(R.id.action_choosed_clear)
    protected void clearAction(View view) {
        actionIntent.setText("");
        actionChoosed.setVisibility(View.GONE);
        actionButtons.setVisibility(View.VISIBLE);
        action = new Action();
    }

    @OnClick(R.id.action_type_url)
    protected void displayUrlDialog(View view) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        final View dialogView = inflater.inflate(R.layout.dialog_edittext, null);
        dialogBuilder.setView(dialogView);


        String value = "";
        if (event != null && event.getAction() != null) {
            value = event.getAction().getIntent();
        }

        final EditText edt = (EditText) dialogView.findViewById(R.id.edit_text);
        edt.setText(value);
        edt.setSelection(value.length());

        dialogBuilder.setTitle(R.string.url);
        dialogBuilder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                action.setActionIntentType(new ActionIntentType(ActionIntentType.IntentTypeEnum.URL));
                action.setIntent(edt.getText().toString());
                actionIntent.setText(edt.getText().toString());
                actionChoosed.setVisibility(View.VISIBLE);
                actionButtons.setVisibility(View.GONE);
                dialog.dismiss();
            }
        });
        dialogBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }


    @OnClick({ R.id.action_day_monday, R.id.action_day_tuesday, R.id.action_day_wednesday,
            R.id.action_day_thursday, R.id.action_day_friday, R.id.action_day_saturday, R.id.action_day_sunday})
    public void onDayClick(View view) {
        view.setSelected(!view.isSelected());
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void eventSaved(Event event) {

    }

    @Override
    public void showEvent(Event event) {
        this.event = event;
        action = event.getAction();
    }
}
