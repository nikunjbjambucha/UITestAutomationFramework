package DataProvider;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.openqa.selenium.WebDriver;

public class ReadXML {

	public static String Customer_ID;
	public static String Company_Name;
	public static String Contact_Name;
	public static String Contact_Title;

	public static void readXML() 
	{
		try
		{
			String filePath = "./Data/sample_CustomersOrders.xml";
			File file = new File(filePath);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbf.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("Customer");
			int tLength = nodeList.getLength();
			
			for(int i=0; i<1; i++)
			{
				Node node = nodeList.item(i);
				if(node.getNodeType()==Node.ELEMENT_NODE)
				{
				Element element = (Element)node;

				Customer_ID = element.getAttribute("CustomerID");
				Company_Name = element.getElementsByTagName("CompanyName").item(0).getTextContent();
				Contact_Name = element.getElementsByTagName("ContactName").item(0).getTextContent();
				Contact_Title = element.getElementsByTagName("ContactTitle").item(0).getTextContent();

				System.out.println("Cutomer: "+element.getAttribute("CustomerID"));
				System.out.println("Company Name: "+element.getElementsByTagName("CompanyName").item(0).getTextContent());
				System.out.println("Contact Name: "+element.getElementsByTagName("ContactName").item(0).getTextContent());
				System.out.println("Contact Title: "+element.getElementsByTagName("ContactTitle").item(0).getTextContent());
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

