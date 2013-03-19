import colorlib.webservices.*;
import colorlib.tools.*;
import colorlib.*;

Palette p;

void setup()
{
    size( 200, 200 );
    smooth();
    noStroke();
    
    color[] colors = new color[ 4 ];
    colors[0] = color( 255, 0, 0 );
    colors[1] = color( 0, 255, 0 );
    colors[2] = color( 0, 0, 255 );
    colors[3] = color( 255, 255, 0 );
    
    p = new Palette( this, colors );
}

void draw()
{
    background( 0 );
    translate( 10, 10 );
    p.drawSwatches();
    
    translate( 0, 50 );
    p.drawSwatches( 180, 60 );
}
