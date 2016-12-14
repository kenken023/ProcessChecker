package com.fritzsalar.parser;

import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.fritzsalar.parser.models.*;

public class XmlParser {
	private final String CONFIG_XML = "config.xml";

	public Services unmarshal() {
		Services myService = null;

		try {
			JAXBContext context = JAXBContext.newInstance(Services.class);

			Unmarshaller um = context.createUnmarshaller();
			Services bookstore2 = myService = (Services) um.unmarshal(new FileReader(CONFIG_XML));
			ArrayList<Service> list = bookstore2.getServiceList();
			for (Service service : list) {
				System.out.println("Processes: " + service.getName());
				
				Processes p = service.getProcesses();
				ArrayList<com.fritzsalar.parser.models.Process> listP = p.getProcessList();
				System.out.println("Name: " + listP.get(0).getName());
				
				Actions actions = listP.get(0).getActions();
				ArrayList<Action> actionList = actions.getActionList();
				System.out.println(actionList.get(0).value + actionList.get(1).value + actionList.get(2).value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return myService;
	}
}
