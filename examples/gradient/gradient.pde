import colorlib.webservices.*;
import colorlib.tools.*;
import colorlib.*;

Gradient p1;
Gradient p2;

void setup()
{
    size( 400, 400 );
    smooth();
    noStroke();
    
    color[] colors = new color[ 2 ];
    colors[0] = color( 255, 0, 255 );
    colors[1] = color( 255, 255, 0 );
    
    p1 = new Gradient( this ).addColors( colors ).setSteps( 16 );

    color[] colors2 = new color[ 3 ];
    colors2[0] = color( 0, 0, 255 );
    colors2[1] = color( 255, 255, 0 );
    colors2[2] = color( 255 );
    
    p2 = new Gradient( this ).addColors( colors2 ).setSteps( 128 );
}

void draw()
{
    background( 0 );
    
    translate( 10, 10 );
    p1.drawSwatches( 256, 60 );

    translate( 0, 70 );
    p2.drawSwatches( 256, 60 );
}
