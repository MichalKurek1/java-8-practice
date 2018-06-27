package pl.vrum.java8.Streams;

import pl.vrum.java8.Model.Person;

import java.util.List;
import java.util.stream.Collectors;

public class NamesMerging {

    //Marging first names of people from list

    public static String margingNamesStream(List<Person> people) {
        return people.stream().map(Person::getFistName)
                .collect(Collectors.joining (", ", "Names: ", "."));
    }
}
