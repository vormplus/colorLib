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
		
	}
	
	public Triad( final PApplet parent, final int color, final int angle )
	{	
		super( parent );
		
		this.color = color;
		this.angle = angle;
		
		makeTriad();
	}

	public void setColor( final int color )
	{
		
		this.color = color;
	}

	public void setAngle( final int angle )
	{
		
		
	}

	private void makeTriad()
	{
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
