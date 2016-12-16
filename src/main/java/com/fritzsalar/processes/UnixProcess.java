package com.fritzsalar.processes;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UnixProcess extends ProcessBase {
	private final String BASH_CMD = "/bin/bash";
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
	public Boolean execute(String script) {
		return this.executer(script);
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
//		        System.out.println(line);
		        list.add(line);
		    }
		    in.close();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}

		return list;
	}
	
	private Boolean executer(String script) {
		Boolean executed = false;
		
		try {
//		    String[] cmd = { BASH_CMD, BASH_OPT, "cd /opt/apps/collab && /Users/fritz/.rvm/gems/ruby-1.9.3-p484/bin/bundle exec script/campout stop" };
//		    String[] cmd = { BASH_CMD, BASH_OPT, "cd /opt/apps/collab", "pwd", "script/campout stop" };
//		    Process p = Runtime.getRuntime().exec(cmd);
//		    p.waitFor();
//		    executed = p.exitValue() == 0 ? true : false;
//		    p.destroy();
		    
		    ProcessBuilder pb = new ProcessBuilder(BASH_CMD, BASH_OPT, "/Users/fritz/.rvm/rubies/ruby-1.9.3-p484/bin/gem install bundler; bundle exec script/campout stop");
		    
		    
	        Map<String, String> envs = pb.environment();
	        Map<String, String> env1 = pb.environment();
		    for (String key : env1.keySet())
		        System.out.println(key + ": " + env1.get(key));
	        System.out.println(envs.get("PATH"));
	        String path = envs.get("PATH");
//	        path += ":/Users/fritz/.rvm/gems/ruby-1.9.3-p484/bin:/Users/fritz/.rvm/gems/ruby-1.9.3-p484@global/bin:/Users/fritz/.rvm/rubies/ruby-1.9.3-p484/bin:/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/share/dotnet:/Users/fritz/.rvm/bin:/usr/local/sbin:/opt/manifests/consumer/bin:";
//	        envs.put("PATH", path);

	        System.out.println(envs.get("PATH"));
		    pb.directory(new File("/opt/apps/collab"));
	        pb.redirectErrorStream();
	        Process process = pb.inheritIO().start();
	        InputStream is = process.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(isr);
	        String line;
	        while ((line = br.readLine()) != null) {
	            System.out.println(line);
	        }

		} catch (Exception ex) {
		    ex.printStackTrace();
		}

		return executed;
	}
}
