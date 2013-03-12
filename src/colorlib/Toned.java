package colorlib;

import processing.core.PApplet;
import colorlib.Palette;
import colorlib.Swatch;

public class Toned extends Palette
{
	public Toned( final PApplet parent )
	{
		super( parent );
	}

	public Toned( final PApplet parent, final int color )
	{
		super( parent );
	}
	
	public void setColor( final int color )
	{
		makeToned( color );
	}
	
	private void makeToned( final int color )
	{
		for ( int i = 0; i < 6; i++ ) {
			int c = p.lerpColor( color, p.color( 127 ), i * 0.2f );
			Swatch swatch = new Swatch( p, c );
		}
	}
}
