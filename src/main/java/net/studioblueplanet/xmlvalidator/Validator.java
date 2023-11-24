/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.studioblueplanet.xmlvalidator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 *
 * @author jorgen
 */
public class Validator
{
    private List<String> xsdLocations;
    
    public Validator()
    {
    }
    
    /**
     * Read the XSD file URLs
     * @param fileName XML file to extract from
     */
    private boolean extractXsds(String fileName)
    {
        boolean ok;
        ok=true;
        // parse XML file
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(fileName));   
            // optional, but recommended
            // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();   
            Element root=doc.getDocumentElement();
            System.out.println("Root Element in XML  : " + root.getNodeName());
            String schemaLocationLine=root.getAttribute("xsi:schemaLocation");
            String[] items=schemaLocationLine.split(" ");
            if (items.length%1==0)
            {
                xsdLocations=new ArrayList<>();
                for (int i=1;i<items.length;i+=2)
                {
                    xsdLocations.add(items[i]);
                }
            }
            else
            {
                System.err.println("Invalid XSD definition");
            }
        }
        catch (ParserConfigurationException e)
        {
            System.err.println("Error configurating parser: "+e.getMessage());
            ok=false;
        }
        catch (SAXException e)
        {
            System.err.println("Error parsing XML: "+e.getMessage());
            ok=false;
        }
        catch (IOException e)
        {
            System.err.println("Error reading XML file: "+e.getMessage());
            ok=false;
        }
        return ok;
    }
    
    /**
     * Validate the XML against the XSDs
     * @param fileName File name to process
     * @return True if file is OK, false if not.
     */
    public boolean validateXMLSchema(String fileName)
    {
        System.out.println("Validing "+fileName);
        boolean ok=extractXsds(fileName);
        if (ok)
        {
            try
            {
                SchemaFactory factory= SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

                // Add the XSD schema locations to the Schema sources
                Source[] xsds=new Source[xsdLocations.size()];
                for (int i=0; i<xsdLocations.size(); i++)
                {
                    String source=xsdLocations.get(i);
                    if (source.startsWith("http"))
                    {
                        // Stream it from internet
                        System.out.println("Reading XSD from URL : "+source);
                        xsds[i]=new StreamSource(new URL(xsdLocations.get(i)).openStream()); 
                    }
                    else
                    {
                        // From file
                        System.out.println("Reading XSD from File: "+source);
                        xsds[i]=new StreamSource(new FileInputStream(xsdLocations.get(i))); 
                    }
                }

                Schema schema = factory.newSchema(xsds);
                javax.xml.validation.Validator validator = schema.newValidator();
                validator.validate(new StreamSource(new File(fileName)));
                System.out.println("VALIDATION PASSED!");

            } 
            catch (IOException e)
            {
                System.out.println("I/O Exception: " + e.getMessage());
                ok=false;
            }
            catch (SAXException e)
            {
                System.out.println("Parsing Exception: " + e.getMessage());
                ok=false;            
            }
        }
        return ok;
    }    
}
