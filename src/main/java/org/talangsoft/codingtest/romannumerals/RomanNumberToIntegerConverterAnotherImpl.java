package org.talangsoft.codingtest.romannumerals;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RomanNumberToIntegerConverterAnotherImpl implements RomanNumberToIntegerConverter {

    private static RomanNumberToIntegerConverter converter = new RomanNumberToIntegerConverterAnotherImpl();

    public static void main(String... arguments){
        System.out.println("Convert to Integer Number");
        System.out.println("Convert MMMCDXCVIII -> " + converter.convertToInteger("MMMCDXCVIII"));
    }


    private static final TreeMap<Integer,String> ROMAN_NUMBERS = new TreeMap<Integer,String>(){{
        put(1,"I"); put(4,"IV"); put(5,"V"); put(9,"IX"); put(10,"X"); put(40,"XL"); put(50,"L");
        put(90,"XC"); put(100,"C"); put(400,"CD"); put(500,"D"); put(900,"CM"); put(1000,"M");
    }};
    private static final Map<String,Integer> ROMAN_NUMBER_VALUES = ROMAN_NUMBERS.entrySet().stream()
            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));


    public int convertToInteger(String romanNr){
        // get 2 digit, find value for them
        // no value -> get one digit, find value for them
        int index = 0;
        int convertedValue = 0;
        while(index < romanNr.length()){
            String nextOrdinal = "";

            // try 2 chars
            int endIndex = index + 2;
            if(romanNr.length() >= endIndex) {
                String next2Chars = romanNr.substring(index, endIndex);
                if(ROMAN_NUMBER_VALUES.containsKey(next2Chars)){
                    nextOrdinal = next2Chars;
                }
            }

            // try single char
            if(nextOrdinal.isEmpty()){
                nextOrdinal = romanNr.substring(index,index+1);
                if(!ROMAN_NUMBER_VALUES.containsKey(nextOrdinal)){
                    throw new IllegalArgumentException(String.format("The ordinal %s can not be converted",nextOrdinal));
                }
            }

            convertedValue += ROMAN_NUMBER_VALUES.get(nextOrdinal);
            index += nextOrdinal.length();
        }
        return convertedValue;
    };

}
