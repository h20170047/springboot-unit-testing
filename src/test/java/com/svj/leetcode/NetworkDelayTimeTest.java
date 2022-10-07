package com.svj.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkDelayTimeTest {

    @Test
    public void allNodesReachable(){
        NetworkDelayTime networkDelayTime= new NetworkDelayTime();
        int[][] times= {{2,1,1},{2,3,1},{3,4,1}};
        int n= 4, k=2;
        int timeDelay= networkDelayTime.networkDelayTime(times,  n,  k);
        assertEquals(2, timeDelay);
    }
}
