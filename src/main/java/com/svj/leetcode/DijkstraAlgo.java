package com.svj.leetcode;

import java.util.*;
import java.util.stream.IntStream;



class GraphEdge {
    Integer src;
    Integer dsn;
    Integer wt;
    GraphEdge(int s, int d, int w){
        src= s; dsn= d; wt= w;
    }
}

public class DijkstraAlgo {
    public int calculateDist(List<Integer[]> edges, int v, int src, int dsn) {
        int eCount= edges.size();
        Map<Integer, List<GraphEdge>> adjList= new HashMap<>();
        Map<Integer, Integer> minDist= new HashMap<>();
        Map<Integer, Set<Integer>> path= new HashMap<>();
        IntStream.range(0, v)
                        .forEach(k-> {
                            minDist.put(k, Integer.MAX_VALUE);
                            adjList.put(k, new LinkedList<>());
                            path.put(k, new HashSet<>());
                        });
        minDist.put(src, 0);
        int from, to, wt;
        for(Integer[] arr: edges){
            from= arr[0];
            to= arr[1];
            wt= arr[2];
            GraphEdge edge= new GraphEdge(from, to, wt);
            List<GraphEdge> neighbours= adjList.get(from);
            neighbours.add(edge);
        }
        boolean[] visited= new boolean[v];
        Queue<GraphEdge> queue= new PriorityQueue<>((GraphEdge e1, GraphEdge e2)-> e1.wt.compareTo(e2.wt));
        queue.add(new GraphEdge(src, src, 0));
        while (!queue.isEmpty()){
            GraphEdge visitingNode= queue.poll();
            if(visited[visitingNode.dsn]== false){
                Set<Integer> pathSoFar= new HashSet<>();
                pathSoFar.addAll(path.get(visitingNode.src));
                pathSoFar.add(visitingNode.dsn);
                path.put(visitingNode.dsn, pathSoFar);
                for(GraphEdge edge: adjList.get(visitingNode.dsn)){
                    from= edge.src; to= edge.dsn; wt= edge.wt;
                    if(visited[to]== false && minDist.get(from)+wt< minDist.get(to)){
                        // update weights, push to Queue
                        minDist.put(to, minDist.get(from)+wt);
                        queue.add(new GraphEdge(visitingNode.dsn, to, minDist.get(to)));
                    }
                }
                visited[visitingNode.dsn]= true;
            }
        }
        IntStream.range(0, v)
                .forEach(k-> System.out.println(
                        "Path from ".
                                concat(String.valueOf(src)).concat(" to ").concat(String.valueOf(k))
                                .concat(": ").concat(String.valueOf(path.get(k)))));
        return minDist.get(dsn)== Integer.MAX_VALUE? -1: minDist.get(dsn);
    }
}
