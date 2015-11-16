package org.talangsoft.codingtest.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindSumTest {

    FindSum findSum;

    @Before
    public void setUp(){
        findSum = new FindSum();
    }

    @Test
    public void findSumWithNoResultTest(){
        assertEquals(FindSum.SumResult.EMPTY_RESULT,findSum.findSum(new int[]{1,2},4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findSumInEmptyArrTest(){
        findSum.findSum(new int[]{}, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findSumIn1elementArrTest(){
        findSum.findSum(new int[]{1}, 3);
    }

    @Test
    public void findSumInArrWith2WithResultTest(){
        assertEquals(new FindSum.SumResult(1, 2), findSum.findSum(new int[]{1, 2}, 3));
    }

    @Test
    public void findSumInArrWithSingleResultTest(){
        assertEquals(new FindSum.SumResult(14,100),findSum.findSum(new int[]{1,2,5,7,9,11,13,14,100},114));
    }

    @Test
    public void findSumInArrWithMultipleResultTest(){
        assertEquals(new FindSum.SumResult(7,13),findSum.findSum(new int[]{1,2,5,7,9,11,13},20));
    }
}
