package com.leetcode.def.t0560;

/**
 * 解答错误，因为存在负数，所以判断不生效
 */
public class ErrorSolution1 {
    public int subarraySum(int[] nums, int k) {
        //初始化两个指针
        int i = 0, j = 1;
        //初始化合计值
        int sum = nums[0];
        //计数统计
        int count = 0;

        while (i < j && j <= nums.length) {
            if (sum == k) {
                count++;
                if (i+1 < j) {
                    sum -= nums[i++];
                } else {
                    i++;
                }
                if (j+1 <= nums.length) {
                    sum += nums[j++];
                } else {
                    j++;
                }
            } else if (sum > k) {
                if (i+1 < j) {
                    sum -= nums[i++];
                } else {
                    i++;
                }
            } else {
                if (j+1 <= nums.length) {
                    sum += nums[j++];
                } else {
                    j++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        int k = 0;
        int i = new ErrorSolution1().subarraySum(nums, k);
        System.out.println("i = " + i);
    }
}
