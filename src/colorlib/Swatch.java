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

public class Swatch {

	protected PApplet p;
	private int c;
	
	/**
	 * Creates an empty Swatch object.
	 * @param parent reference to the main PApplet object.
	 */
	public Swatch( final PApplet parent )
	{
		p = parent;
		c = p.g.color( p.random( p.g.colorModeX ),
				       p.random( p.g.colorModeY ),
				       p.random( p.g.colorModeZ ) );
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
	 * Sets the color of the swatch. Be careful if your swatch already has a color. This will overwrite it.
	 * @param color
	 */
	public void setColor( final int color )
	{
		c = color;
	}
	
	public void rotateRGB( final float angle )
	{
		
		
	}
	
	public void rotateRYB( final float angle )
	{
		
		
	}
	
	
	public String getNearestHue()
	{
		
		return "Hue...";
	}
	

	public float brightnessDiff( final int color )
	{
		
		return 0.0f;
	}
	
	public float brightnessDiff( final Swatch swatch )
	{
		return brightnessDiff( swatch.getColor() );
		
	}

	public float colorDiff( final int color )
	{
		return 0.0f;
		
	}

	public float colorDiff( final Swatch swatch )
	{
		return colorDiff( swatch.getColor() );
		
	}

}