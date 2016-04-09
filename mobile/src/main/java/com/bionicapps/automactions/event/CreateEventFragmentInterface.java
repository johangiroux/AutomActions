package com.bionicapps.automactions.event;

import com.bionicapps.automactions.model.Event;

/**
 * Created by johan on 4/9/16.
 */
public interface CreateEventFragmentInterface {

    void showLoading();
    void showEvent(Event event);
    void eventSaved(Event event);
}
