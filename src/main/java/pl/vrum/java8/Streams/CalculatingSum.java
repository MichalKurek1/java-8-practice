package pl.vrum.java8.Streams;

import java.util.List;

public class CalculatingSum {

    //Calculating sum of integer list

    public static int calculateSumStream(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}
