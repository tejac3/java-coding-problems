package org.talangsoft.codingtest.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseSentenceTest {
    ReverseSentence reverser;

    @Before
    public void setUp(){
        reverser = new ReverseSentence();
    }

    @Test
    public void reverseOneWordSentence(){
        assertEquals("sentence",reverser.reverseSentence("sentence"));
    }

    @Test
    public void reverseTwoWordSentence(){
        assertEquals("two one",reverser.reverseSentence("one two"));
    }

    @Test
    public void reverseLongWordSentence(){
        assertEquals("Google at work I",reverser.reverseSentence("I work at Google"));
    }
}
