package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

/*
Комментарий внутри xml
*/
public class Solution {

	private static StringBuilder sb = new StringBuilder();

	public static String toXmlWithComment(Object obj, String tagName, String comment) throws IOException {

		String xmlString = jaxbObjectToXML(obj);
		BufferedReader br = new BufferedReader(new StringReader(xmlString));

		String s;
		while ((s = br.readLine()) != null) {
			s = s.replaceAll("\\s", "");
			if (s.contains("standalone=\"yes\"")) {
				s = s.replaceAll("yes", "no");
			}

			if (s.matches(".*[<>&'\"].*")) {
				if (s.contains(tagName)) {
					sb.append("<!--" + comment + "-->" + "\n");
				}
			}
			sb.append(s + "\n");
		}

		return sb.toString();
	}

	private static String jaxbObjectToXML(Object obj) {
		String xmlString = "";
		try {
			JAXBContext context = JAXBContext.newInstance(obj.getClass());
			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

			StringWriter sw = new StringWriter();
			m.marshal(obj, sw);
			xmlString = sw.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return xmlString;
	}


	public static void main (String[]args) throws IOException {
		System.out.println(toXmlWithComment(new First(), "second", "it's a comment"));
	}
}



