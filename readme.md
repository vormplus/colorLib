# colorLib 2.0, A color library for Processing.

colorLib is a library for Processing that allows you to work with colors.

Compiled and tested on Mac OS X 10.9.5 with Processing 2.2.1. The API of colorLib has changed a lot and is NOT compatible with colorLib 1.x.

Not everything is implemented yet. These are the things that have been tested and should work properly.

* Analogous
* Complement
* Gradient
* Tetrad
* Tinted
* Toned
* Triad

## Webservices

The ColourLovers class now uses the JSON API. These are the methods you can use.

* getNew
* getTop
* getRandom
* search

Kuler support has been removed in colorLib 2.0, since the current API is XML-based. Adobe is working on a new Kuler API, so if they have their data available as JSON, I'll add it back.