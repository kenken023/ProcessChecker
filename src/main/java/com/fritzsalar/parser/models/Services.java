package com.fritzsalar.parser.models;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Services {
	private ArrayList<Service> serviceList;

	public void setServiceList(ArrayList<Service> list) {
		this.serviceList = list;
	}

	@XmlElement(name = "service")
	public ArrayList<Service> getServiceList() {
		return serviceList;
	}
}
