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
import java.util.HashSet;
import java.util.Iterator;

import processing.core.*;

public class MedianCut
{

	private Hashtable histogram;
	
	private Cube[] cubes;
	
	protected PApplet p;
	
	int cnt = 0;
	
	public MedianCut( PApplet parent )
	{
		p = parent;
	}
	
	
	public int[] calc( int[] colors, int cnt )
	{
			
		histogram = new Hashtable();
		
		for (int i = 0; i < colors.length; i++) {
			Integer color = new Integer(colors[i]);
			if (histogram.containsKey(color)) {
				histogram.put(color, new Integer(((Integer) histogram
						.get(color)).intValue() + 1));
			} else {
				histogram.put(color, new Integer(1));
			}
		}
		
		HashSet h = new HashSet();
		
		for (int i = 0; i < colors.length; i++) {
			h.add(new Integer(colors[i]));
		}
		
		colors = new int[h.size()];
		Iterator iter = h.iterator();	
		int cnter = 0;
		while (iter.hasNext()) {
			colors[cnter] = ((Integer) iter.next()).intValue();
			cnter++;
		}
		
		int ncubes = 0;
		Cube cube = new Cube(colors, 0);
		cube.level = 0;
		shrink(cube);
		cubes = new Cube[cnt];
		cubes[ncubes++] = cube;
		
		while (ncubes < cnt) {
			int nextCube = -1, colorCnt = 1;
			for (int i = 0; i < ncubes; i++) {
				int length = cubes[i].count;

				if (length > colorCnt) {
					colorCnt = length;
					nextCube = i;
				}
			}
			if (nextCube == -1) {
				break;
			}
			cube = cubes[nextCube];
			int lr = cube.rmax - cube.rmin;
			int lg = cube.gmax - cube.gmin;
			int lb = cube.bmax - cube.bmin;
			if (lr > lg && lr > lb) {
				cube.sort(0);
			} else if (lg > lb) {
				cube.sort(1);
			} else {
				cube.sort(2);
			}
			cubes[ncubes++] = cube.split();
		}
		
		int[] result = new int[ncubes];
		for (int i = 0; i < ncubes; i++) {
			result[i] = cubes[i].getAverage();
		}
		
		return result;
		
	}

	private void shrink(Cube cube)
	{
		int r, g, b;
		int color;
		int rmin, rmax, gmin, gmax, bmin, bmax;

		rmin = 255;
		rmax = 0;
		gmin = 255;
		gmax = 0;
		bmin = 255;
		bmax = 0;
		for (int i = 0; i < cube.colors.length; i++) {
			color = cube.colors[i];
			r = color >> 16 & 0xFF;
			g = color >> 8 & 0xFF;
			b = color & 0xFF;

			if (r > rmax)
				rmax = r;
			if (r < rmin)
				rmin = r;
			if (g > gmax)
				gmax = g;
			if (g < gmin)
				gmin = g;
			if (b > bmax)
				bmax = b;
			if (b < bmin)
				bmin = b;
		}
		cube.rmin = rmin;
		cube.rmax = rmax;
		cube.gmin = gmin;
		cube.gmax = gmax;
		cube.bmin = bmin;
		cube.bmax = bmax;
	}
	
	
	/**
	 * Cube Class
	 */
	
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
					
					ArrayList l = new ArrayList<Integer>();
					l.add( new Integer( colors[ i ] ) );
					sortTable.put( sortKey, l );
					sort.add( sortKey );
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
		
	}
	
}