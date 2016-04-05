package com.bionicapps.automactions.main;


import com.bionicapps.automactions.model.Event;

import java.util.List;

/**
 * Created by johan on 3/20/16.
 */
public class MainPresenterImpl implements MainPresenter, FindItemsInteractor.OnFinishedListener {

    private FindItemsInteractor findItemsInteractor;
    private MainViewFragmentInterface mainViewFragment;

    public MainPresenterImpl(MainViewFragmentInterface mainFragmentView) {
        this.mainViewFragment = mainFragmentView;
        findItemsInteractor = new FindItemsInteractorImpl();
    }


    @Override
    public void onResume() {
        if (mainViewFragment != null) {
            mainViewFragment.showLoading();
        }
        findItemsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(Event event) {

    }

    @Override
    public void onDestroy() {
        mainViewFragment = null;
    }

    @Override
    public void onFinished(List<Event> items) {
        if (mainViewFragment != null) {
            mainViewFragment.setItems(items);
        }
    }
}
