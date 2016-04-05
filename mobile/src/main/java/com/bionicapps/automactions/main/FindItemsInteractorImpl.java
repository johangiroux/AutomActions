package com.bionicapps.automactions.main;


import com.bionicapps.automactions.model.Event;

import java.util.List;

import io.realm.Realm;

/**
 * Created by johan on 3/20/16.
 */
public class FindItemsInteractorImpl implements FindItemsInteractor {

    private Realm realm;

    @Override
    public void findItems(final OnFinishedListener listener) {

        if (realm == null) {
            realm = Realm.getDefaultInstance();
        }
        listener.onFinished(getAllEvents());
    }

    private List<Event> getAllEvents() {
        return realm.allObjects(Event.class);
    }
}
