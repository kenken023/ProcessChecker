package com.fritzsalar.processes;

import java.util.List;

public interface IProcess {
	public List<String> list();
	public List<String> get(String processName);
	public Boolean execute(String script);
}
