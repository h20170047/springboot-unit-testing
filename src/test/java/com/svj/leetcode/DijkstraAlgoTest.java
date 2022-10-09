package com.svj.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DijkstraAlgoTest {

    @Test
    public void g4gTest(){
        DijkstraAlgo algo= new DijkstraAlgo();
        List<Integer[]> edges= Arrays.asList(
                new Integer[]{0, 1, 4},
                new Integer[]{0, 7, 8},
                new Integer[]{1, 2, 8},
                new Integer[]{1, 7, 11},
                new Integer[]{2, 3, 7},
                new Integer[]{2, 8, 2},
                new Integer[]{2, 5, 4},
                new Integer[]{3, 4, 9},
                new Integer[]{3, 5, 14},
                new Integer[]{4, 5, 10},
                new Integer[]{5, 6, 2},
                new Integer[]{6, 7, 1},
                new Integer[]{6, 8, 6},
                new Integer[]{7, 8, 7}
        );
        assertThat(algo.calculateDist(edges, 9, 0, 8)).isEqualTo(14);
    }

    @Test
    public void ustTest(){
        DijkstraAlgo algo= new DijkstraAlgo();
        List<Integer[]> edges= Arrays.asList(
                new Integer[]{0, 1, 2},
                new Integer[]{0, 2, 7},
                new Integer[]{1, 2, 2},
                new Integer[]{2, 1, 3},
                new Integer[]{2, 3, 1},
                new Integer[]{1, 4, 5},
                new Integer[]{1, 3, 8},
                new Integer[]{4, 3, 5},
                new Integer[]{3, 4, 4}
        );
        assertThat(algo.calculateDist(edges, 5, 0, 4)).isEqualTo(7);
    }

    @Test
    public void mitTest(){
        DijkstraAlgo algo= new DijkstraAlgo();
        List<Integer[]> edges= Arrays.asList(
                new Integer[]{0, 1, 10},
                new Integer[]{0, 2, 3},
                new Integer[]{1, 2, 1},
                new Integer[]{2, 1, 4},
                new Integer[]{1, 3, 2},
                new Integer[]{2, 4, 2},
                new Integer[]{3, 4, 7},
                new Integer[]{4, 3, 9}
        );
        assertThat(algo.calculateDist(edges, 5, 0, 4)).isEqualTo(5);
    }

    @Test
    public void noPathTest(){
        DijkstraAlgo algo= new DijkstraAlgo();
        List<Integer[]> edges= Arrays.asList(
                new Integer[]{0, 1, 10},
                new Integer[]{0, 2, 3},
                new Integer[]{1, 2, 1},
                new Integer[]{2, 1, 4},
                new Integer[]{1, 3, 2},
                new Integer[]{2, 4, 2},
                new Integer[]{3, 4, 7},
                new Integer[]{4, 3, 9}
        );
        assertThat(algo.calculateDist(edges, 6, 0, 5)).isEqualTo(-1);
    }
}
