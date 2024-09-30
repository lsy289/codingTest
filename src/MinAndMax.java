import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class MinAndMax {

    public static void solution1() {
        int[] arr = {1, 2, 3, 4, 5};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        System.out.println(min);
        System.out.println(max);

        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        System.out.println("최소값: " + min);  // 1
        System.out.println("최대값: " + max);  // 5
    }


    public static void solution2() {
        int[] numbers = {1, 5, 3, 9, 2};
        IntSummaryStatistics stats = Arrays.stream(numbers)
                                            .summaryStatistics();

        System.out.println(stats);
        int max = stats.getMax();
        int min = stats.getMin();

        System.out.println("min :: " + min + " max :: " + max);
    }

    public static void solution3() {
        int[] numbers = {1, 5, 3, 9, 2};
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int number : numbers) {
            if (number < min) min = number;
            if (number > max) max = number;
        }

        System.out.println("min :: " + min + " max :: " + max);
    }

    public static void main(String[] args) {
        solution1();
        solution2();
        solution3();
    }
    
}
