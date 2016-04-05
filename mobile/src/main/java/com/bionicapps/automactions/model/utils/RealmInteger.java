package com.bionicapps.automactions.model.utils;

import io.realm.RealmObject;

/**
 * Created by johan on 3/20/16.
 */
public class RealmInteger extends RealmObject {

    private int delegate;

    public RealmInteger() {

    }

    public RealmInteger(int delegate) {
        this.setDelegate(delegate);
    }


    public int getDelegate() {
        return delegate;
    }

    public void setDelegate(int delegate) {
        this.delegate = delegate;
    }
}