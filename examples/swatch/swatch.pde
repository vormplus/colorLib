import colorlib.webservices.*;
import colorlib.tools.*;
import colorlib.*;

Swatch s1;
Swatch s2;

void setup()
{
    size( 200, 200 );
    smooth();
    noStroke();
    
    s1 = new Swatch( this );
    s2 = new Swatch( this, color( 255, 125, 0 ) );
}

void draw()
{
    background( 255 );
    
    fill( s1.getColor() );
    rect( 10, 10, 85, 180 );
    
    fill( s2.getColor() );
    rect( 105, 10, 85, 180 );
}
