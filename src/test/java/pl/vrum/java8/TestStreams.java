package pl.vrum.java8;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Before;
import org.junit.Test;
import pl.vrum.java8.Model.Person;
import pl.vrum.java8.Streams.*;

import java.util.List;
import java.util.Map;


import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class TestStreams {

    List<Person> collection;

    @Before
    public void prepare() {
        Person kowalski = new Person("Kowalski", 10);
        Person adams = new Person("Adams", 18);
        Person johns = new Person("Johns", 30);
        collection = asList(kowalski, adams, johns);
    }

    @org.junit.Test
    public void upperCaseTest() {
        List<String> collection = asList("gooD", "morning", "vIetnam");
        List<String> expected = asList("GOOD", "MORNING", "VIETNAM");
        assertThat(UpperCase.upperCaseStream(collection)).hasSameElementsAs(expected);
    }

    @org.junit.Test
    public void filteringTest() {
        List<String> collection = asList("bamboozled", "word", "typo", "Alladyn");
        List<String> expected = asList("word", "typo");
        assertThat(LengthFiltr.filterByLengthStream(collection)).hasSameElementsAs(expected);
    }
    
    @org.junit.Test
    public void groupingTest() {
        Person kowalski = new Person("Andrew","Kowalski", 10);
        Person adams = new Person("Sara","Adams", 18);
        Person johns = new Person("Anna","Adams", 30);
        List<Person> collection = asList(kowalski, adams, johns);
        Map<String, List<Person>> result = GroupingByLastname.groupByLastNameStream(collection);
        assertThat(result.get("Adams")).hasSameElementsAs(asList(adams, johns));
        assertThat(result.get("Kowalski")).hasSameElementsAs(asList(kowalski));
    }

    @org.junit.Test
    public void mergeTest() {
        Person kowalski = new Person("Andrew","Kowalski", 10);
        Person adams = new Person("Sara","Adams", 18);
        Person johns = new Person("Anna","Adams", 30);
        List<Person> collection = asList(kowalski, adams, johns);
        assertThat(NamesMerging.margingNamesStream(collection))
                .isEqualTo("Names: Andrew, Sara, Anna.");
    }

    @org.junit.Test
    public void ageTest() {
        Person kowalski = new Person("Andrew","Kowalski", 10);
        Person adams = new Person("Sara","Adams", 18);
        Person johns = new Person("Anna","Adams", 30);
        List<Person> collection = asList(kowalski, adams, johns);
        assertThat(Oldest.getOldestStream(collection)).isEqualToComparingFieldByField(johns);
    }


    @org.junit.Test
    public void mapWithListTest() {
        Person kowalski = new Person("Andrew","Kowalski", 10);
        Person adams = new Person("Sara","Adams", 18);
        Person johns = new Person("Anna","Adams", 30);
        List<Person> collection = asList(kowalski, adams, johns);
        Map<Boolean, List<Person>> result = MapWithList.mapWithListStream(collection);
        assertThat(result.get(true)).hasSameElementsAs(asList(adams, johns));
        assertThat(result.get(false)).hasSameElementsAs(asList(kowalski));
    }

    @Test
    public void sumTest() {
        List<Integer> numbers = asList(1, 2, 3, 4, 5);
        assertThat(CalculatingSum.calculateSumStream(numbers)).isEqualTo(1 + 2 + 3 + 4 + 5);
    }


}
