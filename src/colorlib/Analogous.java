package colorlib;

import processing.core.*;
import colorlib.Palette;
import colorlib.Swatch;

public class Analogous extends Palette
{
	
	
	public Analogous( final PApplet parent)
	{
		super( parent );
	}

	public Analogous( final PApplet parent, final int color )
	{
		super( parent );
		makeAnalogous( color );
	}
	
	// TODO: Make chainable
	public void setColor( final int color )
	{
		makeAnalogous( color );
		
	}
	
	// TODO: check if algorithm is ok
	// http://www.tigercolor.com/color-lab/color-theory/color-theory-intro.htm
	private void makeAnalogous( final int color )
	{
		// create a palette with three colors, close to each other in the color wheel
		
		swatches.add( new Swatch( p, color ) );
		
		Swatch secondSwatch = new Swatch( p, color );
		secondSwatch.rotateRYB( 10 );
		swatches.add( secondSwatch );
		
		Swatch thirdSwatch = new Swatch( p, color );
		thirdSwatch.rotateRYB( -10 );
		swatches.add( thirdSwatch );

	}

}
