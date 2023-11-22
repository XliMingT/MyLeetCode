package com.leetcode.t0293;

/**
 * @author XliMing
 * @date 2023/11/22 18:16
 */
public class Solution {
	public static void main(String[] args) {
		int[] ints = { 2,1 };
		new Solution().moveZeroes(ints);
		System.out.println("ints = " + ints);
	}
	public void moveZeroes(int[] nums) {
		int j = 0;
		for (int i = j; i < nums.length; i++) {
			 if (nums[i] != 0)  {
				 if (i != j) {
					 int temp = nums[j];
					 nums[j] = nums[i];
					 nums[i] = temp;
				 }
				 j++;
			 }
		}
	}
}
