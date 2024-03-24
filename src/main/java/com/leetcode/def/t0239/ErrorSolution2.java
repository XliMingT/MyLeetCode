package com.leetcode.def.t0239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 优化了一下排序算法
 * 结果还是不正确，那可能是思路有问题
 */
public class ErrorSolution2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int ansNum = nums.length - k + 1;
        int[] ans = new int[ansNum];


        //滑动窗口内的局部排序
        List<Integer> localSorting = new ArrayList<>();
        //首先插入前几个
        for (int i = 0; i < k; i++) {
            insert(localSorting, nums[i]);
        }
        ans[0] = localSorting.get(0);
        //循环判断
        for (int i = 0; i < ansNum-1; i++) {
            localSorting.remove((Integer) nums[i]);
            insert(localSorting, nums[i+k]);
            ans[i+1] = localSorting.get(0);
        }
        return ans;
    }


    //优化一下排序算法
    private void insert(List<Integer> localSorting, int n) {
        int startNum = 0;
        int endNum = localSorting.size()-1;
        int midNum = (startNum + endNum) / 2;

        while (startNum < endNum) {
            if (localSorting.get(midNum) > n) {
                startNum = midNum + 1;
            } else {
                endNum = midNum;
            }
            midNum = (startNum + endNum) / 2;
        }
        if (localSorting.size() <= midNum) {
            localSorting.add(midNum, n);
        }else if (localSorting.get(midNum) < n) {
            localSorting.add(midNum, n);
        } else {
            localSorting.add(midNum+1, n);
        }

    }

    private void remove(List<Integer> localSorting, int n) {
        localSorting.remove(0);
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;
//        int[] nums = {1};
//        int k = 1;
        int[] nums = {4,-2};
        int k = 2;
        int[] ints = new ErrorSolution2().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

}
