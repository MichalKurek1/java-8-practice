package pl.vrum.java8.Streams;

import pl.vrum.java8.Model.Person;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class GroupingByLastname {

    //Creating map with last name keys and result lists based on last names

    public static Map<String, List<Person>> groupByLastNameStream(List<Person> people) {
        return people.stream()
                .collect(groupingBy(Person::getLastName));
    }
}
