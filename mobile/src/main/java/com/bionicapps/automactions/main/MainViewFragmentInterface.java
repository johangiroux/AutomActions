package com.bionicapps.automactions.main;

import com.bionicapps.automactions.model.Event;

import java.util.List;

/**
 * Created by johan on 3/20/16.
 */
public interface MainViewFragmentInterface {

    void showLoading();
    void setItems(List<Event> items);
}
