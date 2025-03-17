package Task_4_2;

import java.util.stream.IntStream;

public class ArithmeticProgressionSum {

    public static long getArithmeticProgressionSum(int a, int b) {
        return IntStream.range(a, b).asLongStream().sum();
    }

    public static void main(String[] args) {
        int a = 10_000_000;
        int b = 1_000_000_000;
        long sum = getArithmeticProgressionSum(a, b);
        System.out.println("Result: " + sum);
    }
}
