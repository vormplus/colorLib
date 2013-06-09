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

import processing.core.PApplet;
import colorlib.Palette;
import colorlib.Swatch;

public class Shaded extends Palette
{
	/**
	 * Creates a Shaded color palette with 6 colors, based on a given color. Mixes the original color with Black.
	 * @param parent
	 */
	
	public Shaded( final PApplet parent )
	{
		super( parent );
	}

	public Shaded( final PApplet parent, final int color )
	{
		super( parent );
		createPalette( color );
	}
	
	public Shaded setColor( final int color )
	{
		createPalette( color );
		return this;
	}
	
	@Override
	public void createPalette( final int color )
	{
		for ( int i = 0; i < 6; i++ ) {
			int c = p.lerpColor( color, p.color( 0 ), i * 0.2f );
			Swatch swatch = new Swatch( p, c );
			swatches.add( swatch );
		}
	}
}
