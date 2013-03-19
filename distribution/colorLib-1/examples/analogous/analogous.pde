import colorlib.webservices.*;
import colorlib.tools.*;
import colorlib.*;

Analogous p;

void setup()
{
    size( 200, 200 );
    smooth();
    noStroke();
       
    color c = color( 255, 255, 0 );
    
    p = new Analogous( this, c );
}

void draw()
{
    background( 0 );
    translate( 10, 10 );
    p.drawSwatches();
    
    translate( 0, 50 );
    p.drawSwatches( 180, 60 );
}
