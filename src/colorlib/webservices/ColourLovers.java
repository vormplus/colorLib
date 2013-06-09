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
import processing.data.*;

import colorlib.Palette;
import colorlib.webservices.WebService;

public class ColourLovers extends WebService
{

	protected PApplet p;
	
	private String COLOURLOVERS_API_URL = "http://www.colourlovers.com/api/palettes";
	
	private JSONArray jsonFeed;
	
	/**
	 * Constructor, Main ColourLovers object. This one is needed to search ColourLovers for palettes.
	 * @param parent
	 */
	public ColourLovers( final PApplet parent )
	{
		p = parent;		
	}
	
	/**
	 * Returns an ArrayList of Palette objects with the newest color palettes from ColourLovers.
	 * @return
	 */
	
	public ArrayList<Palette> getNew()
	{
		return makePalettes( "/new?format=json" );
	}
	
	/**
	 * Returns an ArrayList of Palette objects with the most loved color palettes from ColourLovers.
	 * @return
	 */

	public ArrayList<Palette> getTop()
	{ 
		return makePalettes( "/top?format=json" );
	}

	/**
	 * Returns an ArrayList of Palette objects with a single random palette from ColourLovers.
	 * @return
	 */

	public ArrayList<Palette> getRandom()
	{ 
		return makePalettes( "/random?format=json" );
	}

	/**
	 * Returns an ArrayList of Palette objects with based on a keyword search
	 * @param keyWord A String with the keyword you want to search for.
	 * @return
	 */
	
	public ArrayList<Palette> search( String keyWord )
	{
		return makePalettes( "?keywords=" + keyWord + "&format=json" );	
	}
	
	/**
	 * Method to do the API call to ColourLovers and create the Palette objects.
	 * @param query
	 * @return
	 */
	
	private ArrayList<Palette> makePalettes( String query )
	{
		String feedURL = new StringBuffer( COLOURLOVERS_API_URL ).append( query ).toString();
		
		if ( DEBUG ) {
			System.out.println( feedURL );
		}
		
		ArrayList<Palette> out = new ArrayList<Palette>();
		
		jsonFeed = new JSONArray( p.createReader( feedURL ) );
	
		for ( int i = 0; i < jsonFeed.size(); i++ ) {
			
			JSONObject paletteObject = jsonFeed.getJSONObject( i );
			JSONArray colorsArray = paletteObject.getJSONArray( "colors" );
			
			Palette palette = new Palette( p );
			
			for ( int j = 0; j < colorsArray.size(); j++ ) {
				int c = PApplet.unhex( "FF" + colorsArray.getString( j ) );
				palette.setColor( c );
			}
			
			out.add( palette );
			
		}
		
		return out;
	}
	
}