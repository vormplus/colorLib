package colorlib;

import processing.core.*;
import java.util.ArrayList;

public class Palette {

	protected PApplet p;
	protected ArrayList<Swatch> swatches;
	
	public Palette( final PApplet parent )
	{
		p = parent;
		swatches = new ArrayList<Swatch>();
	}
	
	public Palette( final PApplet parent, int[] colors )
	{
		p = parent;
		swatches = new ArrayList<Swatch>();
		
		for ( int i = 0; i < colors.length; i++ ) {
			swatches.add( new Swatch( p, colors[i] ) );
		}
	}
	
	public Palette( final PApplet parent, final PImage img )
	{
		p = parent;
		
		swatches = new ArrayList<Swatch>();
		
		for ( int i = 0; i < img.pixels.length; i++ ) {
			swatches.add( new Swatch( p, img.pixels[i] ) );
		}
		
		removeDuplicateSwatches();
	}
	
	
	public void addColor( final int color )
	{
		swatches.add( new Swatch( p, color ) );
	}
	
	public void addColors( final int[] colors )
	{
		for ( int i = 0; i < colors.length; i++ ) {
			swatches.add( new Swatch( p, colors[i] ) );
		}
	}
	
	public void removeDuplicateSwatches()
	{
		
	}
	
	
}