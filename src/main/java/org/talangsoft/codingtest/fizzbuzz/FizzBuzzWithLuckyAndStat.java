package org.talangsoft.codingtest.fizzbuzz;

import com.google.common.base.Preconditions;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.IntStream.rangeClosed;

public class FizzBuzzWithLuckyAndStat{

    public static void main(String... arguments) {
        new FizzBuzzWithLuckyAndStat().fizzBuzz(1,100,System.out);
    }

    private static final Predicate<Integer> divBy3() { return arg -> (arg % 3) == 0;}
    private static final Predicate<Integer> divBy5() { return arg -> (arg % 5) == 0;}
    private static final Predicate<Integer> contains3() { return arg -> (String.valueOf(arg).contains("3"));}

    /* Function which translates nr to "integer". If input is already a group name (not a number then no translation happens) */
    private static final Function<String,String> getGroupName() { return arg -> arg.matches("\\d+")? "integer":arg; }

    public void fizzBuzz(int rangeStart, int rangeEnd,PrintStream out) {
        Preconditions.checkArgument(rangeStart > 0, "Range start should be greater than 0");
        Preconditions.checkArgument(rangeEnd >= rangeStart, "Range end should be greater than range start");
        Preconditions.checkArgument(out != null, "input printstream can not be null");

        String[] transformedSeq = createTransformedSeq(rangeStart, rangeEnd);
        out.println(Arrays.toString(transformedSeq));

        Map<String,Long> stat = createStat(transformedSeq);
        stat.forEach((k, v) -> out.println(k + ": " + v));

    }

    private Map<String, Long> createStat(String[] transformedSeq) {
        return Arrays.stream(transformedSeq).map(getGroupName())
                .collect(groupingBy(g->g, counting()));
    }

    private String[] createTransformedSeq(int rangeStart, int rangeEnd) {
        return rangeClosed(rangeStart, rangeEnd).mapToObj(this::convertNumber).toArray(String[]::new);
    }

    public String convertNumber(int nr) {
        if(contains3().test(nr)) return "lucky";
        if (divBy3().and(divBy5()).test(nr)) return "fizzbuzz";
        if (divBy3().test(nr)) return "fizz";
        if (divBy5().test(nr)) return "buzz";
        return Integer.toString(nr);
    }

}