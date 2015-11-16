package org.talangsoft.codingtest.romannumerals;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class integerToRomanNumberTest {


    IntegerToRomanNumberConverter romanNumbersConverter;

    @Before
    public void setUp(){
        romanNumbersConverter = new IntegerToRomanNumberConverterImpl();
    }
    @Test
    public void conversionFor1Test(){
      assertEquals("I", romanNumbersConverter.convertToRomanNumber(1));
    }

    @Test
    public void conversionFor2Test(){
        assertEquals("II", romanNumbersConverter.convertToRomanNumber(2));
    }


    @Test
    public void conversionFor4Test(){
        assertEquals("IV", romanNumbersConverter.convertToRomanNumber(4));
    }

    @Test
    public void conversionFor8Test(){
        assertEquals("VIII", romanNumbersConverter.convertToRomanNumber(8));
    }

    @Test
    public void conversionFor3498Test(){
        assertEquals("MMMCDXCVIII", romanNumbersConverter.convertToRomanNumber(3498));
    }


    @Test
    public void conversionForAnIntervalTest(){
        assertEquals("IX", romanNumbersConverter.convertToRomanNumber(9));
        assertEquals("X", romanNumbersConverter.convertToRomanNumber(10));
    }

    @Test(expected = IllegalArgumentException.class)
    public void conversionForMinBoundaryTest(){
        romanNumbersConverter.convertToRomanNumber(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void conversionForBelowMinBoundaryTest(){
        romanNumbersConverter.convertToRomanNumber(-1);
    }


    @Test(expected = IllegalArgumentException.class)
    public void conversionForMaxBoundaryTest(){
        romanNumbersConverter.convertToRomanNumber(4000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void conversionForAboveMaxBoundaryTest(){
        romanNumbersConverter.convertToRomanNumber(4001);
    }

}
