package colorlib;

import processing.core.*;
import colorlib.Palette;
import colorlib.Swatch;

public class Complement extends Palette
{

	public Complement( final PApplet parent )
	{
		super( parent );
	}
	
	public Complement( final PApplet parent, int color )
	{
		super( parent );
		makeComplement( color );
	}
	
	// TODO: make chainable...
	public void setColor( final int color )
	{
		makeComplement( color );
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
