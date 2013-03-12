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
import java.util.ArrayList;

import colorlib.Swatch;

public class Palette
{

	protected PApplet p;
	protected ArrayList<Swatch> swatches;
	
	/**
	 * Creates an empty Palette object.
	 * @param parent reference to the main PApplet object.
	 */
	
	public Palette( final PApplet parent )
	{
		p = parent;
		swatches = new ArrayList<Swatch>();
	}
	
	/**
	 * Creates a Palette object from an array of colors.
	 * @param parent reference to the main PApplet object.
	 * @param colors Array of Processing colors.
	 */

	public Palette( final PApplet parent, int[] colors )
	{
		p = parent;
		swatches = new ArrayList<Swatch>();
		
		addColors( colors );
	}
	
	/**
	 * Creates a Palette object based on an image. Duplicate colors are removed.
	 * @param parent reference to the main PApplet object.
	 * @param img a Processing image.
	 */
	
	public Palette( final PApplet parent, final PImage img )
	{
		p = parent;
		
		swatches = new ArrayList<Swatch>();
		
		for ( int i = 0; i < img.pixels.length; i++ ) {
			swatches.add( new Swatch( p, img.pixels[i] ) );
		}
		
		removeDuplicateSwatches();
	}
	
	/**
	 * Adds a color to the Palette.
	 * @param color a Processing color.
	 */
	
	public void addColor( final int color )
	{
		swatches.add( new Swatch( p, color ) );
	}

	/**
	 * Adds colors to the Palette.
	 * @param colors an array of Processing colors.
	 */
	
	public void addColors( final int[] colors )
	{
		for ( int i = 0; i < colors.length; i++ ) {
			swatches.add( new Swatch( p, colors[i] ) );
		}
	}
	
	/**
	 * Removes duplicate colors from the Palette
s	 */
	
	public void removeDuplicateSwatches()
	{
		
	}
	
	/**
	 * Draws all color swatches of the Palette to the screen.
	 */
	
	public void drawSwatches()
	{
		drawSwatches( 120, 40 );
	}
	
	/**
	 * Draws all color swatches of the Palette to the screen.
	 * @param w Width of the Palette
	 * @param h Height of the Palette
	 */

	public void drawSwatches( final float w, final float h )
	{
		float swatchWidth = w / (float)swatches.size();
		
		int counter = 0;
		
		for ( Swatch s : swatches ) {
			
			p.fill( s.getColor() );
			p.noStroke();
			p.rect( swatchWidth * counter, 0, swatchWidth, h );
			
			counter++;
		}
		
	}
	
	/**
	 * Returns the color for the index number
	 * @param colorNumber number of the color you want to get
	 * @return
	 */
	public int getColor( int colorNumber )
	{
		return swatches.get( colorNumber ).getColor();
	}
	
	/**
	 * Returns the number of swatches in the Palette
	 * @return
	 */
	public int numSwatches()
	{
		return swatches.size();
	}
	
	/**
	 * Creates a 2 color Palette with the passed color and its complement on the RYB color wheel.
	 * @param color
	 */
	public void makeComplement( final int color )
	{
		swatches.add( new Swatch( p, color ) );
		Swatch secondColor = new Swatch( p, color );
		secondColor.rotateRYB( 180 );
		swatches.add( secondColor );
	}
	
	
}