package com.svj.leetcode;

import java.util.List;

public class LargestCycle {
    public int getMaxCycle(int vertices, List<Integer> edge) {
        int count= 0, result= 0, nextNode= 0;
        for(int i=0; i<vertices; i++){
            boolean[] visited= new boolean[vertices];
            count= 0;
            nextNode= edge.get(i);
            while(nextNode!= -1){
                if(visited[nextNode]){
                    result= Math.max(result, count);
                    nextNode= -1;
                }else{
                    visited[nextNode]= true;
                    count++;
                    nextNode= edge.get(nextNode);
                }
            }
        }
        return result;
    }
}
