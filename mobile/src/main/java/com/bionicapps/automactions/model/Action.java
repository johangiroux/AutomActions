package com.bionicapps.automactions.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by johan on 3/20/16.
 */
public class Action extends RealmObject {

    // name of the action, i.e "Open Google Play Music"
    private String name;

    // open intent scheme
    private String intent;
    private String description;
    private ActionType actionType;
    private ActionIntentType actionIntentType;


    public ActionIntentType getActionIntentType() {
        return actionIntentType;
    }

    public void setActionIntentType(ActionIntentType actionIntentType) {
        this.actionIntentType = actionIntentType;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
