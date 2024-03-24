package com.leetcode.def.t0239;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 超出时间限制
 */
public class ErrorSolution1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int ansNum = nums.length - k + 1;
        int[] ans = new int[ansNum];


        //滑动窗口内的局部排序
        List<Integer> localSorting = new LinkedList<>();
        //首先插入前几个
        for (int i = 0; i < k; i++) {
            insert(localSorting, nums[i]);
        }
        ans[0] = localSorting.get(0);
        //循环判断
        for (int i = 0; i < ansNum-1; i++) {
            remove(localSorting, nums[i]);
            insert(localSorting, nums[i+k]);
            ans[i+1] = localSorting.get(0);
        }
        return ans;
    }

    private void insert(List<Integer> localSorting, int n) {
        boolean flag = false;
        for (int i = 0; i < localSorting.size(); i++) {
            if (localSorting.get(i) < n) {
                localSorting.add(i, n);
                flag = true;
                break;
            }
        }
        if (!flag) {
            localSorting.add(n);
        }
    }

    private void remove(List<Integer> localSorting, int n) {
        localSorting.remove(0);
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
//        int[] nums = {1};
//        int k = 1;
        int[] ints = new ErrorSolution1().maxSlidingWindow(nums, k);
        System.out.println("ints = " + Arrays.toString(ints));
    }

}
