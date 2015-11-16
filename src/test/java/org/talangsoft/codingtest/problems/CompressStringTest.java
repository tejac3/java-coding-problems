package org.talangsoft.codingtest.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompressStringTest {

    CompressString compressString;

    @Before
    public void setUp(){
        compressString = new CompressString();
    }

    @Test
    public void compressStringPlainTest(){
        assertEquals("abcdef",compressString.compressString("abcdef"));
    }

    @Test
    public void compressStringSingleRepeatedChar(){
        assertEquals("4abcdef",compressString.compressString("aaaabcdef"));
    }

    @Test
    public void compressStringMultipleSingleRepeatedChar(){
        assertEquals("4a3b2c",compressString.compressString("aaaabbbcc"));
    }

    @Test
    public void compressEmptyString(){
        assertEquals("",compressString.compressString(""));
    }

    @Test(expected = NullPointerException.class)
    public void compressNullString(){
        compressString.compressString(null);
    }
}
