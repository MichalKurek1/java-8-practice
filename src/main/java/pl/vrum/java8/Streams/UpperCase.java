package pl.vrum.java8.Streams;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class UpperCase {

    //String list to upper case

    public static List<String> upperCaseStream(List<String> collection) {
        return collection.stream().map(String::toUpperCase).collect(toList());
    }
}
