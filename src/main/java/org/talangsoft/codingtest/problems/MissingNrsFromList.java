package org.talangsoft.codingtest.problems;

/**
 * You are given a sorted list of distinct integers from 0 to 99, for instance [0, 1, 2, 50, 52, 75].
 * Your task is to produce a string that describes numbers missing from the list; in this case "3-49,51,53-74,76-99".
 * The items should be sorted in ascending order and separated by commas.
 * When a gap spans only one number, the item is the number itself;
 * when a gap is longer, the item comprises the start and the end of the gap, joined with a minus sign.
 */
public class MissingNrsFromList {

    public static final String INTERVAL_SIGN = "-";
    public static final String DELIMITER = ",";
    public static final int INTERVAL_MAX = 100;
    public static final int INTERVAL_MIN = 0;

    public static void main(String... arguments){
        System.out.println("Sorted list of distinct integers from 0 to 99, for instance [0, 1, 2, 50, 52, 75]");
        System.out.println("Produce a string that describes numbers missing from the list; in this case \"3-49,51,53-74,76-99\"");
        System.out.println("---------------");

        int[] sortedInts = {0,5,7,11,13};
        System.out.print("Input array: ");
        for(int i : sortedInts){
            System.out.print(i+ " ");
        }
        System.out.println();
        System.out.println("Result: " + new MissingNrsFromList().findMissing(sortedInts));

    }

    public String findMissing(int[] sortedInts){
        String missingNrStr = "";

        for(int i = 0 ; i <= sortedInts.length; i++){
            int previousElement = INTERVAL_MIN;
            if(i != 0){ previousElement = sortedInts[i-1];}

            int currentElement = INTERVAL_MAX;
            if(i != sortedInts.length){ currentElement = sortedInts[i];}

            if(previousElement == currentElement-2){
                if(!missingNrStr.isEmpty()){missingNrStr += DELIMITER;}
                missingNrStr += currentElement-1;
            }
            else if(previousElement < currentElement-2){
                if(!missingNrStr.isEmpty()){missingNrStr += DELIMITER;}
                missingNrStr += (previousElement+1) + INTERVAL_SIGN + (currentElement-1);
            }
        }
        return missingNrStr;
    }



//    public String findMissing(int[] sortedInts){
//        String missingNrStr = "";
//
//        for(int i = 1 ; i<sortedInts.length; i++){
//            if(sortedInts[i-1] == sortedInts[i]-2){
//                if(!missingNrStr.isEmpty()){missingNrStr += DELIMITER;}
//                missingNrStr += sortedInts[i]-1;
//            }
//            else if(sortedInts[i-1] < sortedInts[i]-2){
//                if(!missingNrStr.isEmpty()){missingNrStr += DELIMITER;}
//                missingNrStr += (sortedInts[i-1]+1) + INTERVAL_SIGN + (sortedInts[i]-1);
//            }
//        }
//        return missingNrStr;
//    }

}
