package org.talangsoft.codingtest.problems;

import com.google.common.base.Preconditions;

/**
 * unsorted array of integers, find the first two numbers equal to a given sum
 */
public class FindSum {

    public static void main(String... arguments){
        System.out.println("Find the first two numbers equal to a given sum");
        int[] unsortedInts = {0,5,7,11,13};
        System.out.print("Input array: ");
        for(int i : unsortedInts){
            System.out.print(i+ " ");
        }
        System.out.println();
        SumResult result = new FindSum().findSum(unsortedInts,24);
        System.out.println(result);

    }

    public SumResult findSum(int[] unsortedInts, long sum){
        Preconditions.checkElementIndex(1,unsortedInts.length,"unsorted int array must have at least 2 elements");
        for(int i = 0; i<unsortedInts.length;i++){
            for(int j = i+1; j<unsortedInts.length;j++){
                if(unsortedInts[i] + unsortedInts[j] == sum){
                  return new SumResult(unsortedInts[i],unsortedInts[j]);
                }
            }
        }
        return SumResult.EMPTY_RESULT;
    }



    static class SumResult{
        private Integer a;
        private Integer b;

        static final SumResult EMPTY_RESULT = new SumResult(null,null);

        public SumResult(Integer a, Integer b) {
            this.a = a;
            this.b = b;
        }

        public Integer getA() {
            return a;
        }

        public Integer getB() {
            return b;
        }

        @Override
        public String toString() {
            if(a == null || b == null){
                return "NO RESULT";
            }
            return String.format("%d + %d = %d",a,b,a+b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SumResult sumResult = (SumResult) o;

            if (a != null ? !a.equals(sumResult.a) : sumResult.a != null) return false;
            return !(b != null ? !b.equals(sumResult.b) : sumResult.b != null);

        }

        @Override
        public int hashCode() {
            int result = a != null ? a.hashCode() : 0;
            result = 31 * result + (b != null ? b.hashCode() : 0);
            return result;
        }
    }

}
