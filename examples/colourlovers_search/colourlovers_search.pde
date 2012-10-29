import colorlib.webservices.*;
import colorlib.*;

ColourLovers cl;

ArrayList<Palette> palettes;

void setup()
{
    size( 200, 800 );
    
    cl = new ColourLovers( this );
    palettes = cl.search( "strawberry" );
}

void draw()
{
    background( 0 );
    
    for ( int i = 0; i < palettes.size(); i++ ) {
        Palette p = palettes.get( i );
        pushMatrix();
        translate( 20, i * 40 );
        p.drawSwatches();
        popMatrix();
    }
}
