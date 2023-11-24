/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.studioblueplanet.xmlvalidator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jorgen
 */
public class ValidatorTest
{
    
    public ValidatorTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of validateXMLSchema method, of class Validator.
     */
    @Test
    public void testValidateXMLSchema()
    {
        System.out.println("validateXMLSchema");
        Validator instance = new Validator();
        assertEquals(true , instance.validateXMLSchema("src/test/resources/testHr.gpx"));           // Okay
        assertEquals(false, instance.validateXMLSchema("src/test/resources/testHrError1.gpx"));     // Bad tag
        assertEquals(true, instance.validateXMLSchema("src/test/resources/testHrRandomOrder.gpx")); // Bad order
        assertEquals(false, instance.validateXMLSchema("src/test/resources/testHrError3.gpx"));     // Bad syntax
    }
    
}
