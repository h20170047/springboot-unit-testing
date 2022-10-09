package com.svj.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MinEdgeRemovalTest {
    @Test
    public void testg4g(){
        MinEdgeRemoval minEdgeRemoval= new MinEdgeRemoval();
        List<int[]> edges= Arrays.asList(
                new int[]{1,2},
                new int[]{5,2},
                new int[]{2,4},
                new int[]{2,3},
                new int[]{3,6},
                new int[]{4,6},
                new int[]{5,6}
        );
        int vertices= 6, edgeCount=7, src= 1, dsn= 6;
        int minEdge= minEdgeRemoval.calcMinEdgeRemoval(vertices, edgeCount, src, dsn, edges);
        assertThat(minEdge).isEqualTo(3);
    }

    @Test
    public void testDisjointGraph(){
        MinEdgeRemoval minEdgeRemoval= new MinEdgeRemoval();
        List<int[]> edges= Arrays.asList(
        );
        int vertices= 6, edgeCount=7, src= 1, dsn= 6;
        int minEdge= minEdgeRemoval.calcMinEdgeRemoval(vertices, edgeCount, src, dsn, edges);
        assertThat(minEdge).isEqualTo(0);
    }

    @Test
    public void testMyITLearnings(){
        MinEdgeRemoval minEdgeRemoval= new MinEdgeRemoval();
        List<int[]> edges= Arrays.asList(
                new int[]{1,3},
                new int[]{1,5},
                new int[]{3,5},
                new int[]{3,2},
                new int[]{2,6},
                new int[]{4,6},
                new int[]{4,5}
        );
        int vertices= 6, edgeCount=7, src= 1, dsn= 6;
        int minEdge= minEdgeRemoval.calcMinEdgeRemoval(vertices, edgeCount, src, dsn, edges);
        assertThat(minEdge).isEqualTo(2);
    }
}
