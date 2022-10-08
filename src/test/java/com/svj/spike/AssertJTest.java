package com.svj.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void learning(){
        List<Integer> numbers= Arrays.asList(11, 12, 15);

//        assertThat(numbers, hasSize(3));
        assertThat(numbers)
                .hasSize(3)
                .contains(11, 12)
                .allMatch(x-> x>10)
                .allMatch(x-> x<100)
                .noneMatch(x-> x<0);

        assertThat("").isEmpty();
        assertThat("ABCDE")
                .startsWith("ABC")
                .endsWith("CDE")
                .contains("BCD");
    }

}
