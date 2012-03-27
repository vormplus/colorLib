package colorlib;

import processing.core.*;

public class Swatch {

	protected PApplet p;
	private int c;
	
	public Swatch( final PApplet parent )
	{
		p = parent;
		c = p.g.color( p.random( p.g.colorModeX ),
				       p.random( p.g.colorModeY ),
				       p.random( p.g.colorModeZ ) );
	}
	
	public Swatch( final PApplet parent, final int color )
	{
		p = parent;
		c = color;	
	}
	
	public float black()
	{
		return PApplet.min( 1 - ((c >> 16) & 0xFF) / 255.0f,
				            1 - ((c >> 8) & 0xFF) / 255.0f,
				            1 - ((c) & 0xFF) / 255.0f );
	}
	
	public float cyan()
	{
		return ( 1 - ((c >> 16) & 0xFF) / 255.0f - black()) / (1 - black() );	
	}
	
	public float magenta()
	{
		return ( 1 - ((c >> 8) & 0xFF) / 255.0f - black()) / (1 - black() );
	}
	
	public float yellow()
	{
		return ( 1 - ((c) & 0xFF) / 255.0f - black()) / (1 - black() );
	}
	
	public void darken()
	{
		lighten( -10.0f );
	}
	
	public void darken( float amount )
	{
		lighten( -amount );
	}
	
	public void lighten()
	{
		
		lighten( 10.0f );
	}
	
	public void lighten( final float amount )
	{
		c = setHSBColor( p.hue( c ),
				         p.saturation( c ),
				         p.brightness( c ) + amount,
				         p.alpha( c ) );
	}
	
	public void desaturate()
	{
		saturate( -10.0f );
		
	}
	
	public void desaturate( final float amount )
	{
		saturate( -amount );
		
	}
	
	public void saturate()
	{
		saturate( 10.0f );
		
	}
	
	public void saturate( final float amount )
	{
		c = setHSBColor( p.hue( c ),
		         p.saturation( c ) + amount,
		         p.brightness( c ),
		         p.alpha( c ) );
	}
	
	private int setHSBColor( final float h, final float s, final float b, final float a )
	{
		int color;
		int colorMode = p.g.colorMode;
		
		p.colorMode( PApplet.HSB );
		color = p.color( h, s, b, a );
		
		p.colorMode( colorMode );
		return color;
		
	}
	
	private int setHSBColor( final float h, final float s, final float b )
	{
		return setHSBColor( h, s, b, 255 );
		
	}
	
	public int getColor()
	{
		return c;
		
	}
	
	public int getTransparentColor( int alpha )
	{
		int r = ( c >> 16 ) & 0xff;
		int g = ( c >> 8 ) & 0xff;
		int b = c & 0xff;
		int a = alpha;
		
		int colorMode = p.g.colorMode;
		
		p.colorMode( PApplet.RGB, 255, 255, 255, 100 );
		int transparentColor = p.color( r, g, b, a );
		
		// restore original colorMode
		p.colorMode( colorMode );
		
		return transparentColor;
	}
	
	public void setColor( final int color )
	{
		c = color;
	}
	
	public void rotateRGB( final float angle )
	{
		
		
	}
	
	public void rotateRYB( final float angle )
	{
		
		
	}
	
	
	public String getNearestHue()
	{
		
		return "Hue...";
	}
	

	public float brightnessDiff( final int color )
	{
		
		return 0.0f;
	}
	
	public float brightnessDiff( final Swatch swatch )
	{
		return brightnessDiff( swatch.getColor() );
		
	}

	public float colorDiff( final int color )
	{
		return 0.0f;
		
	}

	public float colorDiff( final Swatch swatch )
	{
		return colorDiff( swatch.getColor() );
		
	}

}