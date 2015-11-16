package org.talangsoft.codingtest.problems;

import com.google.common.base.Preconditions;

/**
 * Compress a String aaaabbbcc -> 4a3b2c
 */
public class CompressString {

    public static void main(String... arguments){
        System.out.println("Compressing a string like  aaaabbbcc -> 4a3b2c ");
        String source = "aaaabbbcc";
        System.out.println("Source: "+source);
        System.out.println("Compressed: " + new CompressString().compressString(source));
    }

    public String compressString(String source){
        Preconditions.checkNotNull(source,"Source string to compress can not be null!");
        String compressed = "";
        char lastChar = '\0';
        int counter = 0;
        char[] sourceChars = source.toCharArray();
        for(char c : sourceChars){
            if(c == lastChar){ counter++;}
            else {
                compressed += getCompressedCharacterString(lastChar, counter);
                lastChar = c;
                counter = 0;
            }
        }
        compressed += getCompressedCharacterString(lastChar, counter);
        return compressed;
    }

    private String getCompressedCharacterString(char lastChar, int counter) {
        if(lastChar == '\0') { return ""; }
        String counterStr = "";
        if(counter > 0){ counterStr += (counter+1); }
        return counterStr + lastChar;
    }


}
