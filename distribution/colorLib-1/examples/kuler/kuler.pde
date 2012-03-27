import colorlib.webservices.*;
import colorlib.*;

Kuler k;
KulerPalette[] kp;

void setup()
{
    size( 200, 610 );
    smooth();
    noStroke();
    
    k = new Kuler( this, "YOUR_KULER_API_KEY" );
    kp = k.getHighestRated();
}

void draw()
{
    background( 0 );
    for ( int i = 0; i < kp.length; i++ ) {
        pushMatrix();
        translate( 10, i * 30 + 10 );
        kp[i].drawSwatches( 180, 20 );
        popMatrix();
    }
}


