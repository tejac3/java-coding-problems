package org.talangsoft.codingtest.problems;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MissingNrsFromListTest {

    MissingNrsFromList missingNrsFromList;

    @Before
    public void setUp(){
        missingNrsFromList = new MissingNrsFromList();
    }

    @Test
    public void findMissingNoMissingTest(){
        assertEquals("6-99",missingNrsFromList.findMissing(new int[]{0,1,2,3,4,5}));
    }

    @Test
    public void findMissingNrMissingTest(){
        assertEquals("3,6-99", missingNrsFromList.findMissing(new int[]{0,1,2,4,5}));
    }

    @Test
    public void findMissingIntervalMissingTest(){
        assertEquals("3-4,6-99", missingNrsFromList.findMissing(new int[]{0,1,2,5}));
    }

    @Test
    public void findMissingIntervalWithBordersTest(){
        assertEquals("1-99", missingNrsFromList.findMissing(new int[]{0,100}));
    }

    @Test
    public void findMissingIntervalEmptyArrTest(){
        assertEquals("1-99", missingNrsFromList.findMissing(new int[]{}));
    }

    @Test
    public void findMissingNrAndIntervalMissingTest(){
        assertEquals("3-49,51,53-74,76-99", missingNrsFromList.findMissing(new int[]{0, 1, 2, 50, 52, 75}));
    }

}
