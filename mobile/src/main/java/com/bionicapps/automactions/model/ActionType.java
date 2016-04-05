package com.bionicapps.automactions.model;

import io.realm.RealmObject;

/**
 * Created by johan on 3/20/16.
 */
public class ActionType extends RealmObject {

    public enum ActionTypeEnum {
        ASK_ME_TO_OPEN,
        OPEN,
        REMINDER
    }


    private String enumDescription;

    public void saveEnum(ActionTypeEnum val) {
        this.enumDescription = val.toString();
    }

    public ActionTypeEnum getEnum() {
        return ActionTypeEnum.valueOf(enumDescription);
    }

}
