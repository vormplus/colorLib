import colorlib.webservices.*;
import colorlib.tools.*;
import colorlib.*;

Triad p;

void setup()
{
    size( 200, 200 );
    smooth();
    noStroke();
       
    color c = color( 255, 255, 0 );
    
    p = new Triad( this, c, 20 );
}

void draw()
{
    background( 0 );
    translate( 10, 10 );
    p.drawSwatches();
    
    translate( 0, 50 );
    p.drawSwatches( 180, 60 );
}
