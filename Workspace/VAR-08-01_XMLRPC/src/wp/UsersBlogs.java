package wp;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class UsersBlogs {

	private Map<String, URL> result;

	public Map<String, URL> parse(String xml) throws ParserConfigurationException, SAXException, IOException {
		result = null;
		
		if (xml.replace(" ", "").startsWith("<?xml")) { // only attempt to parse xml strings
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxParserFactory.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			xmlReader.setContentHandler(new WordpressParser());
			xmlReader.parse(new InputSource(new StringReader(xml)));
		}

		return (result == null ? Collections.emptyMap() : result);
	}

	private class WordpressParser extends DefaultHandler {
		
		private String blogid;
		private String xmlrpc;

		private boolean parsingName   = false;
		private boolean parsingValue  = false;
		private boolean parsingBlogid = false;
		private boolean parsingXmlrpc = false;

		@Override
		public void startDocument() throws SAXException {
			result = new HashMap<String, URL>();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {

			if (qName.equalsIgnoreCase("fault")) {
				result = null; // questionable
			}
			
			if (qName.equalsIgnoreCase("name")) {
				parsingName = true;
			}
			
			if (qName.equalsIgnoreCase("value")) {
				parsingValue = true;
			}

		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			String characters = new String(ch, start, length);
			
			if (parsingName) {
				if (characters.equalsIgnoreCase("blogid")) {
					parsingBlogid = true;
				} else if (characters.equalsIgnoreCase("xmlrpc")) {
					parsingXmlrpc = true;
				}
			}
			
			if (parsingValue) {
				if (parsingBlogid) {
					blogid = characters;
				} else if (parsingXmlrpc) {
					xmlrpc = characters;
				}
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equalsIgnoreCase("data")) {
				try {
					result.put(blogid, new URL(xmlrpc));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			
			parsingName = false;
			parsingValue = false;
			
			if (qName.equalsIgnoreCase("member")) {
				parsingBlogid = false;
				parsingXmlrpc = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		String sampleResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><methodResponse><params><param><value><array><data><value><struct><member><name>isAdmin</name><value><boolean>1</boolean></value></member><member><name>isPrimary</name><value><boolean>1</boolean></value></member><member><name>url</name><value><string>https://verteiltearchitekturen.wordpress.com/</string></value></member><member><name>blogid</name><value><string>111481277</string></value></member><member><name>blogName</name><value><string>verteiltearchitekturen</string></value></member><member><name>xmlrpc</name><value><string>https://verteiltearchitekturen.wordpress.com/xmlrpc.php</string></value></member></struct></value></data></array></value></param></params></methodResponse>";

		UsersBlogs usersBlogs = new UsersBlogs();

		Map<String, URL> blogs = usersBlogs.parse(sampleResponse); // actual xml string
		
		for (Map.Entry<String, URL> entry : blogs.entrySet()) {
			System.out.printf("Key: %s, Value: %s\n", entry.getKey(), entry.getValue());
		}
		
		Map<String, URL> blogsEmpty = usersBlogs.parse(""); // not an xml string
	}

}
