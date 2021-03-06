package com.fritzsalar.parser.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "process")
@XmlType(propOrder = { "name", "dir", "script" })
public class Process {
	private String name;
    private String dir;
    private String script;

    @XmlAttribute(name = "name")
    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    @XmlElement(name = "dir")
    public String getDir() {
            return dir;
    }

    public void setDir(String dir) {
            this.dir = dir;
    }

    @XmlElement(name = "script")
    public String getScript() {
            return script;
    }

    public void setScript(String script) {
            this.script = script;
    }
}
