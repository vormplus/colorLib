package colorlib.webservices;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import processing.core.*;


public class WebService {

	protected PApplet p;
	
	protected boolean DEBUG = false;
	
	protected XML getXML( String url, String fileName )
	{
		XML xml = null;
		if ( fileName != null ) {
			try {
				xml = p.loadXML( fileName );
				
			} catch (Exception e) {	
				// DO SOMETHING ???
			}
			
		}
		
		if ( xml == null ) {
			
			if ( DEBUG == true ) {
				p.println( url );
			}
			
			xml = p.loadXML( url );
			
			if ( DEBUG == true ) {
				printXML( url.toString() );
			}
			
			if ( fileName != null ) {
				try {
					PrintWriter xmlFile = new PrintWriter( new OutputStreamWriter( new FileOutputStream( fileName + ".xml" ), "UTF-8" ) );
					// XMLWriter writer = new XMLWriter( xmlFile );
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
		
		return xml;
	}
	
	protected void printXML( String url )
	{
		String lines[] = p.loadStrings( url );
		for ( int i = 0; i < lines.length; i++ ) {
			p.println( lines[i] );
		}
	}
	
}
