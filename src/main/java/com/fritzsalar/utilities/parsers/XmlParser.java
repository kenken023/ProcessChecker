package com.fritzsalar.utilities.parsers;

import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class XmlParser<T> {
//	private final String CONFIG_XML = "config.xml";
	private final Class<T> classType;
	
	public XmlParser(Class<T> classType) {
		this.classType = classType;
	}

	@SuppressWarnings("unchecked")
	public T unmarshal(String path) {
		T rootElement = null;

		try {
			JAXBContext context = JAXBContext.newInstance(this.classType);

			Unmarshaller um = context.createUnmarshaller();
			rootElement = (T) um.unmarshal(new FileReader(path));
//			ArrayList<Service> list = bookstore2.getServiceList();
//			for (Service service : list) {
//				System.out.println("Processes: " + service.getName());
//				
//				Processes p = service.getProcesses();
//				ArrayList<com.fritzsalar.parser.models.Process> listP = p.getProcessList();
//				System.out.println("Name: " + listP.get(0).getName());
//				
//				Actions actions = listP.get(0).getActions();
//				ArrayList<Action> actionList = actions.getActionList();
//				System.out.println(actionList.get(0).value + actionList.get(1).value + actionList.get(2).value);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rootElement;
	}
}
