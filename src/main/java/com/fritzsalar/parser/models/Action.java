package com.fritzsalar.parser.models;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "action")
public class Action {
	@XmlValue
	public String value;
}
