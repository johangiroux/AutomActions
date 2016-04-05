package com.bionicapps.automactions.main;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bionicapps.automactions.R;
import com.bionicapps.automactions.model.Event;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MainViewFragmentInterface, EventAdapter.EventAdapterInterface {

    public MainActivityFragment() {
    }

    @Bind(R.id.recyclerView)
    protected RecyclerView recyclerView;
    @Bind(R.id.empty)
    protected View emptyView;

    private MainPresenter presenter;
    private EventAdapter eventAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        presenter = new MainPresenterImpl(this);
        eventAdapter = new EventAdapter(this);

        recyclerView.setAdapter(eventAdapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void setItems(List<Event> items) {
        eventAdapter.setEvents(items);
    }

    @Override
    public void onItemClick(Event event) {
        presenter.onItemClicked(event);
    }
}
