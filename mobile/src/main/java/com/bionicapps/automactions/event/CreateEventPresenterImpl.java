package com.bionicapps.automactions.event;

/**
 * Created by johan on 4/3/16.
 */
public class CreateEventPresenterImpl implements CreateEventPresenter {

    private CreateEventFragmentInterface createEventFragmentInterface;

    public CreateEventPresenterImpl(CreateEventFragmentInterface createEventFragmentInterface) {
        this.createEventFragmentInterface = createEventFragmentInterface;
    }

    @Override
    public void onClickSaveButton() {
        // save data & exit
    }
}
