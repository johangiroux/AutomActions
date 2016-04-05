package com.bionicapps.automactions.model;

import com.bionicapps.automactions.model.utils.RealmInteger;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by johan on 3/20/16.
 */
public class GeoFenceEvent extends RealmObject {

    @PrimaryKey
    private String requestId;
    private float radius;
    private RealmList<RealmInteger> transitionTypes;
    private Address address;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public RealmList<RealmInteger> getTransitionTypes() {
        return transitionTypes;
    }

    public void setTransitionTypes(RealmList<RealmInteger> transitionTypes) {
        this.transitionTypes = transitionTypes;
    }
}
