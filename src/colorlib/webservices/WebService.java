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
