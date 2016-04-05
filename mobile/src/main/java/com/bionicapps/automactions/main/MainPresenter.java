package com.bionicapps.automactions.main;

import com.bionicapps.automactions.model.Event;

/**
 * Created by johan on 3/20/16.
 */
public interface MainPresenter {

    void onResume();
    void onItemClicked(Event event);
    void onDestroy();
}
