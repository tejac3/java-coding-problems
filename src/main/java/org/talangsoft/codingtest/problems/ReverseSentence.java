package org.talangsoft.codingtest.problems;

import com.google.common.base.Splitter;

import java.util.List;

/**
 * Reverse a sentence by reversing all the words in it
 * function that does: 'I work at Google' -> 'Google at work I'
 * reverse the words only
 */
public class ReverseSentence {

    public static final String WORD_SEPARATOR = " ";

    public static void main(String... arguments){
        System.out.println("Reverse a sentence by reversing all the words in it:");
        System.out.println("'I work at Google' -> 'Google at work I'");
        String sentence = "I work at Google";
        System.out.println(String.format("Original '%s'",sentence));
        System.out.println(String.format("Reversed '%s'",new ReverseSentence().reverseSentence(sentence)));
    }

    public String reverseSentence(String sentence){
        List<String> words = Splitter.on(WORD_SEPARATOR).splitToList(sentence);
        String reversed = "";
        for(int i = words.size()-1; i>=0; i--){
            reversed += words.get(i);
            if(i>0){ reversed += WORD_SEPARATOR;}
        }
        return reversed;
    }
}
