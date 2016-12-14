package com.fritzsalar.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LinuxProcess extends ProcessBase {
	@Override
	public List<String> list() {
		return this.retriever("");
	}
	
	@Override
	public List<String> get(String processName) {
		return this.retriever(processName);
	}
	
	private List<String> retriever(String processName) {
		List<String> list = new ArrayList<String>();
		String process = processName.length() > 0 ? " | grep " + processName : "";
		
		try {
		    String line;
		    String[] cmd = { "/bin/sh", "-c", "ps -ef" + process };
		    Process p = Runtime.getRuntime().exec(cmd);
		    BufferedReader in =
		            new BufferedReader(new InputStreamReader(p.getInputStream()));
		    while ((line = in.readLine()) != null) {
		        System.out.println(line);
		        list.add(line);
		    }
		    in.close();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}

		return list;
	}
}
