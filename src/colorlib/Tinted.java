package colorlib;

import processing.core.*;
import colorlib.Palette;
import colorlib.Swatch;

public class Tinted extends Palette
{

	public Tinted( final PApplet parent )
	{
		super( parent );
	}

	public Tinted( final PApplet parent, final int color )
	{
		super( parent );
	}
	
	public void setColor( final int color )
	{
		makeTinted( color );
	}
	
	private void makeTinted( final int color )
	{
		for ( int i = 0; i < 6; i++ ) {
			int c = p.lerpColor( color, p.color( 255 ), i * 0.2f );
			Swatch swatch = new Swatch( p, c );
		}
	}
}