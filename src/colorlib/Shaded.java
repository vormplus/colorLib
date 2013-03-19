package colorlib;

import processing.core.PApplet;
import colorlib.Palette;
import colorlib.Swatch;

public class Shaded extends Palette
{
	public Shaded( final PApplet parent )
	{
		super( parent );
	}

	public Shaded( final PApplet parent, final int color )
	{
		super( parent );
		makeShaded( color );
	}
	
	public void setColor( final int color )
	{
		makeShaded( color );
	}
	
	private void makeShaded( final int color )
	{
		for ( int i = 0; i < 6; i++ ) {
			int c = p.lerpColor( color, p.color( 0 ), i * 0.2f );
			Swatch swatch = new Swatch( p, c );
			swatches.add( swatch );
		}
	}
}
