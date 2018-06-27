package pl.vrum.java8.Streams;

import pl.vrum.java8.Model.Person;

import java.util.Comparator;
import java.util.List;


public class Oldest {

    //Getting oldest person form list or empty Person object

    public static Person getOldestStream(List<Person> people) {
        return people.stream()
                .max(Comparator.comparing(Person::getAge))
                .orElse(new Person("", 0));
    }

}
