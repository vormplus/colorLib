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

package colorlib;

import processing.core.*;
import colorlib.Palette;
import colorlib.Swatch;

public class Gradient extends Palette
{
	/**
	 * 
	 * @param parent
	 */
	public Gradient( final PApplet parent )
	{
		super( parent ); // call Palette()
	}

	/**
	 * 
	 * @param parent
	 * @param _p
	 * @param step
	 */
	public Gradient( final PApplet parent, Palette _p, int step )
	{
		super( parent );
		
	}
	
	/**
	 * 
	 * @param colors
	 * @param stepSize
	 * @param wrap
	 */
	private void createGradient( int[] colors, int stepSize, boolean wrap )
	{
		for ( int i = 0; i < stepSize; i++ ) {
			
			Swatch s = new Swatch( p, (int)colorsBetween( colors, (float) i / stepSize, wrap ) );		
			swatches.add( s );
		}
	}
	
	/**
	 * 
	 * @param startColor
	 * @param endColor
	 * @param step
	 * @return
	 */
	private int colorBetween( final int startColor, final int endColor, final float step )
	{
		int startAlpha = startColor >> 24 & 0xFF;
		int startRed   = startColor >> 16 & 0xFF;
		int startGreen = startColor >> 8 & 0xFF;
		int startBlue  = startColor & 0xFF;
		
		int endAlpha = endColor >> 24 & 0xFF;
		int endRed   = endColor >> 16 & 0xFF;
		int endGreen = endColor >> 8 & 0xFF;
		int endBlue  = endColor & 0xFF;
		
		int returnAlpha = (int) ( startAlpha + ( endAlpha - startAlpha ) * step );
		int returnRed   = (int) ( startRed + ( endRed - startRed ) * step );
		int returnGreen = (int) ( startGreen + ( endGreen - startGreen ) * step );
		int returnBlue  = (int) ( startBlue + ( endBlue - startBlue ) * step );
		
		int returnColor = ( returnAlpha << 24 ) + ( returnRed << 16 ) + ( returnGreen << 8 ) + returnBlue;
		
		return returnColor;
	}
	
	/**
	 * 
	 * @param colors
	 * @param step
	 * @param wrap
	 * @return
	 */
	private int colorsBetween( final int[] colors, final float step, boolean wrap )
	{
		int length = colors.length - 1;
		
		if ( wrap ) {
			length = colors.length;
		}
		
		if ( step <= 0 ) {
			return colors[0];
		}
		
		if ( step >= 1 ) {
			return colors[ colors.length - 1 ];
		}
		
		int a = (int) Math.floor( length * step );
		float f = 1.0f / length;
		float newStep = ( step - ( a * f ) ) / f;
		int nextA = Math.min( a + 1, length );
		
		if ( wrap ) {
			if ( nextA >= colors.length ) {
				nextA = 0;
			}
		}
		
		return colorBetween( colors[ a ], colors[ nextA ], newStep );
	}
}