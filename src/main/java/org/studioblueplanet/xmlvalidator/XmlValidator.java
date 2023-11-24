/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.studioblueplanet.xmlvalidator;

/**
 *
 * @author jorgen
 */
public class XmlValidator
{

    public static void main(String[] args)
    {
        Validator validator=new Validator();
        System.out.println("Validate " + validator.validateXMLSchema("testHr.gpx"));
    }


}
