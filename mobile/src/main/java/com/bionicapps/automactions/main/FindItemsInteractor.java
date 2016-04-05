package com.bionicapps.automactions.main;

import com.bionicapps.automactions.model.Event;

import java.util.List;

/**
 * Created by johan on 3/20/16.
 */
public interface FindItemsInteractor {
    interface OnFinishedListener {
        void onFinished(List<Event> items);
    }

    void findItems(OnFinishedListener listener);
}
