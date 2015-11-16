package org.talangsoft.codingtest.fizzbuzz;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FizzBuzzWithLuckyTest {

    private FizzBuzzWithLucky fizzBuzz = new FizzBuzzWithLucky();

    @Test
    public void testNumberIs3(){
        assertThat(fizzBuzz.convertNumber(3),is("lucky"));
    }

    @Test
    public void testNumberContains3(){
        assertThat(fizzBuzz.convertNumber(13),is("lucky"));
    }

    @Test
    public void testNumberContains3AndMultipleOf5(){
        assertThat(fizzBuzz.convertNumber(135),is("lucky"));
    }

    @Test
    public void testNumberMultipleOf3_6(){
        assertThat(fizzBuzz.convertNumber(6),is("fizz"));
    }

    @Test
    public void testNumberMultipleOf3_9(){
        assertThat(fizzBuzz.convertNumber(9),is("fizz"));
    }

    @Test
    public void testNumberMultipleOf5_5(){
        assertThat(fizzBuzz.convertNumber(5),is("buzz"));
    }

    @Test
    public void testNumberMultipleOf5_10(){
        assertThat(fizzBuzz.convertNumber(10),is("buzz"));
    }

    @Test
    public void testNumberMultipleOf3and5(){
        assertThat(fizzBuzz.convertNumber(15),is("fizzbuzz"));
    }

    @Test
    public void testNumberNotMultipleOf3or5(){
        assertThat(fizzBuzz.convertNumber(1),is("1"));
    }

    @Test
    public void testMinus(){
        assertThat(fizzBuzz.convertNumber(-1),is("-1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApiMinusNumberInput(){
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        fizzBuzz.fizzBuzz(-1,10,ps);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApiNullPrintStreamInput(){
        fizzBuzz.fizzBuzz(1,10,null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApiRangeEndSmallerThanStartInput(){
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        fizzBuzz.fizzBuzz(1,0,ps);
    }

    @Test
    public void testOutputWrite10to20Write(){
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        fizzBuzz.fizzBuzz(10,20, ps);
        assertThat(os.toString(),is("[buzz, 11, fizz, lucky, 14, fizzbuzz, 16, 17, fizz, 19, buzz]"));
    }

    @Test
    public void testOutputWrite1to20(){
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        fizzBuzz.fizzBuzz(1,20, ps);
        assertThat(os.toString(),is("[1, 2, lucky, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, lucky, 14, fizzbuzz, 16, 17, fizz, 19, buzz]"));
    }

}