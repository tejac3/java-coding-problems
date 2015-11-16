package org.talangsoft.codingtest.romannumerals;

public class RomanNumberToIntegerConverterImpl implements RomanNumberToIntegerConverter {

    private static RomanNumberToIntegerConverter converter = new RomanNumberToIntegerConverterImpl();

    public static void main(String... arguments){
        System.out.println("Convert to Integer Number");
        System.out.println("Convert MMMCDXCVIII -> " + converter.convertToInteger("MMMCDXCVIII"));
    }


    enum RomanNumbers{
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
        RomanNumbers(int value) { this.value = value;}
        private int value;
    }

    public int convertToInteger(String romanNr) {
        int charValue = RomanNumbers.valueOf(romanNr.substring(0, 1)).value;
        return romanNr.length() == 1 ? charValue :
                (charValue < RomanNumbers.valueOf(romanNr.substring(1, 2)).value ? -1 : 1) * charValue
                        + convertToInteger(romanNr.substring(1));
    }



}
