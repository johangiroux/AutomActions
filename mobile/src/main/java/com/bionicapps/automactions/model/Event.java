package com.bionicapps.automactions.model;

import com.bionicapps.automactions.model.utils.RealmInteger;

import org.joda.time.Hours;

import java.util.ArrayList;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by johan on 3/20/16.
 */
public class Event extends RealmObject {

    // name of the event
    @PrimaryKey
    private String name;

    // days of week
    private RealmList<RealmInteger> days;

    // hour (Optional)
    private Integer hour;
    // minutes (Optional)
    private Integer minutes;

    // Time of Day (Optional)
    private TimeOfDay timeOfDay;

    // description (Optional)
    private String description;

    private GeoFenceEvent geoFenceEvent;

    private Action action;


    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public RealmList<RealmInteger> getDays() {
        return days;
    }

    public void setDays(RealmList<RealmInteger> days) {
        this.days = days;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GeoFenceEvent getGeoFenceEvent() {
        return geoFenceEvent;
    }

    public void setGeoFenceEvent(GeoFenceEvent geoFenceEvent) {
        this.geoFenceEvent = geoFenceEvent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(TimeOfDay timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }
}
