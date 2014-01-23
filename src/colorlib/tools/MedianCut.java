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

package colorlib.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;

import processing.core.*;

public class MedianCut
{

	private Hashtable histogram;
	
//	private Cube[] cubes;
	
	protected PApplet p;
	
	int cnt = 0;
	
	public MedianCut( PApplet parent )
	{
		p = parent;
	}
	
/*	
	public int[] calc( int[] colors, int cnt )
	{
		histogram = new Hashtable();
		
		for ( int i = 0; i < colors.length; i++ ) {
			
			Integer color = new Integer( colors[ i ] );
			if ( histogram.containsKey( color ) ) {		
				histogram.put( color, new Integer( ( (Integer) histogram.get( color ) ).intValue() + 1 ) );
			} else {
				histogram.put( color, new Integer( 1 ) );
			}
			
		}
		
		// dummy values...
		int[] x = new int[1];
		
		return x;
		
	}
*/	
	
	/**
	 * Cube Class
	 * @author janvantomme
	 *
	 */
/*	
	private class Cube
	{
		int level;
		int count;
		int rmin;
		int rmax;
		int gmin;
		int gmax;
		int bmin;
		int bmax;
		
		int[] colors;
		
		Cube( int[] colors, int level )
		{
			this.colors = colors;
			this.level  = level;
			
			count = colors.length;
		}
		
		public void sort( int shiftingStep )
		{
			ArrayList sort = new ArrayList();
			Hashtable sortTable = new Hashtable();
			
			for ( int i = 0; i < count; i++ ) {
				
				Integer sortKey = new Integer( colors[i] >> shiftingStep );
				
				if ( sortTable.contains( sortKey ) ) {
					
					ArrayList l = (ArrayList) sortTable.get( sortKey );
					l.add( new Integer( colors[ i ] ) );
					sortTable.put( sortKey, l );
					
				} else {
					
					ArrayList l = new ArrayList();
					l.add(new Integer(colors[i]));
					sortTable.put(sortKey, l);
					sort.add(sortKey);
				}
				
				ArrayList a = new ArrayList( sortTable.keySet() );
				Collections.sort( a );
				
				Iterator itr = a.iterator();
				cnt = 0;
				
				while ( itr.hasNext() ) {
					
					Integer key = (Integer) itr.next();
					ArrayList l = (ArrayList) sortTable.get( key );
					Iterator itrL = l.iterator();
					
					while ( itrL.hasNext() ) {
						
						colors[ cnt ] = ( (Integer) itrL.next()).intValue();
						cnt++;
					}
					
				}
			}
			
		}
		
		Cube split()
		{
			int cnt = 0;
			int i   = 0;
			
			for (; i < count; i++ ) {
				
				if ( cnt >= count / 2 ) {
					break;					
				}
				
				cnt += ((Integer) histogram.get( new Integer( colors[ i ] ) ) ).intValue();
				
			}
			
			int median = i;
			
			Cube cube = new Cube( PApplet.subset( colors, 0, median ), level + 1 );
			
			colors = PApplet.subset( colors, median );		
			count = colors.length;
			
			return cube;
			
		}
		
		int getAverage()
		{
			int a = 0;
			int r = 0;
			int g = 0;
			int b = 0;
			
			int l = colors.length;
			
			for ( int i = 0; i < l; i++ ) {
				
				int c = colors[ i ];
				
				a += c >> 24 & 0xff;
				r += c >> 16 & 0xff;
				g += c >> 8 & 0xff;
				b += c & 0xff;
			}
			
			return ( (int) ( a / l ) << 24) |
			       ( (int) ( r / l ) << 16) |
			       ( (int) ( g / l ) << 8) |
			       (int) ( b / l ); 
			
		}
		
	} */
	
}