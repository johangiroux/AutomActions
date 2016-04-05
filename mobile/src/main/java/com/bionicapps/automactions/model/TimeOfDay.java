package com.bionicapps.automactions.model;

import io.realm.RealmObject;

/**
 * Created by johan on 3/20/16.
 */
public class TimeOfDay extends RealmObject {

    public enum TimeOfDayEnum {
        MORNING, // 6-12
        AFTERNOON, // 12-18
        EVENING, // 18 - 24
        NIGHT // 0-6
    }

    private String enumDescription;

    public void saveEnum(TimeOfDayEnum val) {
        this.enumDescription = val.toString();
    }

    public TimeOfDayEnum getEnum() {
        return TimeOfDayEnum.valueOf(enumDescription);
    }
}
