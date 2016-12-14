package com.fritzsalar.process;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UnixProcess extends ProcessBase {
	private final String BASH_CMD = "/bin/sh";
	private final String BASH_OPT = "-c";
	private final String BASH_PS = "ps -ef";
	
	@Override
	public List<String> list() {
		return this.retriever("");
	}
	
	@Override
	public List<String> get(String processName) {
		return this.retriever(processName);
	}
	
	@Override
	public Boolean execute(String processName, String action) {
		return this.executer(processName, action);
	}

	private List<String> retriever(String processName) {
		List<String> list = new ArrayList<String>();
		String psCmd = BASH_PS;
		
		if (processName.length() > 0) {
			psCmd += " | grep " + processName;
		}
		
		try {
		    String line;
		    String[] cmd = { BASH_CMD, BASH_OPT, psCmd };
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
	
	private Boolean executer(String processName, String action) {
		Boolean executed = false;
		
		try {
		    String[] cmd = { BASH_CMD, BASH_OPT, "curl google.com" };
		    Process p = Runtime.getRuntime().exec(cmd);
		    p.waitFor();
		    executed = p.exitValue() == 0 ? true : false;
		    p.destroy();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}

		return executed;
	}
}
