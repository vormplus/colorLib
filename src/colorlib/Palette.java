/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright (c) ##copyright## ##author##
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

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