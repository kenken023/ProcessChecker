package com.fritzsalar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fritzsalar.constants.ProcessStatus;
import com.fritzsalar.parser.models.*;
import com.fritzsalar.parser.models.Process;
import com.fritzsalar.processes.UnixProcess;
import com.fritzsalar.utilities.parsers.XmlParser;

public class ServicesBL {
	private final String CONFIG_XML = "config.xml";
	
	public Services services;
	

	public ServicesBL() {
		this.services = parseServicesXml();
	}
	
	public List<Service> getList() {
		return this.services.getServiceList();
	}
	
	public List<String> getListByNames() {
		return this.getList().stream().map(s -> s.getName()).collect(Collectors.toCollection(ArrayList::new));
	}
	
	public List<Process> getProcessList(Service service) {
		return service.getProcesses().getProcessList();
	}
	
	public ProcessStatus getProcessStatus(String service, String process) {
		UnixProcess unixProcess = new UnixProcess();
		boolean containsProcess = 
				unixProcess.get(process).stream()
				.filter(s -> hasProcess(s, service, process)).count() > 0;
		
		return containsProcess ? ProcessStatus.ACTIVE : ProcessStatus.INACTIVE;
	}
	
	public void start(Process process) {
		this.executeScript(String.format("cd %s && %s", process.getDir(), process.getScript()), "start");
	}
	
	public void start(Service service) {
		
	}
	
	public void stop(Process process) {
		this.executeScript(String.format("cd %s && %s", process.getDir(), process.getScript()), "stop");
	}
	
	public void stop(Service service) {
		
	}
	
	public void restart(Process process) {
		
	}
	
	public void restart(Service service) {
		
	}
	
	
	// Private Methods
	
	private Boolean executeScript(String script, String action) {
		UnixProcess unixProcess = new UnixProcess();
//		System.out.println(String.format("Script: %s %s", script, action));
		return unixProcess.execute(String.format("%s %s", script, action));
	}
	
	private Services parseServicesXml() {
		XmlParser<Services> parser = new XmlParser<Services>(Services.class);
		return parser.unmarshal(CONFIG_XML);
	}
	
	private boolean hasProcess(String process, String serviceName, String processName) {
		return process.indexOf(processName.toLowerCase()) >= 0 && process.indexOf(serviceName.toLowerCase()) >= 0 && process.indexOf("grep") == -1;
	}
}
