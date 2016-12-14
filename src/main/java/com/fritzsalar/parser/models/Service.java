package com.fritzsalar.parser.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "service")
public class Service {
	private String name;

	@XmlAttribute(name = "name")
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
    private Processes processes;

    @XmlElement(name = "processes")
    public Processes getProcesses() {
            return processes;
    }

    public void setProcesses(Processes processes) {
            this.processes = processes;
    }
}
