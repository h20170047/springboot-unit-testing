package com.svj.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class TopologicalSortTest {

    @Test
    public void sortPresentTest(){
        TopologicalSort sort= new TopologicalSort();
        List<int[]> dependencies= Arrays.asList(
                new int[]{0, 5},
                new int[]{0, 4},
                new int[]{2, 5},
                new int[]{1, 4},
                new int[]{3, 2},
                new int[]{1, 3}
        );
        int numCourses= 6;
        List<Integer> ts = sort.findTS(numCourses, dependencies);
        List<Integer> elements= IntStream.range(0, numCourses)
                .boxed().toList();
        assertThat(ts).hasSameElementsAs(elements);
    }

    @Test
    public void sortNotPresentTest(){
        TopologicalSort sort= new TopologicalSort();
        List<int[]> dependencies= Arrays.asList(
                new int[]{1, 0},
                new int[]{0, 1}
        );
        int numCourses= 2;
        List<Integer> ts = sort.findTS(numCourses, dependencies);
        assertThat(ts).contains(-1);
    }

    @Test
    public void test39(){
        TopologicalSort sort= new TopologicalSort();
        List<int[]> dependencies= Arrays.asList(
                new int[]{1,4},
                new int[]{2,4},
                new int[]{3,1},
                new int[]{3,2}
        );
        int numCourses= 5;
        List<Integer> ts = sort.findTS(numCourses, dependencies);
        List<Integer> expected= IntStream.range(0, numCourses).boxed().collect(Collectors.toList());
        assertThat(ts).hasSameElementsAs(expected);
    }

    @Test
    public void test49(){
        TopologicalSort sort= new TopologicalSort();
        List<int[]> dependencies= Arrays.asList(
                new int[]{0,1},
                new int[]{0,2},
                new int[]{1,2}
        );
        int numCourses= 3;
        List<Integer> ts = sort.findTS(numCourses, dependencies);
        List<Integer> expected= IntStream.range(0, numCourses).boxed().collect(Collectors.toList());
        assertThat(ts).hasSameElementsAs(expected);
    }

    @Test
    public void test50(){
        TopologicalSort sort= new TopologicalSort();
        List<int[]> dependencies= Arrays.asList(
                new int[]{1,0},
                new int[]{0,3},
                new int[]{0,2},
                new int[]{3,2},
                new int[]{2,5},
                new int[]{4,5},
                new int[]{5,6},
                new int[]{2,4}
        );
        int numCourses= 7;
        List<Integer> ts = sort.findTS(numCourses, dependencies);
        List<Integer> expected= IntStream.range(0, numCourses).boxed().collect(Collectors.toList());
        assertThat(ts).hasSameElementsAs(expected);
    }
}
