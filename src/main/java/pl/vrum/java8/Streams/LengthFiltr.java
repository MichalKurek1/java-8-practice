package pl.vrum.java8.Streams;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class LengthFiltr {

    //Filtering String list by length and creating list with results

    public static List<String> filterByLengthStream(List<String> list) {
        return list.stream().filter(s -> s.length() < 6)
                .collect(toList());
    }

}
