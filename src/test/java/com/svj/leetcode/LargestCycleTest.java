package com.svj.leetcode;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LargestCycleTest {
    @Test
    @Disabled
    public void test1(){
        int vertices= 23;
        List<Integer> edge= Arrays.asList(
                4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21
        );
        LargestCycle largestCycle= new LargestCycle();
        assertThat(largestCycle.getMaxCycle(vertices, edge)).isEqualTo(6);
    }

    @Test
    public void test2(){
        int vertices= 5;
        List<Integer> edge= Arrays.asList(
                -1, 2, 3, 4, 1
        );
        LargestCycle largestCycle= new LargestCycle();
        assertThat(largestCycle.getMaxCycle(vertices, edge)).isEqualTo(4);
    }

    @Test
    public void test3(){
        int vertices= 10;
        List<Integer> edge= Arrays.asList(
                -1, 4, -1, -1, 6, -1, 7, 8, 9, 1
        );
        LargestCycle largestCycle= new LargestCycle();
        assertThat(largestCycle.getMaxCycle(vertices, edge)).isEqualTo(6);
    }

    @Test
    public void test4(){
        int vertices= 7;
        List<Integer> edge= Arrays.asList(
                -1, 2, 1, 4, 3, 6, 5
        );
        LargestCycle largestCycle= new LargestCycle();
        assertThat(largestCycle.getMaxCycle(vertices, edge)).isEqualTo(2);
    }

    @Test
    public void test5(){
        int vertices= 6;
        List<Integer> edge= Arrays.asList(
                1, 2, 3, 4, 5, 0
        );
        LargestCycle largestCycle= new LargestCycle();
        assertThat(largestCycle.getMaxCycle(vertices, edge)).isEqualTo(6);
    }
}
