package colorlib;

import processing.core.*;
import colorlib.Palette;
import colorlib.Swatch;

public class Tetrad extends Palette
{

	public Tetrad( final PApplet parent)
	{
		super( parent );
	}

	public Tetrad( final PApplet parent, final int color )
	{
		super( parent );
		makeTetrad( color );
	}
	
	// TODO: Make chainable
	public void setColor( final int color )
	{
		makeTetrad( color );
		
	}
	
	private void makeTetrad( final int color )
	{
		for ( int i = 0; i < 4; i++ ) {
			Swatch swatch = new Swatch( p, color );
			swatch.rotateRYB( i * 90 );
			swatches.add( swatch );
		}

	}
	
}
