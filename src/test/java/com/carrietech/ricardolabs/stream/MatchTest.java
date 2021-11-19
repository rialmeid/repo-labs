package com.carrietech.ricardolabs.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MatchTest {

    private List<String> family;

    @BeforeEach
    void setUp() {
        family = Arrays.asList("Ricardo", "Erica", "Raissa", "Lucas");
    }

    @Test
    void allMatch_withoutAllContentsTrue_returnFalse() {
        boolean b = family.stream().allMatch(s -> {
            System.out.println("Verify ".concat(s));
            return s.contains("r");
        });
        Assertions.assertFalse(b);
    }

    @Test
    void anyMatch_withOnlyOneConditionTrue_returnTrue() {
        Assertions.assertTrue(family.stream().anyMatch(s -> s.length() == 6));
    }

    @Test
    void noneMatch_withoutCondition_returnTrue() {
        Assertions.assertTrue(family.stream().noneMatch(s -> s.length() == 10));
    }

    @Test
    void anyMatch_withObjectsAndExistsCondition_returnTrue() {
        Stream<Person> personStream = Stream.of(
                new Person("Ricardo", 41),
                new Person("Erica", 42),
                new Person("Raissa", 12),
                new Person("Lucas", 8)
        );

        Assertions.assertTrue(personStream.anyMatch(p -> p.getOld() > 40));
    }

    @Data
    @AllArgsConstructor
    private class Person {
        private String name;
        private int old;
    }
}
