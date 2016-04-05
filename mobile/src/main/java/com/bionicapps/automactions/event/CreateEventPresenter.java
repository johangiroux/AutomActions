package com.bionicapps.automactions.event;

import com.bionicapps.automactions.model.Event;

/**
 * Created by johan on 3/20/16.
 */
public interface CreateEventPresenter {

    void onActionSelected();
    void onActionReseted();
    void onClickNewAddress();
    void onClickPickTime();
    void onClickSaveButton;
}
