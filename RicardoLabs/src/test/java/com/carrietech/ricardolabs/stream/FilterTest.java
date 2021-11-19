package com.carrietech.ricardolabs.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FilterTest {

    @Test
    void filter_withParamExists_returnList() {
        List<String> list = Arrays.asList("Ricardo", "Erica", "Raissa", "Lucas");
        List<String> lucas = list.stream().filter(s -> s.equals("Lucas")).collect(Collectors.toList());
        lucas.forEach(System.out::println);
        System.out.println("Size: " + lucas.size());
        Assertions.assertNotNull(lucas);
        Assertions.assertEquals(1, lucas.size());
    }
}
