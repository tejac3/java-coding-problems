package org.talangsoft.codingtest.problems;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.List;

/**
 * Function that returns the second shortest string in a list of strings -> single pass on the list only
 */
public class SecondShortestString {

    public static void main(String... arguments){
        System.out.println("Find second shortest string in a list");
        List<String> strings = Arrays.asList(new String[]{"a", "ab", "abc"});
        System.out.println("Input list: ");
        System.out.println(Joiner.on(",").join(strings).toString());
        String secondShortest = new SecondShortestString().findSecondShortest(strings);
        System.out.println("Second shortest string: '" + secondShortest+"'");
    }

    public String findSecondShortest(List<String> strings){
        Preconditions.checkArgument(strings != null, "The input string list can not be null");
        Preconditions.checkArgument(strings.size()>=2, "The input string list must have at least 2 elements");

        int shortestIndex = strings.get(1).length() >= strings.get(0).length()? 0:1;
        String secondShortest = strings.get(Math.abs(shortestIndex-1));
        int shortestLength = strings.get(shortestIndex).length();

        for(int i = 2; i<strings.size(); i++){
            String string = strings.get(i);
            if(string.length() < shortestLength){
                shortestLength = string.length();
            } else if(string.length()<=secondShortest.length()){
                secondShortest = string;
            }
        }
        return secondShortest;
    }
}
