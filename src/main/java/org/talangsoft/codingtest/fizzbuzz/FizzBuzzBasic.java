package org.talangsoft.codingtest.fizzbuzz;

import com.google.common.base.Preconditions;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Predicate;

import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzzBasic {

    public static void main(String... arguments) {
        new FizzBuzzBasic().fizzBuzz(1,100,System.out);
    }

    private static final Predicate<Integer> divBy3() { return arg -> (arg % 3) == 0;}
    private static final Predicate<Integer> divBy5() { return arg -> (arg % 5) == 0;}

    public void fizzBuzz(int rangeStart, int rangeEnd, PrintStream out) {
        Preconditions.checkArgument(rangeStart > 0, "Range start should be greater than 0");
        Preconditions.checkArgument(rangeEnd >= rangeStart, "Range end should be greater than range start");
        Preconditions.checkArgument(out != null, "input printstream can not be null");

        String[] transformedSequence = createTransformedSeq(rangeStart, rangeEnd);
        out.print(Arrays.toString(transformedSequence));
    }

    private String[] createTransformedSeq(int rangeStart, int rangeEnd) {
        return rangeClosed(rangeStart, rangeEnd).mapToObj(this::convertNumber).toArray(String[]::new);
    }

    public String convertNumber(int nr) {
        if (divBy3().and(divBy5()).test(nr)) return "fizzbuzz";
        if (divBy3().test(nr)) return "fizz";
        if (divBy5().test(nr)) return "buzz";
        return Integer.toString(nr);
    }
}
