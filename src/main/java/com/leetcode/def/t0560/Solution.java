package com.leetcode.def.t0560;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        //初始化合计值
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }

        int count = 0;
        for (int i = 0; i < sum.length; i++) {
            for (int j = i+1; j < sum.length; j++) {
                if (sum[j] - sum[i] == k) {
                    count++;
                }
            }
        }

        return count;
    }
}
