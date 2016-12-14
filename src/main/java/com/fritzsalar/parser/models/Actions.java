package com.fritzsalar.parser.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Actions {
    private ArrayList<Action> actionList;

    @XmlElement(name = "action")
    public ArrayList<Action> getActionList() {
            return actionList;
    }

    public void setActionList(ArrayList<Action> actionList) {
            this.actionList = actionList;
    }
}
