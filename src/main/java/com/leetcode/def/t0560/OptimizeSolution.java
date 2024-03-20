package com.leetcode.def.t0560;

import java.util.HashMap;
import java.util.Map;

public class OptimizeSolution {

    public int subarraySum(int[] nums, int k) {
        //初始化合计值
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(0, 1);
        //
        int sum = 0;

        int count = 0;
        for (int num : nums) {
            sum += num;
            int diff = sum - k;
            if (map.containsKey(diff)) {
                count += map.get(diff);
            }

            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        int k = 0;
        int i = new OptimizeSolution().subarraySum(nums, k);
        System.out.println("i = " + i);
    }
}
