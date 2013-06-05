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

import java.util.ArrayList;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.*;

import processing.core.*;

import colorlib.Palette;
import colorlib.webservices.WebService;

public class Kuler extends WebService
{

	// TODO: Rewrite Kuler class to work with the new Kuler API
	// Hopefully they will have a JSON api available.
	
	protected PApplet p;
	
	private String key;
	
	private String KULER_API_URL = "http://kuler-api.adobe.com/rss/";
	
	/**
	 * 
	 * @param parent
	 * @param _key
	 */
	public Kuler( final PApplet parent, String _key )
	{
		p = parent;
		key = _key;
		
		// p.println( "KEY: " + key );
		
		p.println("Kuler is support not implemented yet.");
		
	}
	
	/**
	 * 
	 * @return
	 */
	public void getHighestRated() // should return KulerPalette[]
	{
	//	return makeKulerPalettes( "&listtype=rating", "get", null );
	}
	
	/**
	 * 
	 * @param query
	 * @param queryType
	 * @param fileName
	 * @return
	 */
	private void makeKulerPalettes( final String query, final String queryType, final String fileName ) // should return KulerPalette[]
	{
		
		String url = new StringBuffer( KULER_API_URL ).append( queryType ).append( ".cfm?" )
		                                              .append( query )
		                                              .append( "&key=" + key )
		                                              .toString();
		
		p.println( url );
		

	}
}