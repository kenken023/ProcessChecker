package com.fritzsalar.parser.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Processes {
    private ArrayList<Process> processList;

    @XmlElement(name = "process")
    public ArrayList<Process> getProcessList() {
            return processList;
    }

    public void setProcessList(ArrayList<Process> processList) {
            this.processList = processList;
    }
}
