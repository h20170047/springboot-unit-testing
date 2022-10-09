package com.svj.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class TopologicalSort {
    public List<Integer> findTS(int numCourses, List<int[]> dependencies) {
        Integer[] visitStatus= new Integer[numCourses];
        Map<Integer, List<Integer>> adjList= new HashMap<>();
        IntStream.range(0, numCourses)
                .forEach(x-> {
                    adjList.put(x, new LinkedList<>());
                    visitStatus[x] = 0;
                });
        List<Integer> result= new LinkedList<>();
        int dependent, free;
        for(int[] adj: dependencies){
            dependent= adj[0];
            free= adj[1];
            List<Integer> neighbors= adjList.get(dependent);
            neighbors.add(free);
            adjList.put(dependent, neighbors);
        }
        for(int i=0; i<numCourses; i++){
            visitStatus[i]= 1;
            List<Integer> neighbors= adjList.get(i);
            for(int neighbor: neighbors){
                if(visitStatus[neighbor]== 1)
                    return Arrays.asList(-1);
                else if(visitStatus[neighbor]== 0){
                    int errrorStatus = processNode(neighbor, visitStatus, result, adjList);
                    if(errrorStatus== -1)
                        return Arrays.asList(-1);
                }
            }
            result.add(i);
            visitStatus[i]= 2;
        }
        return result;
    }

    private int processNode(int i, Integer[] visitStatus, List<Integer> result, Map<Integer, List<Integer>> adjList) {
        visitStatus[i]= 1;
        List<Integer> neighbors= adjList.get(i);
        for(Integer neighbor: neighbors){
            if(visitStatus[neighbor]== 1)
                return -1;
            else if(visitStatus[neighbor]== 0){
                int errrorStatus = processNode(neighbor, visitStatus, result, adjList);
                if(errrorStatus== -1)
                    return -1;
            }
        }
        result.add(i);
        visitStatus[i]= 2;
        return 0;
    }
}
