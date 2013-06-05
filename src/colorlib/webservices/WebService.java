/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright (c) ##copyright## ##author##
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package colorlib.webservices;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.*;

import processing.core.*;

abstract class WebService
{

	protected PApplet p;
	
	protected boolean DEBUG = true;
	
	protected URL url = null;
	
	// TODO: Rewrite webservice class to work with JSON.
	
	protected WebService()
	{
		
	}
	
	protected NodeList getXML( String feedURL )
	{
		try {
			url = new URL( feedURL );
		} catch ( MalformedURLException e ) {
			throw new RuntimeException( e );
		}
		
		InputStream feed = getFeed();		
		NodeList root = null;
		
		try {
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse( feed );
			
			root = doc.getChildNodes();
			
		} catch( Exception e ) {
			e.printStackTrace();
		}
		
		return root;
		
	}
	
	/**
	 * Helper function to work get the XML data.
	 * @param tagName
	 * @param nodes
	 * @return
	 */
	private InputStream getFeed()
	{
		try {
			return url.openStream();
		} catch ( IOException e ) {
			throw new RuntimeException( e );
		}
	}

	/**
	 * Print XML file to console
	 * @param url
	 */
	protected void printXML( String url )
	{
		p.println( "printXML()" );
		p.println( "---------------------------------" );
		
		String lines[] = p.loadStrings( url );
		for ( int i = 0; i < lines.length; i++ ) {
			p.println( lines[i] );
		}
	}
	
	/**
	 * Helper function to work with XML data.
	 * @param tagName
	 * @param nodes
	 * @return
	 */
	protected Node getNode( String tagName, NodeList nodes )
	{
		for ( int i = 0; i < nodes.getLength(); i++ ) {
			Node node = nodes.item( i );
			if ( node.getNodeName().equalsIgnoreCase( tagName ) ) {
				return node;
			}
		}
		
		return null;
	}
	
	/**
	 * Helper function to work with XML data.
	 * @param node
	 * @return
	 */
	protected String getNodeValue( Node node )
	{
		NodeList childNodes = node.getChildNodes();
		for ( int i = 0; i < childNodes.getLength(); i++ ) {
			Node data = childNodes.item( i );
			if ( data.getNodeType() == Node.TEXT_NODE ) {
				return data.getNodeValue();
			}
		}
		
		return "";
	}

	/**
	 * Helper function to work with XML data.
	 * @param tagName
	 * @param nodes
	 * @return
	 */
	protected String getNodeValue( String tagName, NodeList nodes )
	{
		for ( int i = 0; i < nodes.getLength(); i++ ) {
			Node node = nodes.item( i );
			if ( node.getNodeName().equalsIgnoreCase( tagName ) ) {
				NodeList childNodes = node.getChildNodes();
				for ( int j = 0; j < childNodes.getLength(); j++ ) {
					Node data = childNodes.item( j );
					if ( data.getNodeType() == Node.TEXT_NODE ) {
						return data.getNodeValue();
					}
				}
			}
		}
		
		return "";
	}
	
	/**
	 * Helper function to work with XML data.
	 * @param attrName
	 * @param node
	 * @return
	 */
	protected String getNodeAttr( String attrName, Node node )
	{
		NamedNodeMap attrs = node.getAttributes();
		for ( int i = 0; i < attrs.getLength(); i++ ) {
			Node attr = attrs.item( i );
			if ( attr.getNodeName().equalsIgnoreCase( attrName ) ) {
				return attr.getNodeValue();
			}	
		}
		
		return "";
	}
	
	/**
	 * Helper function to work with XML data.
	 * @param tagName
	 * @param attrName
	 * @param nodes
	 * @return
	 */
	protected String getNodeAttr( String tagName, String attrName, NodeList nodes )
	{
		for ( int i = 0; i < nodes.getLength(); i++ ) {
			Node node = nodes.item( i );
			if ( node.getNodeName().equalsIgnoreCase( tagName ) ) {
				NodeList childNodes = node.getChildNodes();
				for ( int j = 0; j < childNodes.getLength(); j++ ) {
					Node data = childNodes.item( j );
					if ( data.getNodeType() == Node.ATTRIBUTE_NODE ) {
						if ( data.getNodeName().equalsIgnoreCase( attrName ) ) {
							return data.getNodeValue();
						}
					}
				}
			}
		}
		
		return "";
	}
	
}
