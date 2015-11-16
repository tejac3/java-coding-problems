package org.talangsoft.codingtest.fizzbuzz;

import java.util.Arrays;
import java.util.List;

public class Streams {

    private Integer getSize(String item){
        return item.length();
    }


    public void streamTest(){
        List<String> stringList = Arrays.asList(new String[]{"a","b","c","d2","d3"});
        stringList.stream().filter(s->s.startsWith("d")).map(this::getSize).forEach(System.out::println);
    }

    public static void main(String... args){
        new Streams().streamTest();
    }
}
