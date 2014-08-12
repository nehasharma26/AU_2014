package assignment.jaxb;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbRun {
	
	  private static final String FILE_NAME = "jaxb-inst.xml";
	  
	  public static void jaxbRun(InstituteXML instXml)
	  {
	 
	        jaxbObjectToXML(instXml);
	 
	        InstituteXML instFromFile = jaxbXMLToObject();
	        System.out.println(instFromFile.toString());
	    }
	 
	 
	    private static InstituteXML jaxbXMLToObject() {
	        try {
	            JAXBContext context = JAXBContext.newInstance(InstituteXML.class);
	            Unmarshaller un = context.createUnmarshaller();
	            InstituteXML emp = (InstituteXML) un.unmarshal(new File(FILE_NAME));
	            return emp;
	        } catch (JAXBException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	 
	 
	    private static void jaxbObjectToXML(InstituteXML emp) {
	 
	        try {
	            JAXBContext context = JAXBContext.newInstance(InstituteXML.class);
	            Marshaller m = context.createMarshaller();
	            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 
	            m.marshal(emp, new File(FILE_NAME));
	        } catch (JAXBException e) {
	            e.printStackTrace();
	        }
	    }
	 
	}


