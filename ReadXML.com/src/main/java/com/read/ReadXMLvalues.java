package com.read;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLvalues {

	public static void main(String[] args){

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder DocumentBuilder = builderFactory.newDocumentBuilder();
			try {
				Document doc = DocumentBuilder.parse("C:\\Users\\SANTHOSH KUMAR\\eclipse-workspace\\ReadXML.com\\XML\\Sample.xml");

				NodeList list = doc.getElementsByTagName("VIF");

				for (int i = 0; i < list.getLength(); i++) {

					Node v = list.item(i);

					if(v.getNodeType()==Node.ELEMENT_NODE) {

						Element grl = (Element)v;

						String productType = grl.getAttribute("value");

						NodeList childNodes = grl.getChildNodes();

						for (int j = 0; j < childNodes.getLength(); j++) {

							Node item = childNodes.item(j);

							if (item.getNodeType()==Node.ELEMENT_NODE) {

								Element values = (Element)item;

								System.out.println(values.getTagName()+values.getTextContent());

							}

						}





					}

				}



			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



}



