/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package net.studioblueplanet.xmlvalidator;

import java.io.File;

/**
 *
 * @author jorgen
 */
public class XmlValidator
{
    /**
     * The main function. Executes the validation.
     * @param args Commandline arguments passed
     */
    public static void main(String[] args)
    {
        String fileName;
        
        System.out.println("XML Validator");
        System.out.println("____________________________________________");
        Validator validator=new Validator();
        if (args.length==1)
        {
            fileName=args[0];
        }
        else
        {
            fileName="src/test/resources/testHr.gpx";
            File f = new File(fileName);
            if(!f.exists() || f.isDirectory())
            { 
                System.out.println("Usage: java -jar XmlValidator.jar [xmlFileName]");
                System.exit(0);
            }
            else
            {
                System.out.println("Using demo file: "+fileName);
            }
        }
        validator.validateXMLSchema(fileName);
    }
}
