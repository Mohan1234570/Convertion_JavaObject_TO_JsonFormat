package com.gmk;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxMain {

	public static void main(String[] args) throws JAXBException, IOException {
		 Employee em = new  Employee();
		 em.setEmpid(101);
		 em.setEmpName("GMK");
		 em.setSalary(30000.00);
		 
		 
		 JAXBContext context = JAXBContext.newInstance( Employee.class);
		 Marshaller marshaller  = context.createMarshaller();
		 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 marshaller.marshal(em, new FileWriter("C:\\Workspace\\ahokit\\Xml_docs\\Employee.xml"));
		 System.out.println("Marshalling done");
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Employee object = (Employee)unmarshaller.unmarshal(new FileReader("C:\\Workspace\\ahokit\\Xml_docs\\Employee.xml"));
		System.out.println("Unmarshalling done");
		System.out.println(object.getEmpid());
		System.out.println(object.getEmpName());
		System.out.println(object.getSalary());
		
	}
	

}