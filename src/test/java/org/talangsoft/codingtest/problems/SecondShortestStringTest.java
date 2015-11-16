package org.talangsoft.codingtest.problems;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SecondShortestStringTest {
    SecondShortestString secondShortestString;


    private void testFor2ndShortest(String expected, String[] inputStrings) {
        assertEquals(expected, secondShortestString.findSecondShortest(Arrays.asList(inputStrings)));
    }


    @Before
    public void setUp(){
        secondShortestString = new SecondShortestString();
    }

    @Test(expected = IllegalArgumentException.class)
    public void findSecondShortestEmptyList(){
        List<String> inputStrings = Arrays.asList(new String[]{});
        secondShortestString.findSecondShortest(inputStrings);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findSecondShortestInListWithOneElement(){
        List<String> inputStrings = Arrays.asList(new String[]{""});
        secondShortestString.findSecondShortest(inputStrings);
    }


    @Test
    public void findSecondShortestInListWithTwoEqualLengthElement(){
        testFor2ndShortest("b", new String[]{"a", "b"});
    }

    @Test
    public void findSecondShortestInListWithTwoUnequalLengthElement2ndIsShorter(){
        testFor2ndShortest("ab",new String[]{"ab","b"});
    }

    @Test
    public void findSecondShortestInListWithTwoUnequalLengthElement1stIsShorter(){
        testFor2ndShortest("ab",new String[]{"b","ab"});
    }

    @Test
    public void findSecondShortestTests(){
        //testFor2ndShortest("ab",new String[]{"a","ab","abc"});
        //testFor2ndShortest("ab",new String[]{"ab","a","abc"});
        testFor2ndShortest("ab",new String[]{"abc","a","ab"});
    }

}
