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

import processing.core.*;
import colorlib.Palette;

public class Kuler extends WebService {

	protected PApplet p;
	
	private String key;
	
	private String KULER_API_URL = "http://kuler-api.adobe.com/rss/";
	
	public Kuler( final PApplet parent, String _key )
	{
		p = parent;
		key = _key;
		
		p.println( "KEY: " + key );
		
	}

	public KulerPalette[] getHighestRated() // should return KulerPalette[]
	{
		return makeKulerPalettes( "&listtype=rating", "get", null );
	}
	
	private KulerPalette[] makeKulerPalettes( final String query, final String queryType, final String fileName ) // should return KulerPalette[]
	{
		
		String url = new StringBuffer( KULER_API_URL ).append( queryType ).append( ".cfm?" )
		                                              .append( query )
		                                              .append( "&key=" + key )
		                                              .toString();
		
		ArrayList<KulerPalette> palettes = new ArrayList<KulerPalette>();
		
		XML xml = p.loadXML( url );
		// p.println( xml );
		
		if ( xml.getChild( "success" ) != null && xml.getChild("success").getContent().equals("false") ) {
			
			if ( DEBUG == true ) {
				p.println( "The following error occurred while calling the Kuler API: " );
				p.println( xml.getChild("error/errorText").getContent() );
			}
			
		} else {
			
			XML[] themeItems = xml.getChildren( "channel/item/kuler:themeItem" );
			
			// p.println( themeItems );
			
			for ( int i = 0; i < themeItems.length; i++ ) {
				
				XML themeItem = themeItems[i];
				XML[] themeSwatches = themeItem.getChildren( "kuler:themeSwatches/kuler:swatch/kuler:swatchHexColor" );
				
				int[] colors = new int[ themeSwatches.length ];
				for ( int j = 0; j < themeSwatches.length; j++ ) {
					colors[j] = PApplet.unhex( "FF" + themeSwatches[j].getContent() );
				}
				
				KulerPalette kp = new KulerPalette( p, colors );
				
				// add author, id, tags, ... here ???
				
				palettes.add( kp );
				
			}
			
		}
		
		return (KulerPalette[]) palettes.toArray( new KulerPalette[ palettes.size() ] );
		
		//XML xml = getXML( url, fileName );
		
		
/*		if ( DEBUG == true ) {	
			p.println( "URL: " + url );
		} */
		
		// return (KulerPalette[]) palettes.toArray();
	}
}