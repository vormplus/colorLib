import colorlib.webservices.*;
import colorlib.tools.*;
import colorlib.*;

FromPImage p1;
PImage img;

void setup()
{
    size( 200, 200 );
    smooth();
    noStroke();
       
    img = loadImage("osaka-fluo.jpg");
    p1 = new FromPImage( this, img );
}

void draw()
{
    background( 0 );
    translate( 10, 10 );
    p1.drawSwatches();
}
