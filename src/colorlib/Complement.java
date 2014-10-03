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

public class Complement extends Palette
{

	/**
	 * Creates a 2 color Palette with the passed color and its complement on the RYB color wheel.
	 * @param color
	 */

	public Complement( final PApplet parent )
	{
		super( parent );
	}
	
	/**
	 * Creates a 2 color Palette with the passed color and its complement on the RYB color wheel.
	 * @param color
	 */

	public Complement( final PApplet parent, int color )
	{
		super( parent );
		createPalette( color );
	}
	
	/**
	 * Sets the color for the palette. This color will be used to generate the other.
	 * @param color
	 * @return
	 */
	
	public Complement setColor( final int color )
	{
		createPalette( color );
		return this;
	}
	
	@Override
	public void createPalette( final int color )
	{
		swatches.add( new Swatch( p, color ) );
		Swatch secondColor = new Swatch( p, color );
		secondColor.rotateRYB( 180 );
		swatches.add( secondColor );
	}
}
