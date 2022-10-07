package com.svj.leetcode;

import java.util.*;

class Edge{
    int destination;
    int distance;
    Edge(int dest, int dist){
        distance= dist;
        destination= dest;
    }
}
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> network= new HashMap<>();
        int timesLen= times.length, src, dest, dist;
        List<Edge> tempEdge;
        for(int count=0; count< timesLen; count++){
            src= times[count][0]; dest= times[count][1]; dist= times[count][2];
            tempEdge= network.getOrDefault(src, new LinkedList<>());
            tempEdge.add(new Edge(dest, dist));
        }
        int reachedStations= 1, timeTaken= 0, currentNode;
        Deque<Integer> stack= new ArrayDeque<>();
        stack.push(k);
        Map<Integer, Integer> visitStatus= new HashMap<>();
        Map<Integer, Integer> timeToNode= new HashMap<>();
        for(int node: network.keySet()){
            timeToNode.put(node, Integer.MAX_VALUE);
        }
        timeToNode.put(k, 0);
        while(!stack.isEmpty()){
            currentNode= stack.pop();
            for(Edge currentEdge: network.get(currentNode)){
                if(visitStatus.getOrDefault(currentEdge.destination, 0)== 0){
                    if(timeToNode.get(currentNode)+ currentEdge.distance< timeToNode.get(currentEdge.destination)){
                        timeToNode.put(currentEdge.destination, timeToNode.get(currentNode)+ currentEdge.distance);
                        stack.push(currentEdge.destination);
                        visitStatus.put(currentEdge.destination, 1);
                    }
                }
            }
        }
        return 0;
    }
}
