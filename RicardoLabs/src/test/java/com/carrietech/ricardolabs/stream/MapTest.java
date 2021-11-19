package com.carrietech.ricardolabs.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MapTest {

    private List<String> family;

    @BeforeEach
    void setUp() {
        family = Arrays.asList("Ricardo", "Erica", "Raissa", "Lucas");
    }

    @Test
    void map_withAdditionalInfo_thenAddInfo() {
        Stream<String> stream = Arrays.stream(new String[]{"Ricardo", "Erica", "Raissa", "Lucas"});
        List<String> collect = stream.map(s -> s.concat(" Almeida")).collect(Collectors.toList());
        boolean almeida = collect.stream().allMatch(s -> s.contains("Almeida"));
        Assertions.assertTrue(almeida);
    }

    @Test
    void reduce_withValues_thenSum() {
        Stream<Double> stream = Stream.of(100d, 200d, 300d);
        Double reduce = stream.reduce(0d, (prim, segun) -> prim + segun);
        System.out.println(reduce);
    }
}
