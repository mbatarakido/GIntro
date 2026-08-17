
import java.io.*;
import nu.xom.*;

public class DomainEditor {
	public static void main(String[] args) throws IOException {
		try {
			//create a tree from the XML document feed.rss
			Builder builder = new Builder();
			File xmlFile = new File("feed.rss");
			Document doc = builder.build(xmlFile);
			
			//get the root element <rss>
			Element root = doc.getRootElement();
			
			//get its <channel> element
			Element channel = root.getFirstChildElement("channel");
			
			//get its <link> elements
			Elements children = channel.getChildElements();
			for(int i = 0; i < children.size(); i++) {
				//get a <link> element
				Element link = children.get(i);
				
				//get its text
				Text link1Text = (Text) link.getChild(0);
				
				//update any link matching a URL
				if(link1Text.getValue().equals("http://workbench.cadenhead.org/")) {
					//update the link's text
					link.removeChild(0);
					link.appendChild("http://www.cadenhead.org/");
					
				}
				/*
				Element item = channel.getFirstChildElement("item");
				//get its <title> element>
				Elements itemChildren = item.getChildElements();
				for(int j = 0; j < itemChildren.size(); j++) {
					Element title = itemChildren.get(j);
					Text title1text = (Text) title.getChild(0);
					if(title1text.getValue().equals("Programming Confidence Pool for the World Cup")) {
						title.removeChild(0);
						title.appendChild("A New Title in for the Item");
					}
				}*/
			}
			//create new elements and attributes to add
			Element item2 = new Element("item");
			Element itemTitle2 = new Element("title");
			
			//add them to the <channel> element
			itemTitle2.appendChild("Free the Bound Periodicals");
			item2.appendChild(itemTitle2);
			channel.appendChild(item2);
			
			//Save the XML document
			try(
					FileWriter fw = new FileWriter("feed2.rss");
					BufferedWriter out = new BufferedWriter(fw);
					){
				out.write(doc.toXML());
			}catch(IOException ioe) {
				System.out.println(ioe.getMessage());
			}
			System.out.println(doc.toXML());
		}catch(ParsingException pe) {
			System.out.println("Perse error: " + pe.getMessage());
			pe.printStackTrace();
			System.exit(-1);
		}
	}
}
