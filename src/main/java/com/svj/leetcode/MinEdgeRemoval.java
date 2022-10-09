package com.svj.leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MinEdgeRemoval {
    public int calcMinEdgeRemoval(int vertices, int edgeCount, int src, int dsn, List<int[]> edges) {
        Map<Integer, Map<Integer, Boolean>> adjList= new HashMap<>();
        for(int[] edge: edges){
            Map<Integer, Boolean> connections= adjList.getOrDefault(edge[0], new HashMap<>());
            connections.put(edge[1], true);
            adjList.put(edge[0], connections);
            connections= adjList.getOrDefault(edge[1], new HashMap<>());
            connections.put(edge[0], true);
            adjList.put(edge[1], connections);
        }
        Integer[] visited= new Integer[vertices+1];
        IntStream.range(1, vertices+1)
                .forEach(x-> visited[x]= new Integer(0));
        AtomicInteger minRemoval= new AtomicInteger();
        dfs(adjList, visited, src);
        IntStream.range(1, vertices+1)
                .forEach(x-> {
                    Optional<Map<Integer, Boolean>> optionalConnections= Optional.ofNullable(adjList.get(x));
                    if(optionalConnections.isPresent() && optionalConnections.get().get(dsn)!= null){
                      if(visited[x]== 2 && optionalConnections.get().get(dsn))
                          minRemoval.set(minRemoval.get() + 1);
                    }
                });
        return minRemoval.get();
    }

    private void dfs(Map<Integer, Map<Integer, Boolean>> adjList, Integer[] visited, int src) {
        if(visited[src]!= 0)
            return;
        visited[src]= 1;
        List<Integer> AdjNodes= adjList.getOrDefault(src, new HashMap<>()).keySet().stream().toList();
        for(int node: AdjNodes){
            if(visited[node]== 0)
                dfs(adjList, visited, node);
        }
        visited[src]= 2;
    }
}
