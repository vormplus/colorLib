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

/**
 * Class to create a single Swatch.
 * 
 * @author ##author##
 */

public class Swatch
{
	/** Reference to PApplet */
	protected PApplet 	p;
	
	/** Color */
	private int 		c;
	
	/**
	 * Creates a Swatch object with the default color (Red)
	 * @param parent reference to the main PApplet object.
	 */
	
	public Swatch( final PApplet parent )
	{
		p = parent;
		c = p.g.color( p.color( 255, 0, 0 ) );
	}
	
	/**
	 * Creates a Swatch object with a specified color.
	 * @param parent reference to the main PApplet object.
	 * @param color	specified color.
	 */
	
	public Swatch( final PApplet parent, final int color )
	{
		p = parent;
		c = color;	
	}
	
	/**
	 * Sets the color of the Swatch. Be careful if your Swatch already has a color, this will overwrite it.
	 * @param color
	 */
	
	public void setColor( final int color )
	{
		c = color;
	}

	
	/**
	 * Returns the CMYK black value based on the formula ...
	 * @return
	 */
	public float black()
	{
		return PApplet.min( 1 - ((c >> 16) & 0xFF) / 255.0f,
				            1 - ((c >> 8) & 0xFF) / 255.0f,
				            1 - ((c) & 0xFF) / 255.0f );
	}
	
	/**
	 * Returns the CMYK cyan value based on the formula ...
	 * @return
	 */
	public float cyan()
	{
		return ( 1 - ((c >> 16) & 0xFF) / 255.0f - black()) / (1 - black() );	
	}
	
	/**
	 * Returns the CMYK magenta value based on the formula ...
	 * @return
	 */
	public float magenta()
	{
		return ( 1 - ((c >> 8) & 0xFF) / 255.0f - black()) / (1 - black() );
	}
	
	/**
	 * Returns the CMYK yellow value based on the formula ...
	 * @return
	 */
	public float yellow()
	{
		return ( 1 - ((c) & 0xFF) / 255.0f - black()) / (1 - black() );
	}
	
	
	/**
	 * Darkens the color
	 */
	public void darken()
	{
		lighten( -10.0f );
	}
	
	/**
	 * Darkens the color based on a specific amount
	 */
	public void darken( float amount )
	{
		lighten( -amount );
	}
	
	/**
	 * Lightens the color
	 */
	public void lighten()
	{
		lighten( 10.0f );
	}
	
	/**
	 * Lightens the color by a specific amount
	 * @param amount
	 */
	public void lighten( final float amount )
	{
		c = setHSBColor( p.hue( c ),
				         p.saturation( c ),
				         p.brightness( c ) + amount,
				         p.alpha( c ) );
	}
	
	/**
	 * Desaturates the color
	 */
	public void desaturate()
	{
		saturate( -10.0f );
		
	}
	
	/**
	 * Desaturates the color by a specified amount
	 * @param amount
	 */
	public void desaturate( final float amount )
	{
		saturate( -amount );	
	}
	
	/**
	 * Saturates the color
	 */
	public void saturate()
	{
		saturate( 10.0f );
	}
	
	/**
	 * Saturates the color by a specified amount
	 * @param amount
	 */
	public void saturate( final float amount )
	{
		c = setHSBColor( p.hue( c ),
		         p.saturation( c ) + amount,
		         p.brightness( c ),
		         p.alpha( c ) );
	}
	
	private int setHSBColor( final float h, final float s, final float b, final float a )
	{
		int color;
		int colorMode = p.g.colorMode;
		
		p.colorMode( PApplet.HSB );
		color = p.color( h, s, b, a );
		
		p.colorMode( colorMode );
		return color;
		
	}
	
	private int setHSBColor( final float h, final float s, final float b )
	{
		return setHSBColor( h, s, b, 255 );
	}
	
	/**
	 * Returns the color of the Swatch
	 * @return
	 */
	
	public int getColor()
	{
		return c;
	}
	
	/**
	 * Returns the transparent color of the Swatch
	 * @param alpha Alpha value of the color. This should be a number between 0 and 100
	 * @return
	 */
	public int getTransparentColor( int alpha )
	{
		int r = ( c >> 16 ) & 0xff;
		int g = ( c >> 8 ) & 0xff;
		int b = c & 0xff;
		int a = alpha;
		
		int colorMode = p.g.colorMode;
		
		p.colorMode( PApplet.RGB, 255, 255, 255, 100 );
		int transparentColor = p.color( r, g, b, a );
		
		// restore original colorMode
		p.colorMode( colorMode );
		
		return transparentColor;
	}
	
	/**
	 * 
	 * @param i_angle
	 */
	
	public void rotateRGB( final float i_angle )
	{
		c = setHSBColor( ( p.hue( c ) + i_angle ) % 256, p.saturation( c ), p.brightness( c ) );
	}
	
	/**
	 * 
	 * @param i_angle
	 */
	
	public void rotateRYB( float i_angle )
	{
		float hue = ((p.hue(c)) / 256f) * 360;
		
		i_angle %= 360;
		float angle = 0;
		
		int[][] wheel = { { 0, 0 }, { 15, 8 }, { 30, 17 }, { 45, 26 },
				{ 60, 34 }, { 75, 41 }, { 90, 48 }, { 105, 54 }, { 120, 60 },
				{ 135, 81 }, { 150, 103 }, { 165, 123 }, { 180, 138 },
				{ 195, 155 }, { 210, 171 }, { 225, 187 }, { 240, 204 },
				{ 255, 219 }, { 270, 234 }, { 285, 251 }, { 300, 267 },
				{ 315, 282 }, { 330, 298 }, { 345, 329 }, { 360, 0 } };

		for ( int i = 0; i < wheel.length - 1; i++ ) {
			int x0 = wheel[ i ][ 0 ];
			int y0 = wheel[ i ][ 1 ];
			int x1 = wheel[ i + 1 ][ 0 ];
			int y1 = wheel[ i + 1 ][ 1 ];
			
			if ( y1 < y0 ) {
				y1 += 360;
			}
			
			if ( y0 <= hue && hue <= y1 ) {
				angle = 1.0f * x0 + ( x1 - x0 ) * ( hue - y0 ) / ( y1 - y0 );
				break;
			}
		}
		
		// System.out.println("hue: " + hue + "angle: " + angle);
		angle = (angle + i_angle) % 360;

		for ( int i = 0; i < wheel.length - 1; i++ ) {
			int x0 = wheel[ i ][ 0 ];
			int y0 = wheel[ i ][ 1 ];
			int x1 = wheel[ i + 1 ][ 0 ];
			int y1 = wheel[ i + 1 ][ 1 ];
			
			if ( y1 < y0 ) {
				y1 += 360;
			}
			
			if ( x0 <= angle && angle <= x1 ) {
				hue = 1.0f * y0 + ( y1 - y0 ) * ( angle - x0 ) / ( x1 - x0 );
				break;
			}
		}

		hue %= 360;
		
		c = setHSBColor( hue * 256 / 360, p.saturation( c ), p.brightness( c ), p.alpha( c ) );
		
	}
	
	// TODO: implement
	public float brightnessDiff( final int color )
	{
		return 0.0f;
	}
	
	public float brightnessDiff( final Swatch swatch )
	{
		return brightnessDiff( swatch.getColor() );
	}

	// TODO: implement
	public float colorDiff( final int color )
	{
		return 0.0f;	
	}

	public float colorDiff( final Swatch swatch )
	{
		return colorDiff( swatch.getColor() );
	}

}