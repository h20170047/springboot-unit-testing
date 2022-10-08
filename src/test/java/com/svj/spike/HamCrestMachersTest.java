package com.svj.spike;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamCrestMachersTest {

    @Test
    public void learning(){
        List<Integer> numbers= Arrays.asList(11, 12, 15);

        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(11, 12));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(100)));

        assertThat("", is(emptyString()));
        assertThat("ABCDE", containsString("ABC"));
        assertThat("ABCDE", startsWith("ABC"));
        assertThat("ABCDE", endsWith("CDE"));
    }

}
