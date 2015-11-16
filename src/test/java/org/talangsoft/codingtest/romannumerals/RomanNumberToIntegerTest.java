package org.talangsoft.codingtest.romannumerals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumberToIntegerTest {

    RomanNumberToIntegerConverter converter;

    @Before
    public void setUp(){
      converter = new RomanNumberToIntegerConverterImpl();
    }

    @Test
    public void conversionFor1Test(){
      assertEquals(1, converter.convertToInteger("I"));
    }

    @Test
    public void conversionFor2Test(){
        assertEquals(2, converter.convertToInteger("II"));
    }

    @Test
    public void conversionFor4Test(){
        assertEquals(4, converter.convertToInteger("IV"));
    }

    @Test
    public void conversionFor8Test(){
        assertEquals(8, converter.convertToInteger("VIII"));
    }

    @Test
    public void conversionFor3498Test(){
        assertEquals(3498, converter.convertToInteger("MMMCDXCVIII"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void conversionForInvalidTest(){
        converter.convertToInteger("MMMZIII");
    }

    @Test
    public void conversionFor3001Test(){
        assertEquals(3001, converter.convertToInteger("MMMI"));
    }
}
