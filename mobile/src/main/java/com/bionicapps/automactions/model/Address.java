package com.bionicapps.automactions.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by johan on 3/20/16.
 */
public class Address extends RealmObject {

    public Address() {
    }

    public Address(double latitude, double longitude, String name) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.addressName = name;
    }

    @PrimaryKey
    private String addressName; // Home, Work, School, Gym ...

    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String name) {
        this.addressName = name;
    }

    @Override
    public String toString() {
        return addressName;
    }
}
