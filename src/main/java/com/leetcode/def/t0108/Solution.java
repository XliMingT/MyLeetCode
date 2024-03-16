package com.leetcode.def.t0108;

/**
 * @author XliMing
 * @date 2023/6/14 20:04
 */
public class Solution {

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		//长度
		int length = nums.length;
		//开始结束
		int start = 0;
		int end = length;

		TreeNode treeNode = printTree(start, end, nums);

		return treeNode;
	}

	private TreeNode printTree(int start, int end, int[] nums) {
		if (start == end) {
			return null;
		}
		TreeNode treeNode = new TreeNode();
		int mid = (start + end) / 2;
		treeNode.val = nums[mid];
		treeNode.left = printTree(start, mid, nums);
		treeNode.right = printTree(mid+1, end, nums);
		return treeNode;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {-10,-3,0,5,9};
		TreeNode treeNode = solution.sortedArrayToBST(nums);
		System.out.println("treeNode = " + treeNode);
	}
}
