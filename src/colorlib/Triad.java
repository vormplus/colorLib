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

public class Triad extends Palette
{

	private int angle;
	
	private int color;
	
	public Triad( final PApplet parent )
	{
		super( parent );
		
		this.angle = 80;
		this.color = p.color( 255, 0, 0 );
		
		createPalette();
	}
	
	public Triad( final PApplet parent, final int color, final int angle )
	{	
		super( parent );
		
		this.color = color;
		this.angle = angle;
		
		createPalette();
	}

	public Triad setColor( final int color )
	{		
		this.color = color;
		
		createPalette();
		
		return this;
	}

	public Triad setAngle( final int angle )
	{
		this.angle = angle;
		
		createPalette();
		
		return this;
	}

	@Override
	public void createPalette()
	{
		swatches.clear();
		
		angle = PApplet.constrain( angle, 0, 180 );
		
		swatches.add( new Swatch( p, color ) );
		
		Swatch secondSwatch = new Swatch( p, color );
		secondSwatch.rotateRYB( angle );
		swatches.add( secondSwatch );
		
		Swatch thirdSwatch = new Swatch( p, color );
		thirdSwatch.rotateRYB( -angle );
		swatches.add( thirdSwatch );
		
	}

}
