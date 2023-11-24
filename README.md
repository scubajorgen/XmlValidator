# XmlValidator

## Introduction
This is a small commandline tool that validates an XML file against the XSD files mentioned in the file itself, 
under the tag ```xsi:schemaLocation```. It downloads the xsd files from internet and validates the XML file against it.

## Usage
To run the application type:

```
java -jar XmlValidator [file to test]
```
where [file to test] is the XML formatted file.

If you run it from the project directory you run a demo by simply typing:

```
java -jar XmlValidator
```

## Result

```
XML Validator
____________________________________________
Validing src/test/resources/testHr.gpx
Root Element in XML  : gpx
Reading XSD from URL : https://www.topografix.com/GPX/1/1/gpx.xsd
Reading XSD from URL : https://tracklog.studioblueplanet.net/gpxextensions/v4/gpxextensions.xsd
VALIDATION PASSED!
```

# License
This software is published under the MIT license:

Copyright (c) 2023 Jörgen

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.