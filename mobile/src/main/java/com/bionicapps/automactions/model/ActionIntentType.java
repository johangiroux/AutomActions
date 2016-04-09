package com.bionicapps.automactions.model;

import io.realm.RealmObject;

/**
 * Created by johan on 3/20/16.
 */
public class ActionIntentType extends RealmObject {

    public ActionIntentType() {
    }

    public ActionIntentType(IntentTypeEnum enumType) {
        saveEnum(enumType);
    }

    public enum IntentTypeEnum {
        URL,
        APP,
        CUSTOM
    }


    private String enumIntent;

    public void saveEnum(IntentTypeEnum val) {
        this.enumIntent = val.toString();
    }

    public IntentTypeEnum getEnum() {
        return IntentTypeEnum.valueOf(enumIntent);
    }

}
