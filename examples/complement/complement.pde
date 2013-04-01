import colorlib.webservices.*;
import colorlib.tools.*;
import colorlib.*;

Complement p1, p2;

void setup()
{
    size( 200, 200 );
    smooth();
    noStroke();
       
    color c = color( 255, 255, 0 );
    
    p1 = new Complement( this, c );
    p2 = new Complement( this ).setColor( color( 255, 0, 0 ) );
}

void draw()
{
    background( 0 );
    translate( 10, 10 );
    p1.drawSwatches();
    
    translate( 0, 50 );
    p2.drawSwatches( 180, 60 );
}
