package colorlib;

import processing.core.*;
import colorlib.Palette;
import colorlib.Swatch;

public class SplitComplementary extends Palette
{

	public SplitComplementary( final PApplet parent)
	{
		super( parent );
	}

	public SplitComplementary( final PApplet parent, final int color )
	{
		super( parent );
		makeSplitComplementary( color );
	}
	
	// TODO: Make chainable
	public void setColor( final int color )
	{
		makeSplitComplementary( color );
		
	}
	
	// TODO: check if algorithm is ok
	// http://www.tigercolor.com/color-lab/color-theory/color-theory-intro.htm
	private void makeSplitComplementary( final int color )
	{
		// create a palette with three colors, close to each other in the color wheel
		
		swatches.add( new Swatch( p, color ) );
		
		Swatch secondSwatch = new Swatch( p, color );
		secondSwatch.rotateRYB( 30 );
		secondSwatch.lighten( 25.5f );
		swatches.add( secondSwatch );
		
		Swatch thirdSwatch = new Swatch( p, color );
		thirdSwatch.rotateRYB( -30 );
		thirdSwatch.lighten( 25.5f ); // TODO: check if ok, used this one from colorlib 1
		swatches.add( thirdSwatch );

	}
}
