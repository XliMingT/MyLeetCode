package com.leetcode.def.t0310;

import java.util.*;

/**
 * timeout
 */
public class ErrorSolution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //首先整理数据，将数据封装到集合里面方面后取用
        Map<Integer, Set<Integer>> edgesMapSet = transformEdgesInfo(edges);
        //循环判断
        int minHeight = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> treeHeightMapSet = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int height = getTreeHeight(edgesMapSet, i, -1);
            if (minHeight > height) {
                minHeight = height;
            }
            addMapSet(height, i, treeHeightMapSet);
        }

        Set<Integer> result = treeHeightMapSet.get(minHeight);
        if (result == null) {
            return Collections.emptyList();
        } else {
            return result.stream().toList();
        }
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

    private int getTreeHeight(Map<Integer, Set<Integer>> edgesMapSet,  int root, int pre) {

        //获取全部节点
        Set<Integer> integers = edgesMapSet.get(root);
        if (integers == null) {
            integers = Collections.emptySet();
        }
        List<Integer> heightList = new ArrayList<>();
        for (Integer node : integers) {
            if (node == pre) {
                continue;
            }
            heightList.add(getTreeHeight(edgesMapSet, node, root)+1);
        }
        if (heightList.isEmpty()) {
            return 0;
        } else {
            return Collections.max(heightList);
        }
    }

    public static void main(String[] args) {
//        int n = 4;
//        int[][] edges = {{1,0},{1,2},{1,3}};
//        int n = 6;
//        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        int n = 6;
        int[][] edges = {{0,1},{0,2},{0,3},{3,4},{4,5}};
        List<Integer> list = new ErrorSolution().findMinHeightTrees(n, edges);
        System.out.println("list = " + list);
    }
}
