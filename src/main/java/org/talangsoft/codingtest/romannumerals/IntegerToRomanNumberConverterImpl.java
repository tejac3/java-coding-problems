package org.talangsoft.codingtest.romannumerals;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.Map;
import java.util.TreeMap;

public class IntegerToRomanNumberConverterImpl implements IntegerToRomanNumberConverter {

    private static IntegerToRomanNumberConverter romanNumbersConverter = new IntegerToRomanNumberConverterImpl();

    public static void main(String... arguments){
        System.out.println("Convert to Roman Number");
        System.out.println("Convert 3478 -> " + romanNumbersConverter.convertToRomanNumber(3478));
    }

    private static final TreeMap<Integer,String> ROMAN_NUMBERS = new TreeMap<Integer,String>(){{
        put(1,"I"); put(4,"IV"); put(5,"V"); put(9,"IX"); put(10,"X"); put(40,"XL"); put(50,"L");
        put(90,"XC"); put(100,"C"); put(400,"CD"); put(500,"D"); put(900,"CM"); put(1000,"M");
    }};

    @Override
    public String convertToRomanNumber(int nr){
        Preconditions.checkArgument(nr>0,"The number to convert should be greater than 0");
        Preconditions.checkArgument(nr<4000,"The number to convert should be smaller than 4000");
        StringBuilder convertedNr = new StringBuilder();
        while(nr > 0){
            Map.Entry<Integer,String> romanNumber = ROMAN_NUMBERS.floorEntry(nr);
            convertedNr.append(Strings.repeat(romanNumber.getValue(),nr / romanNumber.getKey()));
            nr = nr % romanNumber.getKey();
        }
        return convertedNr.toString();
    };

}
