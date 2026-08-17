
import java.io.*;
import nu.xom.*;
public class RssStarter {
	public static void main(String[] args) {
		//Create an <rss> element to serve as the document's root
		Element rss = new Element("rss");
		//add a version attribute to the element
		Attribute version = new Attribute("version", "2.0");
		rss.addAttribute(version);
		
		//create a <channel> element and make it a child of <rss>
		Element channel = new Element("channel");
		rss.appendChild(channel);
		//create the channel's <title>
		Element channelTitle = new Element("title");
		Text titleText = new Text("Workbench");
		channelTitle.appendChild(titleText);
		channel.appendChild(channelTitle);
		//create the channel's <link>
		Element link = new Element("link");
		Text linkText = new Text("http://workbench.cadenhead.org/");
		link.appendChild(linkText);
		channel.appendChild(link);
		
		//create the element <description>
		Element description = new Element("description");
		Text descText = new Text("Programming, publishing, and popes");
		description.appendChild(descText);
		channel.appendChild(description);
		//create the element <docs>
		Element docs = new Element("docs");
		Text docsText = new Text("http://www.rssboard.org/rss-specification");
		docs.appendChild(docsText);
		channel.appendChild(docs);
		
		
		
		
		//create the channel element <item>
		Element item = new Element("item");
		channel.appendChild(item);
		 //create the item's title
		Element itemTitle = new Element("title");
		Text itemTitleText = new Text("Programming Confidence Pool for the World Cup");
		itemTitle.appendChild(itemTitleText);
		item.appendChild(itemTitle);
		
		//create the item <link> element
		Element itemLink = new Element("link");
		Text itemLinkText = new Text("http://workbench.cadenhead.org/news/739");
		itemLink.appendChild(itemLinkText);
		item.appendChild(itemLink);
		//create the item element <pubDate>
		Element pubDate = new Element("pubDate");
		Text pubDateText = new Text("Wed, 11 Jun 2015 11:49:47 -0400");
		pubDate.appendChild(pubDateText);
		item.appendChild(pubDate);
		//create the item <guid> element
		Element itemGuid = new Element("guid");
		Attribute guidPerma = new Attribute("isPermaLink", "false");
		Text itemGuidText = new Text("tag:cadenhead.org,2015:w.739");
		itemGuid.addAttribute(guidPerma);
		itemGuid.appendChild(itemGuidText);
		item.appendChild(itemGuid);
		//create single tag element <enclosure>
		Element itemEnclosure = new Element("enclosure");
		Attribute elength = new Attribute("length", "2498623");
		Attribute etype = new Attribute("type", "audio/mpeg");
		Attribute eURL = new Attribute("url", "http://mp3.cadenhead.org/3679.mp3");
		itemEnclosure.addAttribute(elength);
		itemEnclosure.addAttribute(etype);
		itemEnclosure.addAttribute(eURL);
		item.appendChild(itemEnclosure);
	
		
		
		
		//create a new document <rss> as the root element 
		Document doc = new Document(rss);
		
		//Save the XML document
		try(
				FileWriter fw = new FileWriter("feed.rss");
				BufferedWriter out = new BufferedWriter(fw);
			){
			out.write(doc.toXML());
		}catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		System.out.println(doc.toXML());
	}
}
