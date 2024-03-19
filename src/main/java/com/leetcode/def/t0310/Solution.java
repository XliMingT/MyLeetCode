package com.leetcode.def.t0310;

import java.util.*;

/**
 * 这个执行提交正确但是执行时间过长，使用内存也最高，都是击败5%用户，感觉什么也没优化
 */
public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        //首先整理数据，将数据封装到集合里面方面后取用
        Map<Integer, Set<Integer>> edgesMapSet = transformEdgesInfo(edges);
        //设：这个图中长度最远的两个节点为x和y
        //从0节点到最远的点，设为x
        List<Integer> farthestDist0X = getFarthestDist(0, edgesMapSet);
        //从x节点到最远的点，设为y
        List<Integer> farthestDistXY = getFarthestDist(farthestDist0X.get(farthestDist0X.size()-1), edgesMapSet);
        //获取中间两个点或者一个点
        List<Integer> returnList = new ArrayList<>();
        if (farthestDistXY.size() % 2 == 0) {
            returnList.add(farthestDistXY.get(farthestDistXY.size()/2 - 1));
            returnList.add(farthestDistXY.get(farthestDistXY.size()/2));
        } else {
            returnList.add(farthestDistXY.get((farthestDistXY.size()+1)/2 - 1));
        }
        return returnList;
    }

    private List<Integer> getFarthestDist(int node, Map<Integer, Set<Integer>> edgesMapSet) {
        List<Integer> longestPath = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> currentPath = new ArrayList<>();
        //深度
        dfs(node, edgesMapSet, visited, currentPath, longestPath);

        return longestPath;
    }

    private static void dfs(int node, Map<Integer, Set<Integer>> edgesMapSet, Set<Integer> visited,
                            List<Integer> currentPath, List<Integer> longestPath) {
        visited.add(node);
        currentPath.add(node);

        if (currentPath.size() > longestPath.size()) {
            longestPath.clear();
            longestPath.addAll(currentPath);
        }

        for (int neighbor : edgesMapSet.getOrDefault(node, new HashSet<>())) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, edgesMapSet, visited, currentPath, longestPath);
            }
        }

        currentPath.remove(currentPath.size() - 1);
        visited.remove(node);
    }


    private Map<Integer, Set<Integer>> transformEdgesInfo(int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>(edges.length);
        for (int[] edge : edges) {
            addMapSet(edge[0], edge[1], map);
            addMapSet(edge[1], edge[0], map);
        }
        return map;
    }

    private void addMapSet(Integer key, Integer value, Map<Integer, Set<Integer>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            map.put(key, new HashSet<>());
            map.get(key).add(value);
        }
    }

    public static void main(String[] args) {
//        int n = 4;
//        int[][] edges = {{1,0},{1,2},{1,3}};
//        int n = 6;
//        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        int n = 6;
        int[][] edges = {{0,1},{0,2},{0,3},{3,4},{4,5}};
        List<Integer> list = new Solution().findMinHeightTrees(n, edges);
        System.out.println("list = " + list);
    }
}
