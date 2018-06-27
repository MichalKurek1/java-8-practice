package pl.vrum.java8.Streams;

import pl.vrum.java8.Model.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapWithList {

    //Creating map with "true" or "false" keys and result lists based on age condition

    public static Map<Boolean, List<Person>> mapWithListStream(List<Person> people) {
        return people.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge()>=18));
    }

}
